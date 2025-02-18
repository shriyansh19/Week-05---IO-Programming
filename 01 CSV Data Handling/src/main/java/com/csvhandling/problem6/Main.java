package com.csvhandling.problem6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVModifier modifier = new CSVModifier();
        try {
            modifier.updateSalaryForIT("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv", "updated_employees.csv");
            System.out.println("Updated records saved to updated_employees.csv.");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}