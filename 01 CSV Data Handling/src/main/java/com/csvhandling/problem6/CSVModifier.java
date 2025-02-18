package com.csvhandling.problem6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVModifier {
    public void updateSalaryForIT(String inputFilePath, String outputFilePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3].trim());
                    salary *= 1.1; // Increase by 10%
                    data[3] = String.valueOf(salary);
                }
                lines.add(String.join(",", data));
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String updatedLine : lines) {
                bw.write(updatedLine);
                bw.newLine();
            }
        }
    }
}