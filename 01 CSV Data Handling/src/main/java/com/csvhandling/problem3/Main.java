package com.csvhandling.problem3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVRowCount counter = new CSVRowCount();
        try {
            int rowCount = counter.countRows("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\students.csv");
            System.out.println("Number of records: " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}