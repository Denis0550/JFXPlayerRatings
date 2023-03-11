package com.densor.jfxplayerratings;

import com.densor.jfxplayerratings.entity.MunPlayers;
import com.densor.jfxplayerratings.entity.PlayerRatings;
import com.densor.jfxplayerratings.entity.Ratings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.hibernate.SessionFactory;

import java.math.BigInteger;
import java.util.List;

public class MainController {

    private SessionFactory session;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private TextField textInput;

    @FXML
    private Label lbl1;


    /// new part

    @FXML
    private TextField textInputGameWeek;
    @FXML
    private TextField textInputSquadNumber;
    @FXML
    private TextField textInputPlayerRating;

    @FXML
    private Label labelGameWeek;
    @FXML
    private Label labelSquadNumber;
    @FXML
    private Label labelPlayerRating;
    @FXML
    private Label labelStatus;
    @FXML
    private Label labelStatus2;



    @FXML
    private Button setButton;
    @FXML
    private Button addToDbButton;
    @FXML
    private Button button1;
    @FXML
    private ChoiceBox<String> box1;
    @FXML
    private ChoiceBox<String> box2;
    @FXML
    private ImageView img1;
    @FXML
    private LineChart<?, ?> chart;




    public MainController(SessionFactory session) {
        this.session = session;
    }




    // specific knowledge to JavaFX
    public void initialize() {


        var ses1 = session.openSession();
        List<String> playerNames = ses1.createQuery("Select m.lastName FROM MunPlayers m", String.class).getResultList();
        ses1.close();
        ObservableList<String> observableList1 = FXCollections.observableArrayList(playerNames);
        this.box1.setItems(observableList1);
        this.box2.setItems(observableList1);


        this.btn2.setOnAction(e ->lbl1.setText(textInput.getText()));
        this.btn1.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var rating = new Ratings();
            rating.setText(textInput.getText());
            ses.save(rating);

            tx.commit();
            ses.close();
        });

        this.setButton.setOnAction(e -> {

            labelGameWeek.setText(textInputGameWeek.getText());
            labelSquadNumber.setText(textInputSquadNumber.getText());
            labelPlayerRating.setText(textInputPlayerRating.getText());
            labelStatus2.setText(box1.getValue());
        });

        this.addToDbButton.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var rating = new PlayerRatings();
            rating.setGameWeek(Integer.parseInt(textInputGameWeek.getText()));
            rating.setLastName(box1.getValue());
            rating.setPlayerRating(Integer.parseInt(textInputPlayerRating.getText()));

            ses.save(rating);

            tx.commit();
            ses.close();
        });

        this.button1.setOnAction(e -> {
            var ses = session.openSession();

            List<String> name = ses.createQuery("Select m.lastName FROM MunPlayers m where sqNumber = :sqParameter", String.class)
                .setParameter("sqParameter", 8)
                .getResultList();

            labelStatus.setText(name.toString().replaceAll("[^a-zA-Z\\d\\s:]", "").concat(" scores"));

            ses.close();
        });




        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",5));
        series.getData().add(new XYChart.Data("2",4));
        series.getData().add(new XYChart.Data("3",8));
        series.getData().add(new XYChart.Data("4",8));

        chart.getData().add(series);


    }


}