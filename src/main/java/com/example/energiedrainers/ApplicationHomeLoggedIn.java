package com.example.energiedrainers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationHomeLoggedIn extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeLoggedIn.fxml"));
        Scene scene = new Scene(loader.load(), 700, 895);

        primaryStage.setTitle("Sundrainers App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
