package com.lms.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {

    public void save(Book book){
        String sql = "INSERT INTO books (id, Title, Author) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statementement = connection.prepareStatement(sql);

            statementement.setInt(1, book.generateRandomId());
            statementement.setString(2, book.getTitle());
            statementement.setString(3, book.getAuthor());

            statementement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
