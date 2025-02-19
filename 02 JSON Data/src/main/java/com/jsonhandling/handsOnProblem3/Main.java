package com.jsonhandling.handsOnProblem3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONAgeFilter filter = new JSONAgeFilter();
        try {
            filter.filterUsersByAge("users.json", 25);
        } catch (IOException e) {
            System.err.println("Error filtering JSON data: " + e.getMessage());
        }
    }
}