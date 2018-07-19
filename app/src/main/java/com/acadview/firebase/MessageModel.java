package com.acadview.firebase;

public class MessageModel {
    String userName,userEmail,userImg,userMessage,messageTime;

    public MessageModel() {
    }

    public MessageModel(String userName, String userEmail, String userImg, String userMessage, String messageTime) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImg = userImg;
        this.userMessage = userMessage;
        this.messageTime = messageTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public String toString() {
        return (getUserName() + " " + getUserEmail() + " " + getUserImg());
    }
}

