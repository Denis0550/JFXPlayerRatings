module com.densor.jfxplayerratings {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;


    opens com.densor.jfxplayerratings to javafx.fxml;
    exports com.densor.jfxplayerratings;
    exports com.densor.jfxplayerratings.entity;
    opens com.densor.jfxplayerratings.entity to javafx.fxml;
}