package com.csvhandling.problem12;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CSVDuplicateDetector {
    public void detectDuplicates(String filePath) throws IOException {
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }
                String[] data = line.split(",");
                String id = data[0].trim();

                if (!seenIds.add(id)) {
                    duplicates.add(id);
                }
            }
        }

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate IDs found:");
            duplicates.forEach(System.out::println);
        } else {
            System.out.println("No duplicates found.");
        }
    }
}