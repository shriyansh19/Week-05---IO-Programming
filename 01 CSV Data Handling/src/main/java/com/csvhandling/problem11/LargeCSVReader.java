package com.csvhandling.problem11;

import java.io.*;

public class LargeCSVReader {
    public void readInChunks(String filePath, int chunkSize) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                if (count % chunkSize == 0 && count != 0) {
                    System.out.printf("Processed %d records%n", count);
                }
                count++;
            }
            System.out.printf("Total records processed: %d%n", count - 1); // Exclude header
        }
    }
}