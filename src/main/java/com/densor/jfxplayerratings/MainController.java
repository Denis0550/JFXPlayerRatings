package com.densor.jfxplayerratings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Button btn1;

    @FXML
    private Label lbl1;

    @FXML
    void Clicks(ActionEvent event) {
        lbl1.setText("testing connection");

    }
}