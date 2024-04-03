package com.lms.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {

    private static DatabaseUtils instance;
    private Connection connection;

    private DatabaseUtils() {
        connection = DatabaseConnection.getConnection();
    }

    public static synchronized DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public List<Book> setBook() {
        List<Book> booksList = new ArrayList<>();
        String query = "INSERT INTO books (id, title, author) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");

                Book newBook = new Book(id, title, author);
                booksList.add(newBook);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    public List<User> setUser(){
        List<User> usersList = new ArrayList<>();
        String query = "INSERT INTO users (id, name, userid) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userid = resultSet.getString("userid");

                User newUser = new User(id, name, userid);
                usersList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public List<Loan> setLoan(){
        List<Loan> loansList = new ArrayList<>();
        String query = "INSERT INTO loans (id, bookid, userid) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bookid = resultSet.getInt("bookid");
                int userid = resultSet.getInt("userid");

                Loan newLoan = new Loan(id,bookid, userid);
                loansList.add(newLoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loansList;
    }

    public List<Book> getAllBooks() {
        List<Book> booksList = new ArrayList<>();
        String query = "SELECT * FROM book"; // Retrieve all rows from the 'books' table

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");

                Book newBook = new Book(id, title, author);
                booksList.add(newBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    public List<User> getAllUsers(){
        List<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM users"; // Retrieve all rows from the 'users' table

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userid = resultSet.getString("userid");

                User newUser = new User(id, name, userid);
                usersList.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public List<Loan> getAllLoans(){
        List<Loan> loansList = new ArrayList<>();
        String query = "SELECT * FROM loans"; // Retrieve all rows from the 'loans' table

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int bookid = resultSet.getInt("bookid");
                int userid = resultSet.getInt("userid");

                Loan newLoan = new Loan(id,bookid, userid);
                loansList.add(newLoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loansList;
    }


}
