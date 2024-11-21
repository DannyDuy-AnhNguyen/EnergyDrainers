package com.example.energiedrainers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ControllerRegister {

//    Referred to other links
    @FXML
    private Label referToLogin;

//Isn't working yet🥲
    @FXML
    public void handleLinkAction(javafx.event.ActionEvent event){
        System.out.println("Link has been clicked.");
        try {
            // Load the next page (for example, a login page or registration page)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root = loader.load();

            // Create the new scene and set it on the current stage
            Scene newScene = new Scene(root, 700, 895);
            Stage stage = (Stage) event.getSource(); // Get the current stage
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();  // Handle the exception properly
        }
    }

    //   register information to put it inside the database.
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private TextField phoneNumber;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField repeatPasswordField;

    public void handlePasswordInput(ActionEvent event){
        String password = passwordField.getText();
        System.out.println("Password entered: " + password);

        String repeatPassword = repeatPasswordField.getText();
        System.out.println("Repeat password entered: " + repeatPassword);

        if(password.equals(repeatPassword)){
            System.out.println("Welcome!");
//            If the password and repeat password matches, it will provide the user to the home page
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
        } else {
            System.out.println("Password doesn't match");
        }
    }

}
