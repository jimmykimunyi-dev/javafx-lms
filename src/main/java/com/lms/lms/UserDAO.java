package com.lms.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void save(User user){
        String sql = "INSERT INTO user (id, name, userID) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, user.generateRandomId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getUserID());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
