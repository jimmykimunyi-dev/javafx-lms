package com.lms.lms;

public class Book {

    private int id;

    private String Title;

    private String Author;

    public int getId() {
        return id;
    }

    public int generateRandomId(){
        return (int) (Math.random() * 1000);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Book(int id,String title, String author) {
        Title = title;
        Author = author;
        this.id = id;
    }
}
