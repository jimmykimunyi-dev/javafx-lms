package com.lms.lms;

public class Loan {


    private int id;

    private int BookID;

    private int UserID;

    public int generateRandomId(){
        return (int) (Math.random() * 1000);
    }

    public int getBookID() {
        return BookID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public Loan(int id, int bookID, int userID) {
        BookID = bookID;
        UserID = userID;
        this.id = id;
    }
}
