package com.csvhandling.problem9;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVToObjectConverter converter = new CSVToObjectConverter();
        try {
            List<Student> students = converter.convertToObjects("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\students.csv");
            students.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}