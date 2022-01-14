package com.ashish.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    static String dbURL = "jdbc:mysql://localhost:3306/SampleDB";
    static String username = "root";
    static String password = "Root@123";
    static Connection conn;

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Database Connected!");
            }
        } catch (SQLException se) {
            System.out.println("Failed to create the database connection.");
            se.printStackTrace();
        }
        return conn;
    }
}