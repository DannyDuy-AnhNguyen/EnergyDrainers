package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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

    public void initialize(){
        idText.setText("Uw tracker: "+ ControllerGetDataTable.getKlantIDViaTracker());
    }

    //    This is the navigation bar. Click on the image to navigate
    @FXML
    public void handleInfoDevice(MouseEvent event){
        try {
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/ApparaatOmvormerinfo.fxml"));
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

        //Dag 1
        int LDRBovenRechtsDag1 = ControllerGetDataTable.getLDRBovenRechts(dag1);
        int LDRBovenLinksDag1 = ControllerGetDataTable.getLDRBovenLinks(dag1);
        int LDROnderRechtsDag1 = ControllerGetDataTable.getLDROnderRechts(dag1);
        int LDROnderLinksDag1 = ControllerGetDataTable.getLDROnderLinks(dag1);
        int LDRAverage1 = (LDRBovenRechtsDag1 +LDRBovenLinksDag1 + LDROnderRechtsDag1 + LDROnderLinksDag1) / 4;

        //Dag 2
        int LDRBovenRechtsDag2 = ControllerGetDataTable.getLDRBovenRechts(dag2);
        int LDRBovenLinksDag2 = ControllerGetDataTable.getLDRBovenLinks(dag2);
        int LDROnderRechtsDag2 = ControllerGetDataTable.getLDROnderRechts(dag2);
        int LDROnderLinksDag2 = ControllerGetDataTable.getLDROnderLinks(dag2);
        int LDRAverage2 = (LDRBovenRechtsDag2 +LDRBovenLinksDag2 + LDROnderRechtsDag2 + LDROnderLinksDag2) / 4;

        //Dag 3
        int LDRBovenRechtsDag3 = ControllerGetDataTable.getLDRBovenRechts(dag3);
        int LDRBovenLinksDag3 = ControllerGetDataTable.getLDRBovenLinks(dag3);
        int LDROnderRechtsDag3 = ControllerGetDataTable.getLDROnderRechts(dag3);
        int LDROnderLinksDag3 = ControllerGetDataTable.getLDROnderLinks(dag3);
        int LDRAverage3 = (LDRBovenRechtsDag3 +LDRBovenLinksDag3 + LDROnderRechtsDag3 + LDROnderLinksDag3) / 4;

        //Dag 4
        int LDRBovenRechtsDag4 = ControllerGetDataTable.getLDRBovenRechts(dag4);
        int LDRBovenLinksDag4 = ControllerGetDataTable.getLDRBovenLinks(dag4);
        int LDROnderRechtsDag4 = ControllerGetDataTable.getLDROnderRechts(dag4);
        int LDROnderLinksDag4 = ControllerGetDataTable.getLDROnderLinks(dag4);
        int LDRAverage4 = (LDRBovenRechtsDag4 +LDRBovenLinksDag4 + LDROnderRechtsDag4 + LDROnderLinksDag4) / 4;

        //Dag 5
        int LDRBovenRechtsDag5 = ControllerGetDataTable.getLDRBovenRechts(dag5);
        int LDRBovenLinksDag5 = ControllerGetDataTable.getLDRBovenLinks(dag5);
        int LDROnderRechtsDag5 = ControllerGetDataTable.getLDROnderRechts(dag5);
        int LDROnderLinksDag5 = ControllerGetDataTable.getLDROnderLinks(dag5);
        int LDRAverage5 = (LDRBovenRechtsDag5 +LDRBovenLinksDag5 + LDROnderRechtsDag5 + LDROnderLinksDag5) / 4;

        //Dag 6
        int LDRBovenRechtsDag6 = ControllerGetDataTable.getLDRBovenRechts(dag6);
        int LDRBovenLinksDag6 = ControllerGetDataTable.getLDRBovenLinks(dag6);
        int LDROnderRechtsDag6 = ControllerGetDataTable.getLDROnderRechts(dag6);
        int LDROnderLinksDag6 = ControllerGetDataTable.getLDROnderLinks(dag6);
        int LDRAverage6 = (LDRBovenRechtsDag6 +LDRBovenLinksDag6 + LDROnderRechtsDag6 + LDROnderLinksDag6) / 4;

        //Dag 7
        int LDRBovenRechtsDag7 = ControllerGetDataTable.getLDRBovenRechts(dag7);
        int LDRBovenLinksDag7 = ControllerGetDataTable.getLDRBovenLinks(dag7);
        int LDROnderRechtsDag7 = ControllerGetDataTable.getLDROnderRechts(dag7);
        int LDROnderLinksDag7 = ControllerGetDataTable.getLDROnderLinks(dag7);
        int LDRAverage7 = (LDRBovenRechtsDag7 +LDRBovenLinksDag7 + LDROnderRechtsDag7 + LDROnderLinksDag7) / 4;

        System.out.println("Gemiddelde: "+ LDRAverage1);

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
        System.out.println("CheckKlantTrackerID: "+ CheckKlantTrackerID);
        try {
//            If the tracker does exist🙂
            if(CheckKlantTrackerID > 0) {
                //Numbers are date
                List<String> dates = ControllerGetDataTable.lastSevenDays();

                String dag1 = dates.get(0);
                String dag2 = dates.get(1);
                String dag3 = dates.get(2);
                String dag4 = dates.get(3);
                String dag5 = dates.get(4);
                String dag6 = dates.get(5);
                String dag7 = dates.get(6);

                //Dag 1
                int LDRAverage1 = ControllerGetDataTable.getLDR_Average_Meting(dag1);

                //Dag 2
                int LDRAverage2 = ControllerGetDataTable.getLDR_Average_Meting(dag2);

                //Dag 3
                int LDRAverage3 = ControllerGetDataTable.getLDR_Average_Meting(dag3);

                //Dag 4
                int LDRAverage4 = ControllerGetDataTable.getLDR_Average_Meting(dag4);

                //Dag 5
                int LDRAverage5 = ControllerGetDataTable.getLDR_Average_Meting(dag5);

                //Dag 6
                int LDRAverage6 = ControllerGetDataTable.getLDR_Average_Meting(dag6);

                //Dag 7
                int LDRAverage7 = ControllerGetDataTable.getLDR_Average_Meting(dag7);

                System.out.println("Gemiddelde 1: "+ LDRAverage1);
                System.out.println("Gemiddelde 2: "+ LDRAverage2);
                System.out.println("Gemiddelde 3: "+ LDRAverage3);
                System.out.println("Gemiddelde 4: "+ LDRAverage4);
                System.out.println("Gemiddelde 5: "+ LDRAverage5);
                System.out.println("Gemiddelde 6: "+ LDRAverage6);
                System.out.println("Gemiddelde 7: "+ LDRAverage7);


                // Load the new FXML😱
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/energiedrainers/Dashboard.fxml"));
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
