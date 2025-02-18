package com.csvhandling.problem1;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CSVReaderTest {
    @Test
    void testReadAndPrint() {
        CSVReader reader = new CSVReader();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            reader.readAndPrint("test_students.csv"); // Use a test CSV file
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "ID | Name | Age | Marks\n1 | John | 20 | 85\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}