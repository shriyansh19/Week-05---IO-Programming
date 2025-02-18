package com.csvhandling.problem13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class DatabaseToCSVTest {
    @Test
    void testGenerateCSVFromDatabase() {
        DatabaseToCSV generator = new DatabaseToCSV();
        try {
            generator.generateCSVFromDatabase(
                    "jdbc:h2:mem:testdb", // Use an in-memory H2 database for testing
                    "sa",
                    "",
                    "test_employees_report.csv"
            );

            // Verify the content of the generated CSV file
            try (BufferedReader br = new BufferedReader(new FileReader("test_employees_report.csv"))) {
                String line;
                boolean isHeader = true;

                while ((line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        assertEquals("EmployeeID,Name,Department,Salary", line);
                        continue;
                    }
                    String[] data = line.split(",");
                    assertTrue(data.length == 4); // Ensure all fields are present
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}