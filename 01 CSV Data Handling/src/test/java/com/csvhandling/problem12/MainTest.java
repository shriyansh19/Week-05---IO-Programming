package com.csvhandling.problem12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CSVDuplicateDetectorTest {
    @Test
    void testDetectDuplicates() {
        CSVDuplicateDetector detector = new CSVDuplicateDetector();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            detector.detectDuplicates("test_duplicates.csv"); // Use a test CSV file
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "Duplicate IDs found:\n1\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}