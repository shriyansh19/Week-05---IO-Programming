package com.jsonhandling.problem7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONFilter filter = new JSONFilter();
        try {
            filter.filterByAge("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json", 25);
        } catch (IOException e) {
            System.err.println("Error filtering JSON data: " + e.getMessage());
        }
    }
}