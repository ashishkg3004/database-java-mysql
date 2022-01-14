package com.ashish.learn;

import java.sql.SQLException;

public class DatabaseDemo {

    // DataImpl Class Object to do the various SQL operations
    static DataOperationImpl daoImpl;

    public static void main(String args[]) throws SQLException {
        DatabaseDemo dataObj = new DatabaseDemo();

        // Insert a user into the database;
        //dataObj.insertRow();
        // View the Record
        //dataObj.viewRow();
        // Update the Record
        //dataObj.updateRow();
        // Delete the Record
        //dataObj.deleteRow();

    }

    private void insertRow() throws SQLException {
        daoImpl = new DataOperationImpl();
        String username = "Ashish", pass = "Ashish@123", fullName = "Ashish Gupta", email = "ashish.gupta@microsoft.com";
        if (daoImpl.insertRecords(username, pass, fullName, email) > 0) {
            System.out.println("User " + username + " Inserted Successfully!");
        }
    }

    private void viewRow() throws SQLException {
        daoImpl = new DataOperationImpl();
        daoImpl.viewRecords();
    }

    private void updateRow() throws SQLException {
        daoImpl = new DataOperationImpl();
        String pass = "Ashish@786", fullName = "Ashishkumar Kashiprasad Gupta", email = "ashish.gupta@yahoo.com", username = "Ashish";
        if (daoImpl.updateRecords(pass, fullName, email, username) > 0) {
            System.out.println("User " + username + " Data Updated Successfully!");
        }
    }

    private void deleteRow() throws SQLException {
        daoImpl = new DataOperationImpl();
        String username = "Ashish";
        if (daoImpl.deleteRecords(username) > 0) {
            System.out.println("User " + username + " data deleted successfully!");
        }
    }

}