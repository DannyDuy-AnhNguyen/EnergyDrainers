package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ControllerApparaatOmvormerToegevoegd {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection = databaseConnection.getConnection();

    @FXML
    private Text idText;

    @FXML
    private Label trackerIDLabel;


    public void initialize(){
        idText.setText("Uw tracker: "+ ControllerGetDataTable.getKlantIDViaTracker());

    }

    @FXML
    public void handleSelectTracker(MouseEvent event) {
        // Get all tracker IDs from rectangles
        List<Integer> trackerIDs = trackerRectangle();  // This fetches the list of tracker IDs

        for (Integer trackerID : trackerIDs) {
            System.out.println("Tracker Rectangle clicked! Tracker ID: " + trackerID);

            // Call the setTracker method with the clicked tracker ID
            setTracker(trackerID);

            try {
                if (trackerID >= 1) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/Dashboard.fxml"));
                    Scene homeScene = new Scene(loader.load());

                    // Get the current stage
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                    // Set the new scene
                    stage.setScene(homeScene);
                }
            } catch (Exception e) {
                System.out.println("An error occurred while selecting a tracker.");
                e.printStackTrace();
                // Optionally show an alert dialog to inform the user
            }
        }
    }

    // Method to display tracker ID or perform actions with the tracker
    public void setTracker(int trackerID) {
        // You can customize this method to handle the tracker data
        System.out.println("Setting tracker information for ID: " + trackerID);

        // Example: Display some additional information in the label or UI components
        trackerIDLabel.setText("Tracker ID: " + trackerID);
    }

    @FXML
    public List<Integer> trackerRectangle() {
        List<Integer> trackerIDs = ControllerGetDataTable.getKlantIDViaTracker();

        // Debugging or printing out the retrieved tracker IDs
        System.out.println("Retrieved tracker IDs: " + trackerIDs);

        return trackerIDs;
    }


    @FXML
    public void handleAddDevice(MouseEvent event){
        String insertQuery = "INSERT INTO tracker (klantID) VALUES(?)";

        try(PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, UserSession.getID());

            int rowsInserted = insertStatement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Tracker added successfully!");
                // Load the new FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatOmvormerToegevoegd.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while adding tracker.");
        }

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
        System.out.println("Apparaat button clicked!\nChecks of the user already has a tracker on his name...");

        List<Integer> trackerIDs = ControllerGetDataTable.getKlantIDViaTracker();  // Call the function to get tracker IDs

        if (trackerIDs.isEmpty()) {
            System.out.println("No trackers found.");

            try {
                // Load the ApparaatVoegNieuweApparaat.fxml if no trackers exist
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatVoegNieuweApparaat.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return; // Exit the method to avoid accessing trackerIDs.get(0)
        }

        System.out.println("Found multiple trackers: " + trackerIDs);

        int CheckKlantTrackerID = trackerIDs.get(0);
        System.out.println("CheckKlantTrackerID: " + CheckKlantTrackerID);

        try {
            if (CheckKlantTrackerID > 0) {
                // Load the Dashboard.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatOmvormerToegevoegd.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleGegevensButton(MouseEvent event) {
        System.out.println("Gegevens button clicked!");

        // Get tracker IDs from ControllerGetDataTable
        List<Integer> trackerIDs = ControllerGetDataTable.getKlantIDViaTracker();

        // Check if there are no trackers
        if (trackerIDs.isEmpty()) {
            System.out.println("No trackers found.");

            try {
                // Load the ApparaatVoegNieuweApparaat.fxml if no trackers exist
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatVoegNieuweApparaat.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return; // Exit the method to avoid accessing trackerIDs.get(0)
        }

        // If trackers exist
        int CheckKlantTrackerID = trackerIDs.get(0);
        System.out.println("CheckKlantTrackerID: " + CheckKlantTrackerID);

        try {
            if (CheckKlantTrackerID > 0) {
                // Load the Dashboard.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/Dashboard.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            }
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