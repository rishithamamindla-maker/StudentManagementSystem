package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentService {

    public void viewStudents() {

        String query = "SELECT * FROM students";

        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                    rs.getString("StudentID") + " | " +
                    rs.getString("FirstName") + " | " +
                    rs.getString("LastName") + " | " +
                    rs.getString("Email") + " | " +
                    rs.getString("Department") + " | " +
                    rs.getDouble("CGPA")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}