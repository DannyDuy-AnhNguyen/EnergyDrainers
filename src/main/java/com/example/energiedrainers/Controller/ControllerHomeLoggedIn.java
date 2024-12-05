package com.example.energiedrainers.Controller;

import com.example.energiedrainers.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ControllerHomeLoggedIn {

    @FXML
    private Text usernameText;

    // This will be called after the FXML has been loaded and initialized
    public void initialize() {
        // Set the username text to display the current user's username from the session
        usernameText.setText("Welkom "+UserSession.getUsername());
    }



//    This is the navigation bar. Click on the image to navigate

    @FXML
    public void handleHomeButton(MouseEvent event) {
        System.out.println("Home button clicked!");
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/HomeLoggedIn.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleApparaatButton(MouseEvent event) {
        System.out.println("Apparaat button clicked!");
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatVoegNieuweApparaat.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleGegevensButton(MouseEvent event) {
        System.out.println("Gegevens button clicked!");
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/Dashboard.fxml"));
            Scene homeScene = new Scene(loader.load());

            // Get the current stage
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleMijButton(MouseEvent event) {
        System.out.println("Mij button clicked!");
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/MijGegevens.fxml"));
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
