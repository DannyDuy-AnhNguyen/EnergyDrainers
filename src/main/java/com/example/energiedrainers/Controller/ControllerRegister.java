package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

// For hashing the password
import org.mindrot.jbcrypt.BCrypt;

// For password validation
import java.util.regex.Pattern;

public class ControllerRegister {

    @FXML
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection = databaseConnection.getConnection();

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

    @FXML
    private Label errorLabel;

    @FXML
    private Label errorLabel2;

    @FXML
    private Label errorLabel3;


    // Regex voor wachtwoordregels
    private static final String PASSWORD_PATTERN =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    // Methode om wachtwoord te valideren
    private boolean isPasswordValid(String password) {
        return password != null && pattern.matcher(password).matches();
    }

    // Methode voor hashing het wachtwoord
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @FXML
    public void handleRegisterAction(ActionEvent event) {
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String userName = username.getText();
        String phone = phoneNumber.getText();
        String password = passwordField.getText();
        String repeatPassword = repeatPasswordField.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || phone.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            errorLabel2.setText("Please fill all the fields");
            errorLabel3.setText("");
            errorLabel.setText("");
            return;
        }

        else if (!password.equals(repeatPassword)) {
            errorLabel3.setText("Passwords do not match.");
            errorLabel2.setText("");
            errorLabel.setText("");
            return;
        }

        else if (!isPasswordValid(password)) {
            errorLabel.setText("Password must be at least 12 characters, include a number, a special symbol, and an uppercase letter.");
            errorLabel2.setText("");
            errorLabel3.setText("");
            return;
        }

        registerUser(firstName, lastName, userName, phone, password, event);
    }

    private void registerUser(String firstName, String lastName, String userName, String phone, String password, ActionEvent event) {
        connection = databaseConnection.getConnection();

        String insertQuery = "INSERT INTO klant (Telefoonnummer, Voornaam, Achternaam, Gebruikersnaam, Wachtwoord) VALUES (?, ?, ?, ?, ?)";

        String hashedPassword = hashPassword(password);

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, userName);
            preparedStatement.setString(5, hashedPassword);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully!");

                // Redirect to home page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/HomeLoggedIn.fxml"));
                Scene homeScene = new Scene(loader.load());
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(homeScene);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error registering user.");
        }
    }

    @FXML
    public void handleLinkAction(MouseEvent event) {
        System.out.println("Link has been clicked.");
        try {
            // Load the login page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/LoginPage.fxml"));
            Scene homeScene = new Scene(loader.load());
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
