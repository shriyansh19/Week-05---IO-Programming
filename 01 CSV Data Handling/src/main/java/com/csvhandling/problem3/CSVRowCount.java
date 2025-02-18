package com.csvhandling.problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCount {
    public int countRows(String filePath) throws IOException {
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header row
            br.readLine();
            while (br.readLine() != null) {
                rowCount++;
            }
        }
        return rowCount;
    }
}