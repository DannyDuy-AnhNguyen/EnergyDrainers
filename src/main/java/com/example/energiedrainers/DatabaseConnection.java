package com.example.energiedrainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "energydrainers";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            System.out.println("Connection established successfully.");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Add the driver to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return databaseLink;
    }

}
