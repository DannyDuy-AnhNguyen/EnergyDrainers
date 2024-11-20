package com.example.energiedrainers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HomeNotLoggedInController {

    // Link UI elements using @FXML annotation
    @FXML
    private Button loginButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Text welcomeText;

    // Initialize method for setup
    @FXML
    public void initialize() {
        // Perform any setup tasks here
        welcomeText.setText("Welkom bij Sundrainers!");
    }

    // Handle login button action
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        System.out.println("Login button clicked!");
        // Add your login logic here
    }

    // Handle create account button action
    @FXML
    private void handleCreateAccountButtonAction(ActionEvent event) {
        System.out.println("Create Account button clicked!");
        // Add your account creation logic here
    }
}
