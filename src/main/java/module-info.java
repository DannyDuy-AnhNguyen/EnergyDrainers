module com.example.energiedrainers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.energiedrainers to javafx.fxml;
    exports com.example.energiedrainers;

}