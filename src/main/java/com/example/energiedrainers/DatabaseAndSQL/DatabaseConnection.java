package com.example.energiedrainers.DatabaseAndSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "energydrainers";
        String databaseUser = "energydrainersAdmin";
        String databasePassword = "SunDrainers!";
        String url = "jdbc:mysql://sundrainersmysql.mysql.database.azure.com:3306/" + databaseName;
        //String url = "jdbc:mysql://sundrainersmysql.mysql.database.azure.com:3306/energydrainers";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
//            System.out.println("Connection established successfully.");

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
