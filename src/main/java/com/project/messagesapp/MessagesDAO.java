package com.project.messagesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesDAO {

    public static void createMessageDB(Messages messages) throws SQLException {
        ConnectionDB connectDB = new ConnectionDB();

        try (Connection connection = connectDB.getConnection()){

            PreparedStatement ps = null;

            try{

                String query = "INSERT INTO messages (message, author_message, message_date) VALUES (?,?, CURRENT_TIMESTAMP)";
                ps = connection.prepareStatement(query);
                ps.setString(1, messages.getMessage());
                ps.setString(2, messages.getAuthor_message());
                ps.executeUpdate();
                System.out.println("successfully created message");

            }catch (SQLException exception){
                System.out.println(exception);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void readMessagesDB() throws SQLException {

        ConnectionDB connectDB = new ConnectionDB();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = connectDB.getConnection()){

            String query = "SELECT * FROM messages";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){

                System.out.println("ID: " + rs.getInt("id_message"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Author: " + rs.getString("author_message"));
                System.out.println("Date: " + rs.getString("message_date"));
                System.out.println("");

            }

        }catch (SQLException e){
            System.out.println("could not recover messages...");
            System.out.println(e);
        }
    }

    public static void deleteMessageDB(int id_message) throws SQLException {

        ConnectionDB connectDB = new ConnectionDB();

        try(Connection connection = connectDB.getConnection()){

            PreparedStatement ps = null;

            String query = "DELETE FROM messages WHERE id_message = ?";
            ps = connection.prepareStatement(query);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_message);
            int countRowsUpdated = statement.executeUpdate();
            if (countRowsUpdated != 0) {
                System.out.println("The message was successfully deleted");
            } else {
                System.out.println("was not found");
            }


        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessageDB(Messages messages){


        ConnectionDB connectDB = new ConnectionDB();

        try(Connection connection = connectDB.getConnection()){

            PreparedStatement ps = null;

            try{

                String query = "UPDATE messages SET message = ? WHERE id_message = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, messages.getMessage());
                ps.setInt(2, messages.getId_message());
                ps.executeUpdate();
                System.out.println("successfully updated message");

            }catch (SQLException exception){
                System.out.println(exception);
                System.out.println("message could not be updated");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
