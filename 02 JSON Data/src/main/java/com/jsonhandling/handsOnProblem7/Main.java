package com.jsonhandling.handsOnProblem7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVToJSONConverter converter = new CSVToJSONConverter();
        try {
            String json = converter.convertCSVToJSON("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json");
            System.out.println(json);
        } catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}