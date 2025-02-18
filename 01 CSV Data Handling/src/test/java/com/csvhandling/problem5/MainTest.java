package com.csvhandling.problem5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CSVSearchTest {
    @Test
    void testSearchEmployeeByName() {
        CSVSearch search = new CSVSearch();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            search.searchEmployeeByName("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv", "John Doe");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "Department: IT, Salary: 5000\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}