package com.example.energiedrainers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerLogin {

    @FXML
    private TextField username;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginMessageLabel;

    // Validate if the username and password fields are non-blank
    private boolean isInputValid() {
        return !username.getText().isBlank() && !passwordField.getText().isBlank();
    }

    // Triggered when the login button is clicked
    @FXML
    public void loginButtonOnAction(ActionEvent event) {
        if (!isInputValid()) {
            loginMessageLabel.setText("Please enter both username and password.");
        } else {
            loginMessageLabel.setText(""); // Clear any previous messages
            validateLogin(username.getText(), passwordField.getText(), event);
        }
    }

    // Navigates to the registration page when the link is clicked
    @FXML
    public void handleLinkAction(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterPage.fxml"));
            Scene registerScene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(registerScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Validates login credentials
    public void validateLogin(String username, String password, ActionEvent event) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String verifyLoginQuery = "SELECT * FROM klant WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLoginQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet queryResult = preparedStatement.executeQuery();

            // If a result is found, proceed with the login
            if (queryResult.next()) {
                loginMessageLabel.setText("Login Successful!");

                // Load the home scene after successful login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeLoggedIn.fxml"));
                Scene homeScene = new Scene(loader.load());

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(homeScene);
            } else {
                loginMessageLabel.setText("Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginMessageLabel.setText("An error occurred while logging in.");
        }
    }
}
