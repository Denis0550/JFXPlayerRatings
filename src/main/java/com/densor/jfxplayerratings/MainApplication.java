package com.densor.jfxplayerratings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        var session = HibernateUtil.getSessionFactory();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));

        var mainController = new MainController(session);
        fxmlLoader.setController(mainController);

        Scene scene = new Scene(fxmlLoader.load(), 600, 700);
        stage.setTitle("Manchester United Player Ratings");
        stage.setScene(scene);
        stage.show();



    }

    @Override
    public void stop() throws Exception {
        HibernateUtil.shutdown();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}