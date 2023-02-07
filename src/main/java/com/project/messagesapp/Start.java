package com.project.messagesapp;

import java.sql.Connection;
import java.sql.SQLException;

public class Start {

    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();

        try(Connection cnx = connectionDB.getConnection()){
            System.out.println("successful connection!!");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
