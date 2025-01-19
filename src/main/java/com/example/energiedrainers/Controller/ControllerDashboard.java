package com.example.energiedrainers.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;

import java.io.IOException;

public class ControllerDashboard {

    //    This is the navigation bar. Click on the image to navigate
    //For the rectangle adjustments:
    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Rectangle rectangle3;

    @FXML
    private Rectangle rectangle4;

    @FXML
    private Rectangle rectangle5;

    @FXML
    private Rectangle rectangle6;

    @FXML
    private Rectangle rectangle7;

//    Show the text for the time for the last 7 five minutes
//    Each 5 minute
    @FXML
    private Text textTime1;

    @FXML
    private Text textTime2;

    @FXML
    private Text textTime3;

    @FXML
    private Text textTime4;

    @FXML
    private Text textTime5;

    @FXML
    private Text textTime6;

    @FXML
    private Text textTime7;
//    Tracker of the user:
    @FXML
    private Text yourTracker;

    @FXML
    private Text currentDate;

//    Initialize makes it accesible for all controller on the dashboard field
    public void initialize(){
        // Set text for each time for the UX😉
        List<String> lastFiveMinute = ControllerGetDataTable.lastFiveMinutes();
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1; // Month is 0-based
        int year = c.get(Calendar.YEAR);

        textTime1.setText(lastFiveMinute.get(0));
        textTime2.setText(lastFiveMinute.get(1));
        textTime3.setText(lastFiveMinute.get(2));
        textTime4.setText(lastFiveMinute.get(3));
        textTime5.setText(lastFiveMinute.get(4));
        textTime6.setText(lastFiveMinute.get(5));
        textTime7.setText(lastFiveMinute.get(6));
        yourTracker.setText("Uw Tracker: "+ ControllerGetDataTable.getKlantIDViaTracker());
        currentDate.setText(ControllerGetDataTable.GetDayOfWeek() + " " + day + "-" + month + "-" + year);

        // Ensure all rectangles are initialized
        System.out.println("Initializing Rectangles:");
        System.out.println("Rectangle1: " + rectangle1);
        System.out.println("Rectangle2: " + rectangle2);
        System.out.println("Rectangle3: " + rectangle3);
        System.out.println("Rectangle4: " + rectangle4);
        System.out.println("Rectangle5: " + rectangle5);
        System.out.println("Rectangle6: " + rectangle6);
        System.out.println("Rectangle7: " + rectangle7);

         // Call the rectangle update function once the scene is fully loaded
        updateRectangles();
    }

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

    //    Other functions
    @FXML
    public void updateRectangles() {
        System.out.println("Initializing ControllerDashboard...");

        // Fetch the last five minutes and LDR values
        List<String> times;
        List<Integer> LDRValues = new ArrayList<>();  // Use List instead of int[] to avoid indexing issues
        try {
            // Retrieve the last five-minute intervals
            times = ControllerGetDataTable.lastFiveMinutes();
            if (times == null || times.size() < 7) {
                System.err.println("Error: Could not retrieve valid last five-minute intervals.");
                return;
            }

            // Fetch LDR values for the intervals
            for (String time : times) {
                Integer value = ControllerGetDataTable.getLDR_Average_Meting(time);
                if (value == null) {
                    System.err.println("Error: LDR value for time " + time + " is null.");
                    LDRValues.add(0);  // Replace null with a default value
                } else {
                    LDRValues.add(value);
                }
            }
            System.out.println("💀:"+ times);


            // Verify the rectangles list size matches LDR values
            List<Rectangle> rectangles = List.of(
                    this.rectangle1,
                    this.rectangle2,
                    this.rectangle3,
                    this.rectangle4,
                    this.rectangle5,
                    this.rectangle6,
                    this.rectangle7
            );

            if (rectangles.size() != LDRValues.size()) {
                System.err.println("Error: The number of rectangles does not match the LDR values.");
                return;
            }

            // Fixed layoutY position of the bottom of the rectangles
            double fixedBottomY = 265.0;  // starting Y position for the bottom of rectangles

            // Update the rectangles dynamically
            for (int i = 0; i < rectangles.size(); i++) {
                Rectangle rectangle = rectangles.get(i);

                if (rectangle != null) {
                    int finalI = i;
                    int ldrValue = LDRValues.get(finalI);

                    // Update height and layoutY on the JavaFX Application Thread
                    Platform.runLater(() -> {
                        rectangle.setHeight(ldrValue);
                        rectangle.setLayoutY(fixedBottomY - ldrValue);
                    });
                } else {
                    System.out.println("Warning: Rectangle object is null at index " + i);
                }
            }

            System.out.println("Initialization complete.");
        } catch (Exception e) {
            System.err.println("Error fetching LDR values: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
