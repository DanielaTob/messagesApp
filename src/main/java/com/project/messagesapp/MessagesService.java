package com.project.messagesapp;

import com.google.protobuf.Message;

import java.sql.SQLException;
import java.util.Scanner;

public class MessagesService {

    public static void createMessage() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String message = sc.nextLine();

        System.out.println("Your name");
        String name = sc.nextLine();

        Messages register = new Messages();
        register.setMessage(message);
        register.setAuthor_message(name);

        MessagesDAO.createMessageDB(register);
    }

    public static void readMessages() throws SQLException {
        MessagesDAO.readMessagesDB();

    }

    public static void deleteMessages() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the id of the message you want to be deleted");
        int id_message = sc.nextInt();
        MessagesDAO.deleteMessageDB(id_message);

    }

    public static void updateMessages(){

    }
}
