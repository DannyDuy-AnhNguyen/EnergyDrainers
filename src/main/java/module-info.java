module com.example.energiedrainers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jbcrypt;


    opens com.example.energiedrainers to javafx.fxml;
    exports com.example.energiedrainers.DatabaseAndSQL;
    exports com.example.energiedrainers.Application;
    opens com.example.energiedrainers.Application to javafx.fxml;
    exports com.example.energiedrainers.Controller;
    opens com.example.energiedrainers.Controller to javafx.fxml;
    exports com.example.energiedrainers.Session;
    opens com.example.energiedrainers.Session to javafx.fxml;

}