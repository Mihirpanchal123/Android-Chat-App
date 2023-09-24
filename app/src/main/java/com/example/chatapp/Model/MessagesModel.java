package com.example.chatapp.Model;

public class MessagesModel {

    String mid ;
    String message;
    Long timeStamp;

    public MessagesModel(String id, String message, Long timeStamp) {
        this.mid = id;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public MessagesModel(String id, String message) {
        this.mid = id;
        this.message = message;
    }

    public MessagesModel(){}

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
