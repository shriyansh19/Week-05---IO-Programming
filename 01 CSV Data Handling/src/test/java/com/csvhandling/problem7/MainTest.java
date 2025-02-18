package com.csvhandling.problem7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class CSVSorterTest {
    @Test
    void testSortRecordsBySalary() {
        CSVSorter sorter = new CSVSorter();
        try {
            sorter.sortRecordsBySalary("test_employees.csv", "test_sorted_employees.csv");

            // Verify the content of the sorted file
            try (BufferedReader br = new BufferedReader(new FileReader("test_sorted_employees.csv"))) {
                String line;
                double previousSalary = Double.MAX_VALUE;
                boolean isHeader = true;

                while ((line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue; // Skip header
                    }
                    String[] data = line.split(",");
                    double salary = Double.parseDouble(data[3].trim());
                    assertTrue(salary <= previousSalary); // Ensure descending order
                    previousSalary = salary;
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}