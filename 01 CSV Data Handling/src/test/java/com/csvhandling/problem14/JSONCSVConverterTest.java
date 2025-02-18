package com.csvhandling.problem14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class JSONCSVConverterTest {
    @Test
    void testJSONToCSVAndBack() {
        JSONCSVConverter converter = new JSONCSVConverter();
        try {
            // Convert JSON to CSV
            converter.jsonToCSV("test_students.json", "test_students_converted.csv");

            // Verify the content of the CSV file
            try (BufferedReader br = new BufferedReader(new FileReader("test_students_converted.csv"))) {
                String line;
                boolean isHeader = true;

                while ((line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        assertEquals("id,name,age,marks", line);
                        continue;
                    }
                    String[] data = line.split(",");
                    assertTrue(data.length == 4); // Ensure all fields are present
                }
            }

            // Convert CSV back to JSON
            converter.csvToJSON("test_students_converted.csv", "test_students_reconverted.json");

            // Verify the content of the reconverted JSON file
            try (BufferedReader br = new BufferedReader(new FileReader("test_students_reconverted.json"))) {
                String line = br.readLine();
                assertTrue(line.contains("\"id\":\"1\""));
                assertTrue(line.contains("\"name\":\"John\""));
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}