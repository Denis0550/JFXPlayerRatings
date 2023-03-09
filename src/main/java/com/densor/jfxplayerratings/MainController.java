package com.densor.jfxplayerratings;

import com.densor.jfxplayerratings.entity.PlayerRatings;
import com.densor.jfxplayerratings.entity.Ratings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

import java.math.BigInteger;

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
    private Button setButton;
    @FXML
    private Button addToDbButton;



    public MainController(SessionFactory session) {
        this.session = session;

    }

    // specific knowledge to JavaFX
    public void initialize() {
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

        });

        this.addToDbButton.setOnAction(e -> {
            var ses = session.openSession();
            var tx = ses.beginTransaction();

            var rating = new PlayerRatings();
            rating.setGameWeek(Integer.parseInt(textInputGameWeek.getText()));
            rating.setSquadNumber(Integer.parseInt(textInputSquadNumber.getText()));
            rating.setPlayerRating(Integer.parseInt(textInputPlayerRating.getText()));

            ses.save(rating);

            tx.commit();
            ses.close();
        });





    }


}