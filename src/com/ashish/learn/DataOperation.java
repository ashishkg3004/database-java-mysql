package com.ashish.learn;

import java.sql.SQLException;

public interface DataOperation {

    public int insertRecords(String username, String pass, String fullName, String email) throws SQLException;
    public void viewRecords () throws SQLException;
    public int updateRecords(String pass, String fullName, String email, String username) throws  SQLException;
    public int deleteRecords(String username) throws  SQLException;
}
