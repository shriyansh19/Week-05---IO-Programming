package com.csvhandling.problem2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVWriter writer = new CSVWriter();
        try {
            writer.writeData("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv");
            System.out.println("Data written to employees.csv successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}