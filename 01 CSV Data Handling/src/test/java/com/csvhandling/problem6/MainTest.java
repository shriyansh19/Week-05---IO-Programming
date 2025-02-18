package com.csvhandling.problem6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class CSVModifierTest {
    @Test
    void testUpdateSalaryForIT() {
        CSVModifier modifier = new CSVModifier();
        try {
            modifier.updateSalaryForIT("test_employees.csv", "test_updated_employees.csv");

            // Verify the content of the updated file
            try (BufferedReader br = new BufferedReader(new FileReader("test_updated_employees.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[2].trim().equalsIgnoreCase("IT")) {
                        double salary = Double.parseDouble(data[3].trim());
                        assertTrue(salary > 5000); // Ensure salary increased
                    }
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}