package com.example.energiedrainers.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
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

        int CheckKlantTrackerID = ControllerGetDataTable.getKlantIDViaTracker();
        System.out.println("CheckKlantTrackerID: "+ CheckKlantTrackerID);

        try {
            if(CheckKlantTrackerID > 0){
                // Load the new FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatOmvormerToegevoegd.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            } else{
                // Load the new FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatVoegNieuweApparaat.fxml"));
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

        int CheckKlantTrackerID = ControllerGetDataTable.getKlantIDViaTracker();
        System.out.println("CheckKlantTrackerID: " + CheckKlantTrackerID);


        try {
            if (CheckKlantTrackerID > 0) {
                updateRectangles();
                 // Load the new FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/Dashboard.fxml"));
                Scene homeScene = new Scene(loader.load());

                // Get the current stage
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(homeScene);
            } else {
                // Load the fallback FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatVoegNieuweApparaat.fxml"));
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

        // Fetch the last seven days and LDR values
        List<String> dates;
        List<Integer> LDRValues = new ArrayList<>();  // Use List instead of int[] to avoid indexing issues

        try {
            dates = ControllerGetDataTable.lastSevenDays();
            if (dates == null || dates.size() < 7) {
                System.err.println("Error: Could not retrieve valid last seven days.");
                return;
            }

            for (String date : dates) {
                Integer value = ControllerGetDataTable.getLDR_Average_Meting(date);
                if (value == null) {
                    System.err.println("Error: LDR value for date " + date + " is null.");
                    LDRValues.add(0);  // Replace null with a default value
                } else {
                    LDRValues.add(value);
                }
            }

            for (int LDRValue : LDRValues) {
                System.out.println("Height Average🙂: " + LDRValue);
            }

            // Set the height for each rectangle based on LDRValues[i]
            rectangle1.setHeight(LDRValues.get(0));
            rectangle2.setHeight(LDRValues.get(1));
            rectangle3.setHeight(LDRValues.get(2));
            rectangle4.setHeight(LDRValues.get(3));
            rectangle5.setHeight(LDRValues.get(4));
            rectangle6.setHeight(LDRValues.get(5));
            rectangle7.setHeight(LDRValues.get(6));

            System.out.println("Test🙂" + this.rectangle1);
            System.out.println("Test🥵" + rectangle1);


            // Rectangle array linked to FXML components
            List<Rectangle> rectangles = List.of(
                    this.rectangle1,
                    this.rectangle2,
                    this.rectangle3,
                    this.rectangle4,
                    this.rectangle5,
                    this.rectangle6,
                    this.rectangle7
            );

            // Check if all rectangles are initialized correctly
            if (rectangles == null || rectangles.size() != LDRValues.size()) {
                System.err.println("Error: The number of rectangles does not match the LDR values.");
                return;
            }

            // Fixed layoutY position of the bottom of the rectangles
            double fixedBottomY = 243.0;  // starting Y position for the bottom of rectangles

            // Set the height for each rectangle based on LDRValues[i]
            for (int i = 0; i < rectangles.size(); i++) {
                Rectangle rectangle = rectangles.get(i);

                if (rectangle != null) {
                    System.out.println("Adjusting rectangle " + (i + 1) + " with LDRValue: " + LDRValues.get(i));

                    // Update the height and calculate layoutY based on height
                    rectangle.setHeight(LDRValues.get(i));  // Use LDRValues.get(i) to safely access values

                    // Here, we update layoutY on the JavaFX Application Thread
                    int finalI = i;
                    Platform.runLater(() -> {
                        rectangle.setLayoutY(fixedBottomY - LDRValues.get(finalI));  // Calculate layoutY dynamically

                        // Print out the properties to confirm changes
                        System.out.println("Rectangle " + (finalI + 1) + " - Height: " + rectangle.getHeight() +
                                ", LayoutY: " + rectangle.getLayoutY() +
                                ", Width: " + rectangle.getWidth() +
                                ", ArcHeight: " + rectangle.getArcHeight() +
                                ", ArcWidth: " + rectangle.getArcWidth() +
                                ", Fill: " + rectangle.getFill());
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
