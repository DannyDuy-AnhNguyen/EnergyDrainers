module com.example.energiedrainers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jbcrypt;


    opens com.example.energiedrainers to javafx.fxml;
    exports com.example.energiedrainers;

}