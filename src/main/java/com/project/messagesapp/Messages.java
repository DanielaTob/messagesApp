package com.project.messagesapp;

public class Messages {

    int id_message;
    String message;
    String author_message;
    String message_date;

    //Constructor
    public Messages(){

    }

    //Constructor
    public Messages(String message, String author_message, String message_date) {
        this.message = message;
        this.author_message = author_message;
        this.message_date = message_date;
    }


    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_message() {
        return author_message;
    }

    public void setAuthor_message(String author_message) {
        this.author_message = author_message;
    }

    public String getMessage_date() {
        return message_date;
    }

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

}
