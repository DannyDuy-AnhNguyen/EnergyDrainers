package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Library
import org.mindrot.jbcrypt.BCrypt;

//

public class ControllerLogin {

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel4;

    @FXML
    private Label errorLabel5;

    @FXML
    private Label errorLabel6;




//    @FXML
//    private TextField loginMessageLabel;

    // Validate if the username and password fields are non-blank
    private boolean isInputValid() {
        return !userName.getText().isBlank() && !passwordField.getText().isBlank();
    }

    // Triggered when the login button is clicked
    @FXML
    public void handleLoginButtonOnAction(ActionEvent event) {
        String username = userName.getText();
        String password = passwordField.getText();






        if (!isInputValid()) {
            errorLabel4.setText("Please enter both username and password.");
            errorLabel5.setText("");
            errorLabel6.setText("");
        } else {
            System.out.println("Check credentials"); // Clear any previous messages
            validateLogin(username, password, event);
        }
    }

    // Navigates to the registration page when the link is clicked
    @FXML
    public void handleLinkAction(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/RegisterPage.fxml"));
            Scene registerScene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(registerScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyPassword(String enteredPassword, String storedHash) {
        System.out.println(enteredPassword +"\n"+ storedHash);
        return BCrypt.checkpw(enteredPassword, storedHash);
    }


    // Validates login credentials
    public void validateLogin(String username, String password, ActionEvent event) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String verifyLoginQuery = "SELECT Wachtwoord FROM klant WHERE Gebruikersnaam = ?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLoginQuery)) {
            preparedStatement.setString(1, username);

            ResultSet queryResult = preparedStatement.executeQuery();

            // If a result is found, proceed with the login
            if (queryResult.next()) {
                // Get the hashed password from the database
                String storedHash = queryResult.getString("Wachtwoord");

                // Verify the entered password against the stored hash using bcrypt
                if (verifyPassword(password, storedHash)) {
                    System.out.println("Login Successful!");

                    // Load the home scene after successful login
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/HomeLoggedIn.fxml"));
                    Scene homeScene = new Scene(loader.load());

                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(homeScene);
                } else {

                }
            } else {
                errorLabel5.setText("Invalid username or password.");
                errorLabel4.setText("");
                errorLabel6.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel6.setText("An error occurred while logging in.");
            errorLabel4.setText("");
            errorLabel5.setText("");


        }
    }

}
