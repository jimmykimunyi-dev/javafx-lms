package com.lms.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoanDAO {

    public void save(Loan loan){
        String sql = "INSERT INTO loan (id, bookid, userid) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, loan.generateRandomId());
            statement.setInt(2, loan.getBookID());
            statement.setInt(3, loan.getUserID());

            statement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
