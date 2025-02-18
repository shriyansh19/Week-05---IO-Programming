package com.csvhandling.problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class CSVWriterTest {
    @Test
    void testWriteData() {
        CSVWriter writer = new CSVWriter();
        try {
            writer.writeData("test_employees.csv");

            // Verify the content of the file
            try (BufferedReader br = new BufferedReader(new FileReader("test_employees.csv"))) {
                assertEquals("ID,Name,Department,Salary", br.readLine());
                assertEquals("1,John Doe,IT,5000", br.readLine());
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}