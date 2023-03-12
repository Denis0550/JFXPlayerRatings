package com.densor.jfxplayerratings;

import com.densor.jfxplayerratings.entity.PlayerRatings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.hibernate.SessionFactory;

import java.util.List;

public class MainController {

    private SessionFactory session;

    @FXML
    private TextField textInputPlayerRating;

    @FXML
    private Label labelGameWeek;
    @FXML
    private Label labelPlayerRating;
    @FXML
    private Label labelStatus2;


    @FXML
    private Button setButton;
    @FXML
    private Button addToDbButton;
    @FXML
    private Button loadButton;
    @FXML
    private ChoiceBox<String> box1;
    @FXML
    private ChoiceBox<String> box2;
    @FXML
    private ComboBox<Integer> comboBoxWeeks;
    @FXML
    private ImageView img1;
    @FXML
    private LineChart<Integer, Integer> chart;



    public MainController(SessionFactory session) {
        this.session = session;
    }



    // specific knowledge to JavaFX
    public void initialize() {

        ObservableList<Integer> observableListOfWeeks = FXCollections.observableArrayList();
        for (int i = 1; i <= 38 ; i++) {
            observableListOfWeeks.add(i);
        }
        this.comboBoxWeeks.setItems(observableListOfWeeks);

        var ses1 = session.openSession();
        List<String> playerNames = ses1.createQuery("Select m.lastName FROM MunPlayers m", String.class).getResultList();
        ses1.close();
        ObservableList<String> observableList1 = FXCollections.observableArrayList(playerNames);
        this.box1.setItems(observableList1);
        this.box2.setItems(observableList1);



        this.setButton.setOnAction(e -> {

            labelGameWeek.setText(Integer.toString(comboBoxWeeks.getValue()));
            labelPlayerRating.setText(textInputPlayerRating.getText());
            labelStatus2.setText(box1.getValue());
        });

        this.addToDbButton.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var rating = new PlayerRatings();
            rating.setGameWeek(comboBoxWeeks.getValue());
            rating.setLastName(box1.getValue());
            rating.setPlayerRating(Integer.parseInt(textInputPlayerRating.getText()));

            ses.save(rating);

            tx.commit();
            ses.close();
        });


        this.loadButton.setOnAction(e -> {
            var ses = session.openSession();

            List<Integer> numbers = ses.createQuery("Select p.playerRating FROM PlayerRatings p where lastName = :nameParameter", Integer.class)
                    .setParameter("nameParameter", box2.getValue())
                    .getResultList();
            ses.close();

            XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
            series.setName(box2.getValue());


            Integer num1 = 0;
            for (Integer num : numbers) {
                System.out.print(num.intValue() + ", ");
                num1++;
                series.getData().add(new XYChart.Data(num1.toString(),num.intValue()));
            }

            chart.getData().add(series);

        });



    }


}