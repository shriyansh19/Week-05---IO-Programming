package com.csvhandling.problem4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVFilter filter = new CSVFilter();
        try {
            filter.filterHighScorers("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\students.csv");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}