module com.densor.jfxplayerratings {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
//    requires lombok;


    opens com.densor.jfxplayerratings to javafx.fxml, org.hibernate.orm.core;
    exports com.densor.jfxplayerratings;
    exports com.densor.jfxplayerratings.entity;
    opens com.densor.jfxplayerratings.entity to javafx.fxml;
}