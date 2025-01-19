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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class ControllerGetDataTable {

    //    Add the number tracker
    // Method to get the TrackerID associated with the KlantID
    public static List<Integer> getKlantIDViaTracker() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = null;
        PreparedStatement idStatement = null;
        ResultSet queryResult = null;

        List<Integer> trackerIDs = new ArrayList<>();  // Store multiple TrackerIDs
        String selectQuery = "SELECT TrackerID FROM tracker WHERE KlantID = ?";

        try {
            connection = databaseConnection.getConnection();
            idStatement = connection.prepareStatement(selectQuery);
            idStatement.setInt(1, UserSession.getID()); // Assuming UserSession.getID() retrieves the current user's ID

            queryResult = idStatement.executeQuery();

            while (queryResult.next()) {
                int trackerID = queryResult.getInt("TrackerID"); // Correct column name
                trackerIDs.add(trackerID);  // Add each TrackerID to the list
                System.out.println("Retrieved TrackerID: " + trackerID);
            }

            if (trackerIDs.isEmpty()) {
                System.out.println("No TrackerID found for the given KlantID.");
            }

        } catch (SQLException e) {
            System.err.println("SQL error while retrieving TrackerIDs: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error while retrieving TrackerIDs: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (queryResult != null) queryResult.close();
                if (idStatement != null) idStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("Done😉");
        return trackerIDs;
    }

    public static Boolean checkUsername(String username) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String verifyLoginQuery = "SELECT Gebruikersnaam FROM klant WHERE Gebruikersnaam = ?";
        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLoginQuery)) {
            preparedStatement.setString(1, username);

            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next()) {
                String foundUsername = queryResult.getString("Gebruikersnaam"); // Retrieve the username from the result

                System.out.println("Check if the username exists: FOUND");
                System.out.println("Provided username: " + username);
                System.out.println("Database username: " + foundUsername);

                if (foundUsername.equals(username)) {
//                    System.out.println("Username already exists! Registration stopped.");
                    return false; // Registration should stop
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking username: " + e.getMessage());
        }
        return true; // Username does not exist, registration can continue
    }



//    Get the data of the LDR based on the data of the TrackerID
    public static int getLDRBovenRechts(String datum){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrBovenRechts = 0;
        String selectQuery = "SELECT LDR_BovenRechts FROM meting WHERE TrackerID = ? AND Tijdstip LIKE ?";



        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker().get(0));
            idStatement.setString(2, "%" + datum + "%");

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
            idStatement.setInt(1, getKlantIDViaTracker().get(0));
            idStatement.setString(2, "%" + datum + "%");

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
            idStatement.setInt(1, getKlantIDViaTracker().get(0));
            idStatement.setString(2, "%" + datum + "%");

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
            idStatement.setInt(1, getKlantIDViaTracker().get(0));
            idStatement.setString(2, "%" + datum + "%");

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
        int LDRAverage = ((LDRBovenRechtsDag +LDRBovenLinksDag + LDROnderRechtsDag + LDROnderLinksDag) / 4) * 28;
        // System.out.println("Meting "+ meting + ": "+ LDRAverage);

        return LDRAverage;
    }

    //    Date inside a list
    public static List<String> lastFiveMinutes() {
        // Create a Calendar instance set to the current time
        Calendar c = Calendar.getInstance();

        // Round down the current minute to the nearest multiple of 5
        int minute = c.get(Calendar.MINUTE);
        int roundedMinute = minute - (minute % 5);
        c.set(Calendar.MINUTE, roundedMinute);
        c.set(Calendar.SECOND, 0); // Set seconds to 0 for consistency

        // Create a list to store the last five minute timestamps
        List<String> pastFiveMinutes = new ArrayList<>();

        // Define a formatter for the time (e.g., HH:mm)
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Iterate backward in steps of 5 minutes
        for (int i = 0; i < 7; i++) {
            // Format the current time and add it to the list
            pastFiveMinutes.add(timeFormat.format(c.getTime()));

            // Subtract 5 minutes
            c.add(Calendar.MINUTE, -5);
        }

        return pastFiveMinutes;
    }

    //    Return the correct date🙂
    public static String GetDayOfWeek() {
        Calendar c = Calendar.getInstance();
        int today = c.get(Calendar.DAY_OF_WEEK);

        return switch (today) {
            case 1 -> "Zondag";
            case 2 -> "Maandag";
            case 3 -> "Dinsdag";
            case 4 -> "Woensdag";
            case 5 -> "Donderdag";
            case 6 -> "Vrijdag";
            case 7 -> "Zaterdag";
            default -> "Unknown";
        };
    }

}


