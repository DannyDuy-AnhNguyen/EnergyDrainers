package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class ControllerGetDataTable {

    //    Add the number tracker
    public static int getKlantIDViaTracker() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int selectID = 0; // Default value if no tracker is found
        String selectQuery = "SELECT TrackerID FROM tracker WHERE KlantID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, UserSession.getID());
            System.out.println(idStatement);

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    selectID = queryResult.getInt("TrackerID"); // Correct column name
                    System.out.println("Retrieved TrackerID: " + selectID);
                } else {
                    selectID = -1;
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving TrackerID: " + e.getMessage());
            e.printStackTrace();
        }
        return selectID;
    }

//// Stijn heeft via zijn code al gedaan... Controleer dat even🙂
//    public static List<Integer> randomValue(){
//        Random rn = new Random();
//        List<Integer> numList = new ArrayList<>(6);
//
//
//        int number1 = rn.nextInt(10) + 1;
//        int number2 = rn.nextInt(10) + 1;
//        int number3 = rn.nextInt(10) + 1;
//        int number4 = rn.nextInt(10) + 1;
//        int number5 = rn.nextInt(10) + 1;
//        int number6 = rn.nextInt(10) + 1;
//
//        numList.add(number1);
//        numList.add(number2);
//        numList.add(number3);
//        numList.add(number4);
//        numList.add(number5);
//        numList.add(number6);
//        System.out.println(numList);
//
//        return numList;
//    }


//// Insert the data of the date into the table 'meting'
//    public static String insertMetingDate(String date, int userID){
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        Connection connection = databaseConnection.getConnection();
//
////        Calendar c = Calendar.getInstance();
////
////        int day = c.get(Calendar.DAY_OF_MONTH);
////        int month = c.get(Calendar.MONTH) + 1; // Month is 0-based
////        int year = c.get(Calendar.YEAR);
////
////        String currentDate = year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
//
//        List<Integer> randomList = randomValue();
//        int hoekKantelServo = randomList.get(0);
//        int hoekDraaiServo = randomList.get(1);
//        int LDRBovenRechts = randomList.get(2);
//        int LDRBovenLinks = randomList.get(3);
//        int LDROnderRechts = randomList.get(4);
//        int LDROnderLinks = randomList.get(5);
//
//        String insertQuery = "INSERT INTO meting (Tijdstip, HOEK_kantelservo, HOEK_draaiservo, LDR_BovenRechts, LDR_BovenLinks, LDR_OnderRechts, LDR_OnderLinks, TrackerID) VALUES("+date+", "+hoekKantelServo+", "+hoekDraaiServo+", "+LDRBovenRechts+", "+LDRBovenLinks+", "+LDROnderRechts+", "+LDROnderLinks+" "+userID+")";
//
//        try(PreparedStatement insertStatement = connection.prepareStatement(insertQuery)){
//            insertStatement.setInt(1, UserSession.getID());
//
//            int rowsInserted = insertStatement.executeUpdate();
//
//            if(rowsInserted > 0){
//                return "Tracker added successfully!";
//            } else{
//                return "Failure😭.";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("An error occurred while adding tracker.");
//        }
//        return "Test";
//    }

