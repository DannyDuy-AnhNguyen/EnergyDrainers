package com.example.energiedrainers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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

    //Isn't working yet🥲
    @FXML
    public void handleLinkAction(MouseEvent event){
        System.out.println("Link has been clicked.");
        try {
            // Load the next page (for example, a login page or registration page)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterPage.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (Exception e) {
            e.printStackTrace();  // Handle the exception properly
        }
    }
}
