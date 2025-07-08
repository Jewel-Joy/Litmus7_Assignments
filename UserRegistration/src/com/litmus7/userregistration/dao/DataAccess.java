package com.litmus7.userregistration.dao;

import java.sql.*;
import com.litmus7.userregistration.jdbc.JDBC;
import com.litmus7.userregistration.model.User;

public class DataAccess {

    JDBC jdbc = new JDBC();
    Connection conn = jdbc.connect();

    public User dataAccess(String emailInput) throws SQLException {
        String query = "SELECT * FROM User WHERE email = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, emailInput);

        ResultSet rs = pstmt.executeQuery();
        User user = null;

        if (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");
            String password = rs.getString("password");

            if (name != null) {
                user = new User(name, age, email, password);
            }
        }

        rs.close();
        pstmt.close();

        return user;
    }

    public boolean duplicateEntry(String emailInput) throws SQLException {
        String query = "SELECT email FROM User WHERE email = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, emailInput);

        ResultSet rs = pstmt.executeQuery();

        boolean isUnique = !rs.next(); 

        rs.close();
        pstmt.close();

        return isUnique;
    }
}
