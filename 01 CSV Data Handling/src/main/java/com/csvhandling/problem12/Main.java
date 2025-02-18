package com.csvhandling.problem12;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVDuplicateDetector detector = new CSVDuplicateDetector();
        try {
            detector.detectDuplicates("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\large_file.csv");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}