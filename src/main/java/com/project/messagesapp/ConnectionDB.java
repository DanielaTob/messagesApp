package com.project.messagesapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/message_app", "root", "danielaminki");
        }catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
