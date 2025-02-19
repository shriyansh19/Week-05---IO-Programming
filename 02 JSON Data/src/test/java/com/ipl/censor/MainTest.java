package com.ipl.censor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class IPLCensorTest {
    @Test
    void testJSONCensorship() {
        try {
            // Process JSON
            String inputPath = "test_ipl_matches.json";
            String outputPath = "test_censored_ipl_matches.json";
            IPLCensor.processJSON(inputPath, outputPath);

            // Verify output
            try (BufferedReader br = new BufferedReader(new FileReader(outputPath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    assertTrue(line.contains("Mumbai ***"));
                    assertTrue(line.contains("REDACTED"));
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testCSVCensorship() {
        try {
            // Process CSV
            String inputPath = "test_ipl_matches.csv";
            String outputPath = "test_censored_ipl_matches.csv";
            IPLCensor.processCSV(inputPath, outputPath);

            // Verify output
            try (BufferedReader br = new BufferedReader(new FileReader(outputPath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    assertTrue(line.contains("Mumbai ***"));
                    assertTrue(line.contains("REDACTED"));
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}