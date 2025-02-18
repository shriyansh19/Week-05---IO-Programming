package com.csvhandling.problem4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CSVFilterTest {
    @Test
    void testFilterHighScorers() {
        CSVFilter filter = new CSVFilter();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            filter.filterHighScorers("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\students.csv"); // Use a test CSV file
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "ID | Name | Age | Marks\n101 | John | 20 | 85\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}