package com.csvhandling.problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public void readAndPrint(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("ID | Name | Age | Marks");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the CSV structure is ID,Name,Age,Marks
                System.out.printf("%s | %s | %s | %s%n", data[0], data[1], data[2], data[3]);
            }
        }
    }
}