package com.example.energiedrainers.Controller;

import com.example.energiedrainers.Controller.ControllerGetDataTable;
import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ControllerHomeLoggedIn {

    @FXML
    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection connection = databaseConnection.getConnection();


    @FXML
    private Text usernameText;

    @FXML
    private Text ldr_average;


    // This will be called after the FXML has been loaded and initialized
    public void initialize() {
        // Set the username text to display the current user's username from the session
        usernameText.setText("Welkom " + UserSession.getUsername());
        ldr_average.setText("Aantal energie: "+ getLDRText());
        System.out.println(ControllerGetDataTable.getKlantIDViaTracker());
    }

    public static int getLDRText(){
        List<String> lastFiveMinute = ControllerGetDataTable.lastFiveMinutes();
        System.out.println(lastFiveMinute);
        if(lastFiveMinute.isEmpty()){
            return -1;
        } else{
            String fiveMinute1 = lastFiveMinute.get(0);

            //Dag 1
            int LDRBovenRechtsDag1 = ControllerGetDataTable.getLDRBovenRechts(fiveMinute1);
            int LDRBovenLinksDag1 = ControllerGetDataTable.getLDRBovenLinks(fiveMinute1);
            int LDROnderRechtsDag1 = ControllerGetDataTable.getLDROnderRechts(fiveMinute1);
            int LDROnderLinksDag1 = ControllerGetDataTable.getLDROnderLinks(fiveMinute1);
            return (LDRBovenRechtsDag1 + LDRBovenLinksDag1 + LDROnderRechtsDag1 + LDROnderLinksDag1) / 4;
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
