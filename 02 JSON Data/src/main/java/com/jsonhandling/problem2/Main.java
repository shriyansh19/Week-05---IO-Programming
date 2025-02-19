package com.jsonhandling.problem2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020);
        CarToJSONConverter converter = new CarToJSONConverter();
        try {
            String json = converter.convertCarToJSON(car);
            System.out.println(json);
        } catch (Exception e) {
            System.err.println("Error converting to JSON: " + e.getMessage());
        }
    }
}