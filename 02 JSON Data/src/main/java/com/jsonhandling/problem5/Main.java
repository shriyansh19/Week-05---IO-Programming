package com.jsonhandling.problem5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONValidator validator = new JSONValidator();
        try {
            boolean isValid = validator.validateJSONStructure("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json");
            System.out.println("Is JSON valid? " + isValid);
        } catch (IOException e) {
            System.err.println("Error validating JSON: " + e.getMessage());
        }
    }
}