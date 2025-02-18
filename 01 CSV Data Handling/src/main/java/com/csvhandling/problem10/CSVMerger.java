package com.csvhandling.problem10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CSVMerger {
    public void mergeCSVFiles(String file1Path, String file2Path, String outputFilePath) throws IOException {
        Map<Integer, String[]> mergedData = new HashMap<>();

        // Read first file (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1Path))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                mergedData.put(id, new String[]{data[1], data[2]});
            }
        }

        // Read second file (ID, Marks, Grade) and merge
        try (BufferedReader br = new BufferedReader(new FileReader(file2Path))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                if (mergedData.containsKey(id)) {
                    String[] existingData = mergedData.get(id);
                    mergedData.put(id, new String[]{existingData[0], existingData[1], data[1], data[2]});
                }
            }
        }

        // Write merged data to output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for (Map.Entry<Integer, String[]> entry : mergedData.entrySet()) {
                bw.write(entry.getKey() + "," + String.join(",", entry.getValue()));
                bw.newLine();
            }
        }
    }
}