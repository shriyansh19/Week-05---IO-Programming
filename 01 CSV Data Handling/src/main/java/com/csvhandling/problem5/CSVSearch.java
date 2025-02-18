package com.csvhandling.problem5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVSearch {
    public void searchEmployeeByName(String filePath, String name) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].trim().equalsIgnoreCase(name)) {
                    System.out.printf("Department: %s, Salary: %s%n", data[2], data[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        }
    }
}