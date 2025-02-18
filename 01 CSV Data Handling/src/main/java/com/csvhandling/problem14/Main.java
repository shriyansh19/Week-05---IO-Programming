package com.csvhandling.problem14;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONCSVConverter converter = new JSONCSVConverter();
        try {
            // Convert JSON to CSV
            converter.jsonToCSV("students.json", "students_converted.csv");
            System.out.println("JSON converted to CSV successfully.");

            // Convert CSV back to JSON
            converter.csvToJSON("students_converted.csv", "students_reconverted.json");
            System.out.println("CSV converted back to JSON successfully.");
        } catch (IOException e) {
            System.err.println("Error during conversion: " + e.getMessage());
        }
    }
}