package com.densor.jfxplayerratings;

import com.densor.jfxplayerratings.entity.Ratings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

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
    }


}