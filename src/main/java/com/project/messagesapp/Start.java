package com.project.messagesapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        int option = 0;
        do {

            System.out.println("----------");
            System.out.println(" Messages App ");
            System.out.println("1. Create a Message");
            System.out.println("2. Read Messages");
            System.out.println("3. Update Messages");
            System.out.println("4. Delete Messages");
            System.out.println("5. Exit");

            //Read the user option
            option = sc.nextInt();


            //communication with service
            switch (option){
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.readMessages();
                    break;
                case 3:
                    MessagesService.updateMessages();
                    break;
                case 4:
                    MessagesService.deleteMessages();
                    break;
                default:
                    break;
            }

        }while(option != 5);


       /* ConnectionDB connectionDB = new ConnectionDB();

        try(Connection cnx = connectionDB.getConnection()){
            System.out.println("successful connection!!");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }

}
