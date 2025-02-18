package com.csvhandling.problem8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVValidator validator = new CSVValidator();
        try {
            validator.validateCSV("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\contacts.csv");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}