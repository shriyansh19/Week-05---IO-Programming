package com.csvhandling.problem5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVSearch search = new CSVSearch();
        try {
            search.searchEmployeeByName("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv", "John Doe");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}