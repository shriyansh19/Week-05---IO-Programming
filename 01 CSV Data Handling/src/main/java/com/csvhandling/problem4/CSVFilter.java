package com.csvhandling.problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFilter {
    public void filterHighScorers(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("ID | Name | Age | Marks");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Skip header row
                if (!data[0].equalsIgnoreCase("ID")) {
                    int marks = Integer.parseInt(data[3].trim());
                    if (marks > 80) {
                        System.out.printf("%s | %s | %s | %s%n", data[0], data[1], data[2], data[3]);
                    }
                }
            }
        }
    }
}