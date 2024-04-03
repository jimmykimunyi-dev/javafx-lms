package com.lms.lms;

public class User {

    private int id;

    private String name;

    private String userID;

    public int generateRandomId(){
        return (int) (Math.random() * 1000);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User(int id, String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.id = id;
    }


}
