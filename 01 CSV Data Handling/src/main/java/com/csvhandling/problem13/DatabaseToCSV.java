package com.csvhandling.problem13;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseToCSV {
    public void generateCSVFromDatabase(String dbUrl, String username, String password, String outputFilePath) throws SQLException, IOException {
        // Connect to the database
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try (Connection conn = DriverManager.getConnection(dbUrl, props);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT EmployeeID, Name, Department, Salary FROM Employees");
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Write header
            bw.write("EmployeeID,Name,Department,Salary");
            bw.newLine();

            // Write data
            while (rs.next()) {
                int id = rs.getInt("EmployeeID");
                String name = rs.getString("Name");
                String department = rs.getString("Department");
                double salary = rs.getDouble("Salary");

                bw.write(String.format("%d,%s,%s,%.2f", id, name, department, salary));
                bw.newLine();
            }
        }
    }
}