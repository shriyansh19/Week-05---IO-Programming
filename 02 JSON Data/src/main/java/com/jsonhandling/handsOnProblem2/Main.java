package com.jsonhandling.handsOnProblem2;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListToJSONArrayConverter converter = new ListToJSONArrayConverter();
        try {
            String json = converter.convertListToJSON(Arrays.asList(
                    new User("John", 25),
                    new User("Jane", 30)
            ));
            System.out.println(json);
        } catch (IOException e) {
            System.err.println("Error converting list to JSON: " + e.getMessage());
        }
    }
}