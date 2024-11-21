package com.example.energiedrainers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class ControllerLogin {
//    For the users who can login into their account
    @FXML
    private TextField username;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void checkDataInput(ActionEvent event){
        String password = passwordField.getText();
        System.out.println("Password entered: " + password);

        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeLoggedIn.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
