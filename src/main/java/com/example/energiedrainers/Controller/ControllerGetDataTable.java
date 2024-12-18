package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerGetDataTable {


    //    Add the number tracker
    public static int getKlantIDViaTracker() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int selectID = 0; // Default value if no tracker is found
        String selectQuery = "SELECT TrackerID FROM tracker WHERE KlantID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, UserSession.getID());

            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    selectID = queryResult.getInt("TrackerID"); // Correct column name
//                    System.out.println("Retrieved TrackerID: " + selectID);
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

//    Get the data of the LDR based on the data of the TrackerID
    public static int getLDRBovenRechts(int meting){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrBovenRechts = 0;
        String selectQuery = "SELECT LDR_BovenRechts FROM meting WHERE TrackerID = ? AND MetingID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setInt(2, meting);

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

    public static int getLDRBovenLinks(int meting){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrBovenLinks = 0;
        String selectQuery = "SELECT LDR_BovenLinks FROM meting WHERE TrackerID = ? AND MetingID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setInt(2, meting);

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

    public static int getLDROnderRechts(int meting){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrOnderRechts = 0;
        String selectQuery = "SELECT LDR_OnderRechts FROM meting WHERE TrackerID = ? AND MetingID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setInt(2, meting);

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

    public static int getLDROnderLinks(int meting){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int ldrOnderLinks = 0;
        String selectQuery = "SELECT LDR_OnderLinks FROM meting WHERE TrackerID = ? AND MetingID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectQuery)) {
            idStatement.setInt(1, getKlantIDViaTracker());
            idStatement.setInt(2, meting);

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
    public static int getLDRGemiddeldeMeting(int meting){
        int LDRBovenRechtsDag = ControllerGetDataTable.getLDRBovenRechts(meting);
        int LDRBovenLinksDag = ControllerGetDataTable.getLDRBovenLinks(meting);
        int LDROnderRechtsDag = ControllerGetDataTable.getLDROnderRechts(meting);
        int LDROnderLinksDag = ControllerGetDataTable.getLDROnderLinks(meting);
        int LDRAverage = (LDRBovenRechtsDag +LDRBovenLinksDag + LDROnderRechtsDag + LDROnderLinksDag) / 4;
        System.out.println("Meting "+ meting + ": "+ LDRAverage);

        return LDRAverage;
    }

}


