package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
        String url = "jdbc:mysql://mysql-db:3306/studentdb";
            String username = "root";
            String password = "root";

            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("MySQL Connected Successfully!");

            return connection;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}