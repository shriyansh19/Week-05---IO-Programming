package com.csvhandling.problem10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class CSVMergerTest {
    @Test
    void testMergeCSVFiles() {
        CSVMerger merger = new CSVMerger();
        try {
            merger.mergeCSVFiles("test_students1.csv", "test_students2.csv", "test_merged_students.csv");

            // Verify the content of the merged file
            try (BufferedReader br = new BufferedReader(new FileReader("test_merged_students.csv"))) {
                String line;
                boolean isHeader = true;

                while ((line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        assertEquals("ID,Name,Age,Marks,Grade", line);
                        continue;
                    }
                    String[] data = line.split(",");
                    assertTrue(data.length == 5); // Ensure all fields are present
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}