package com.csvhandling.problem11;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LargeCSVReader reader = new LargeCSVReader();
        try {
            reader.readInChunks("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\large_file.csv", 100); // Process in chunks of 100 lines
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}