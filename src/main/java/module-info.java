module com.densor.jfxplayerratings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.densor.jfxplayerratings to javafx.fxml;
    exports com.densor.jfxplayerratings;
}