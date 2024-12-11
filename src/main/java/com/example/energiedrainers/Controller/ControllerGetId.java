package com.example.energiedrainers.Controller;

import com.example.energiedrainers.DatabaseAndSQL.DatabaseConnection;
import com.example.energiedrainers.Session.UserSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerGetId {

    public static int getTrackerID() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        int selectID = 0;
        String selectIDToCheck = "SELECT TrackerID FROM tracker WHERE klantID = ?";

        try (PreparedStatement idStatement = connection.prepareStatement(selectIDToCheck)) {
            idStatement.setInt(1, UserSession.getID());
            try (ResultSet queryResult = idStatement.executeQuery()) {
                if (queryResult.next()) {
                    selectID = queryResult.getInt("TrackerID"); // Correct column name
                    System.out.println("Retrieved TrackerID: " + selectID);
                } else {
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            } catch (Exception e) {
                System.err.println("Error while retrieving TrackerID: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return selectID;
    }

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
                    System.out.println("Retrieved TrackerID: " + selectID);
                } else {
                    System.out.println("No TrackerID found for the given KlantID.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving TrackerID: " + e.getMessage());
            e.printStackTrace();
        }
        return selectID;
    }
}


