package com.csvhandling.problem7;

import java.io.*;
import java.util.*;

public class CSVSorter {
    public void sortRecordsBySalary(String inputFilePath, String outputFilePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true;
            String header = null;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    header = line; // Save the header
                    isHeader = false;
                } else {
                    String[] data = line.split(",");
                    records.add(data);
                }
            }

            // Sort by Salary in descending order
            records.sort((r1, r2) -> Double.compare(Double.parseDouble(r2[3].trim()), Double.parseDouble(r1[3].trim())));

            // Write sorted records to output file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                bw.write(header);
                bw.newLine();
                for (String[] record : records) {
                    bw.write(String.join(",", record));
                    bw.newLine();
                }
            }
        }
    }
}