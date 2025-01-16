package com.example.energiedrainers.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ControllerApparaatOmvormerInfo {


//    This is the navigation bar. Click on the image to navigate
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


        //Numbers are date
        List<String> dates = ControllerGetDataTable.lastSevenDays();

        String dag1 = dates.get(0);
        String dag2 = dates.get(1);
        String dag3 = dates.get(2);
        String dag4 = dates.get(3);
        String dag5 = dates.get(4);
        String dag6 = dates.get(5);
        String dag7 = dates.get(6);


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
                List<String> dates = ControllerGetDataTable.lastSevenDays();

                int[] LDRValues = {
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(0)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(1)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(2)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(3)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(4)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(5)),
                        ControllerGetDataTable.getLDR_Average_Meting(dates.get(6))
                };

                // Fixed layoutY position of the bottom of the rectangles
                double fixedBottomY = 243.0;

                // Adjust the rectangles dynamically
                Rectangle[] rectangles = {
                        rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6, rectangle7
                };

                // Print each rectangle
                for (int i = 0; i < rectangles.length; i++) {
                    if (rectangles[i] != null) {
                        rectangles[i].setHeight(LDRValues[i]);
                        rectangles[i].setLayoutY(fixedBottomY - LDRValues[i]);
                    } else {
                        System.out.println("Error: Rectangle object is null at index " + i);
                    }
                }

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

}
