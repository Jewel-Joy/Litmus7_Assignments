package com.litmus7.userregistration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.userregistration.jdbc.JDBC;
import com.litmus7.userregistration.user.User;

public class DataAccess {

    JDBC jdbc = new JDBC();
    Connection conn = jdbc.connect();

    public User dataAccess(String emailInput) throws SQLException {
        String query = "SELECT * FROM User WHERE email = '" + emailInput + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        User user = null;

        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");
            String password = rs.getString("password");

            if (name != null) {
                user = new User(name, age, email, password);
                break; // since email is unique, exit after one match
            }
        }

        rs.close();
        stmt.close();

        return user;
    }

    public List<User> duplicateEntry() throws SQLException {
        String query = "SELECT * FROM User";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<User> users = new ArrayList<>();

        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");
            String password = rs.getString("password");

            if (name != null) {
                User user = new User(name, age, email, password);
                users.add(user);
            }
        }

        rs.close();
        stmt.close();

        return users;
    }
}
