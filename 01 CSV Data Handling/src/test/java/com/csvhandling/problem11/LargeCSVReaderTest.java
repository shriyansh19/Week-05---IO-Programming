package com.csvhandling.problem11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LargeCSVReaderTest {
    @Test
    void testReadInChunks() {
        LargeCSVReader reader = new LargeCSVReader();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            reader.readInChunks("test_large_file.csv", 2); // Use a small test file
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "Processed 2 records\nTotal records processed: 4\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}