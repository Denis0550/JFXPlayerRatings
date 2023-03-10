package com.densor.jfxplayerratings;

import com.densor.jfxplayerratings.entity.MunPlayers;
import com.densor.jfxplayerratings.entity.PlayerRatings;
import com.densor.jfxplayerratings.entity.Ratings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Button setButton;
    @FXML
    private Button addToDbButton;

    @FXML
    private Button button1;

    @FXML
    private ChoiceBox<String> box1;

    private ObservableList<String> observableList = FXCollections.observableArrayList("David de Gea", "Jadon Sancho");



    public MainController(SessionFactory session) {
        this.session = session;

    }

    // specific knowledge to JavaFX
    public void initialize() {
        this.box1.setItems(observableList);

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

            var ses = session.openSession();

            List<String> name = ses.createQuery("Select m.lastName FROM MunPlayers m where sqNumber = :sqParameter", String.class)
                    .setParameter("sqParameter", textInputSquadNumber.getText())
                    .getResultList();
            ses.close();

//            labelStatus.setText("Game week "+textInputGameWeek.getText()+" " + name.toString() + "..... " + textInputPlayerRating.getText());

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

        this.button1.setOnAction(e -> {
            var ses = session.openSession();

        List<String> name = ses.createQuery("Select m.lastName FROM MunPlayers m where sqNumber = :sqParameter", String.class)
                .setParameter("sqParameter", 8)
                .getResultList();

            labelStatus.setText(name.toString().replaceAll("[^a-zA-Z\\d\\s:]", "").concat(" scores"));

            ses.close();
        });





    }


}