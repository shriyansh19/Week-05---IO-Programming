package com.jsonhandling.problem1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StudentJSONCreator creator = new StudentJSONCreator();
        try {
            String json = creator.createStudentJSON();
            System.out.println(json);
        } catch (Exception e) {
            System.err.println("Error creating JSON: " + e.getMessage());
        }
    }
}