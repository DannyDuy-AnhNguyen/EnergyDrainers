module com.example.energiedrainers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.energiedrainers to javafx.fxml;
    exports com.example.energiedrainers;
}