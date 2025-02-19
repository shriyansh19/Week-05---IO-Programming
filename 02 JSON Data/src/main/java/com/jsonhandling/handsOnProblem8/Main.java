package com.jsonhandling.handsOnProblem8;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseToJSONReport generator = new DatabaseToJSONReport();
        try {
            String json = generator.generateJSONReport(
                    "jdbc:mysql://localhost:3306/testdb", // Replace with your DB URL
                    "root",                              // Replace with your DB username
                    "password"                           // Replace with your DB password
            );
            System.out.println(json);
        } catch (SQLException | JsonProcessingException e) {
            System.err.println("Error generating JSON report: " + e.getMessage());
        }
    }
}