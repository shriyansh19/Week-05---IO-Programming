package com.csvhandling.problem7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVSorter sorter = new CSVSorter();
        try {
            sorter.sortRecordsBySalary("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv", "sorted_employees.csv");
            System.out.println("Sorted records saved to sorted_employees.csv.");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}