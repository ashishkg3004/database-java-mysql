package com.ashish.learn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataOperationImpl implements DataOperation {
    PreparedStatement preparedStatement;
    Statement statement;

    @Override
    public int insertRecords(String username, String pass, String fullName, String email) throws SQLException {

        String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
        preparedStatement = SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pass);
        preparedStatement.setString(3, fullName);
        preparedStatement.setString(4, email);
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            return rowsInserted;
        } else {
            return 0;
        }
    }

    @Override
    public void viewRecords() throws SQLException {
        String sql = "SELECT * FROM Users";
        statement = SQLConnection.getConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;
        while (result.next()) {
            String name = result.getString(2);
            String pass = result.getString(3);
            String fullName = result.getString("fullname");
            String email = result.getString("email");

            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output, ++count, name, pass, fullName, email));
        }
    }

    @Override
    public int updateRecords(String pass, String fullName, String email, String username) throws SQLException {
        String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
        preparedStatement = SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, pass);
        preparedStatement.setString(2, fullName);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, username);

        int rowsUpdated1 = preparedStatement.executeUpdate();
        if (rowsUpdated1 > 0) {
            return rowsUpdated1;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteRecords(String username) throws SQLException {
        String sql = "DELETE FROM Users WHERE username=?";
        preparedStatement = SQLConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);

        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            return rowsDeleted;
        } else {
            return 0;
        }
    }

}
