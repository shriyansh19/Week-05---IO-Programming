package com.csvhandling.problem13;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseToCSV generator = new DatabaseToCSV();
        try {
            generator.generateCSVFromDatabase(
                    "jdbc:mysql://localhost:3306/company", // Replace with your DB URL
                    "root",                               // Replace with your DB username
                    "password",                           // Replace with your DB password
                    "employees_report.csv"
            );
            System.out.println("CSV report generated successfully.");
        } catch (SQLException | IOException e) {
            System.err.println("Error generating CSV report: " + e.getMessage());
        }
    }
}