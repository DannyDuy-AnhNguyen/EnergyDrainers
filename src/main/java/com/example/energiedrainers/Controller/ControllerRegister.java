package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

//For hashing the password
import org.mindrot.jbcrypt.BCrypt;


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

////    This function is for hashing the password🙂

    // This function is for hashing the password with bcrypt
    public String hashPassword(String password) {
        // Generate a salt and hash the password using bcrypt
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
            System.out.println("Please fill all the fields.");
            return; // Exit if fields are empty
        }

        if (!password.equals(repeatPassword)) {
            System.out.println("Passwords do not match.");
            return; // Exit if passwords don't match
        }

        registerUser(firstName, lastName, userName, phone, password, event);
    }



    private void registerUser(String firstName, String lastName, String userName, String phone, String password, ActionEvent event) {
        connection = databaseConnection.getConnection();


        String insertQuery = "INSERT INTO klant (Telefoonnummer, Voornaam, Achternaam, Gebruikersnaam, Wachtwoord) VALUES (?, ?, ?, ?, ?)";

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

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

//    The function when you already have an account:
@FXML
public void handleLinkAction(MouseEvent event){
    System.out.println("Link has been clicked.");
    try {
        // Load the next page (for example, a login page or registration page)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/LoginPage.fxml"));
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
