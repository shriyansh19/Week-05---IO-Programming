package com.jsonhandling.problem3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONExtractor extractor = new JSONExtractor();
        try {
            extractor.extractFields("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json");
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
}