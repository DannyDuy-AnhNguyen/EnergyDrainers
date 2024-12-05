package com.example.energiedrainers.Controller;

import com.example.energiedrainers.Session.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerHomeNotLoggedIn {

    @FXML
    private Button createAccountButton;

    @FXML
    private Button loginButton; // Correct type: Button

    @FXML
    private Text welcomeText;

    @FXML
    private Label statusLabel; // New label for feedback messages

    @FXML
    private Label statusLabelTwo; // New label for feedback messages

    // Initialize method for setup
    @FXML
    public void initialize() {
        // Perform any setup tasks here
        welcomeText.setText("Welkom bij Sundrainers!");
    }

    // Handle login button action
    @FXML
    public void handleLoginButtonAction(ActionEvent event) {
        System.out.println("Login button clicked!");
        System.out.println("Session data after clearing: " + UserSession.getSession());
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/LoginPage.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle create account button action
    @FXML
    public void handleCreateAccountButtonAction(ActionEvent event) {
        System.out.println("Create Account button clicked!");
        System.out.println("Session data after clearing: " + UserSession.getSession());
        statusLabelTwo.setText("Account creation started!");
        // Add your account creation logic here
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/RegisterPage.fxml"));
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
