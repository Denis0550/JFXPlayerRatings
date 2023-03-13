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
    private Label labelGameWeek;
    @FXML
    private Label labelPlayerRating;
    @FXML
    private Label labelPlayerLastName;


    @FXML
    private Button setButton;
    @FXML
    private Button addToDbButton;
    @FXML
    private Button loadButton;
    @FXML
    private ChoiceBox<String> choiceBoxPlayerLastNameForDb;
    @FXML
    private ChoiceBox<String> choiceBoxPlayerLastNameForChart;
    @FXML
    private ComboBox<Integer> comboBoxWeeks;
    @FXML
    private ComboBox<Integer> comboBoxRating;
    @FXML
    private ImageView img1;
    @FXML
    private LineChart<String, Integer> chart;



    public MainController(SessionFactory session) {
        this.session = session;
    }



    // specific knowledge to JavaFX
    public void initialize() {

        // Fields are populated

        ObservableList<Integer> observableListOfWeeks = FXCollections.observableArrayList();
        for (int i = 1; i <= 38 ; i++) {
            observableListOfWeeks.add(i);
        }
        this.comboBoxWeeks.setItems(observableListOfWeeks);

        ObservableList<Integer> observableListOfRatings = FXCollections.observableArrayList();
        for (int i = 1; i <= 10 ; i++) {
            observableListOfRatings.add(i);
        }
        this.comboBoxRating.setItems(observableListOfRatings);


        var ses1 = session.openSession();
        List<String> playerNames = ses1.createQuery("Select m.lastName FROM MunPlayers m", String.class).getResultList();
        ses1.close();
        ObservableList<String> observableList1 = FXCollections.observableArrayList(playerNames);

        this.choiceBoxPlayerLastNameForDb.setItems(observableList1);
        this.choiceBoxPlayerLastNameForChart.setItems(observableList1);


        // Buttons / Actions

        this.setButton.setOnAction(e -> {
            labelGameWeek.setText(Integer.toString(comboBoxWeeks.getValue()));
            labelPlayerLastName.setText(choiceBoxPlayerLastNameForDb.getValue());
            labelPlayerRating.setText(Integer.toString(comboBoxRating.getValue()));

        });

        this.addToDbButton.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var rating = new PlayerRatings();
            rating.setGameWeek(comboBoxWeeks.getValue());
            rating.setLastName(choiceBoxPlayerLastNameForDb.getValue());
            rating.setPlayerRating(comboBoxRating.getValue());


            ses.save(rating);

            tx.commit();
            ses.close();
        });

        this.loadButton.setOnAction(e -> {
            var ses = session.openSession();
            List<Integer> numbers = ses.createQuery("Select p.playerRating FROM PlayerRatings p where lastName = :nameParameter", Integer.class)
                    .setParameter("nameParameter", choiceBoxPlayerLastNameForChart.getValue())
                    .getResultList();
            ses.close();

            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(choiceBoxPlayerLastNameForChart.getValue());

            Integer num1 = 0;
            for (Integer num : numbers) {
                System.out.print(num + ", ");
                num1++;
                series.getData().add(new XYChart.Data<>(num1.toString(), num));
            }
            chart.getData().add(series);
        });

    }

}