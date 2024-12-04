package com.example.energiedrainers.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLogin extends Application {

    @Override
    public void start(Stage loginStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/LoginPage.fxml"));
        Scene scene = new Scene(loader.load(), 700, 895);

        loginStage.setTitle("Sundrainers App");
        loginStage.setScene(scene);
        loginStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
