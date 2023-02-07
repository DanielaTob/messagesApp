package com.project.messagesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public static void readMessagesDB(){

    }

    public static void deleteMessageDB(int id_message){

    }

    public static void updateMessageDB(Messages messages){

    }
}