//    Get the data of the LDR based on the data of the TrackerID
    public static int getLDRBovenRechts(String datum){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrBovenRechts = 0;
        String selectQuery = "SELECT LDR_BovenRechts FROM meting WHERE TrackerID = ? AND Tijdstip LIKE ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setString(2, datum + "%");

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    ldrBovenRechts = queryResult.getInt("LDR_BovenRechts"); // Correct column name
//                    System.out.println("Retrieved LDR_BovenRechts: " + ldrBovenRechts);
                } else {
                    ldrBovenRechts = -1;
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving TrackerID: " + e.getMessage());
            e.printStackTrace();
        }
        return ldrBovenRechts;
    }

    public static int getLDRBovenLinks(String datum){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrBovenLinks = 0;
        String selectQuery = "SELECT LDR_BovenLinks FROM meting WHERE TrackerID = ? AND Tijdstip LIKE ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setString(2, datum + "%");

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    ldrBovenLinks = queryResult.getInt("LDR_BovenLinks"); // Correct column name
//                    System.out.println("Retrieved LDR_BovenLinks: " + ldrBovenLinks);
                } else {
                    ldrBovenLinks = -1;
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving TrackerID: " + e.getMessage());
            e.printStackTrace();
        }

        return ldrBovenLinks;
    }

    public static int getLDROnderRechts(String datum){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrOnderRechts = 0;
        String selectQuery = "SELECT LDR_OnderRechts FROM meting WHERE TrackerID = ? AND Tijdstip LIKE ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setString(2, datum + "%");

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    ldrOnderRechts = queryResult.getInt("LDR_OnderRechts"); // Correct column name
//                    System.out.println("Retrieved LDR_OnderRechts: " + ldrOnderRechts);
                } else {
                    ldrOnderRechts = -1;
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving LDR_OnderRechts: " + e.getMessage());
            e.printStackTrace();
        }

        return ldrOnderRechts;
    }

    public static int getLDROnderLinks(String datum){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrOnderLinks = 0;
        String selectQuery = "SELECT LDR_OnderLinks FROM meting WHERE TrackerID = ? AND Tijdstip LIKE ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setString(2, datum + "%");

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    ldrOnderLinks = queryResult.getInt("LDR_OnderLinks"); // Correct column name
//                    System.out.println("Retrieved LDR_OnderLinks: " + ldrOnderLinks);
                } else {
                    ldrOnderLinks = -1;
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving TrackerID: " + e.getMessage());
            e.printStackTrace();
        }

        return ldrOnderLinks;
    }

    //Dag 1
    public static int getLDR_Average_Meting(String meting){
        int LDRBovenRechtsDag = ControllerGetDataTable.getLDRBovenRechts(meting);
        int LDRBovenLinksDag = ControllerGetDataTable.getLDRBovenLinks(meting);
        int LDROnderRechtsDag = ControllerGetDataTable.getLDROnderRechts(meting);
        int LDROnderLinksDag = ControllerGetDataTable.getLDROnderLinks(meting);
        int LDRAverage = ((LDRBovenRechtsDag +LDRBovenLinksDag + LDROnderRechtsDag + LDROnderLinksDag) / 4) * 10;
        System.out.println("Meting "+ meting + ": "+ LDRAverage);

        return LDRAverage;
    }

    //    Date inside a list
    public static List<String> lastSevenDays(){
        Calendar c = Calendar.getInstance();

        // List to store the past 7 days' dates
        List<String> pastSevenDates = new ArrayList<>();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1; // Month is 0-based
        int year = c.get(Calendar.YEAR);

        String currentDate = year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
        pastSevenDates.add(currentDate);

        // Generate the past 7 days' dates
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DAY_OF_MONTH, -1); // Move back 1 day
            day = c.get(Calendar.DAY_OF_MONTH);
            month = c.get(Calendar.MONTH) + 1; // Month is 0-based
            year = c.get(Calendar.YEAR);

            // Format the date with zero-padded day and month
            String formattedDate = year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);

            // Add the formatted date to the list
            pastSevenDates.add(formattedDate);

            // Print the date
            System.out.println("Date " + (i + 1) + ": " + formattedDate);
        }

        // Example usage of the pastSevenDates list
        System.out.println("\nGenerated Dates List:");
//        for (String date : pastSevenDates) {
//            System.out.println(date);
//        }
//
        // Reset the calendar to today's date
        c = Calendar.getInstance();
        int currentDay = c.get(Calendar.DAY_OF_MONTH);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        int currentYear = c.get(Calendar.YEAR);

//        System.out.println("\nCurrent day is " + currentDay);
//        System.out.println("Current month is " + currentMonth);
//        System.out.println("Current year is " + currentYear);

        return pastSevenDates;
    }

}


