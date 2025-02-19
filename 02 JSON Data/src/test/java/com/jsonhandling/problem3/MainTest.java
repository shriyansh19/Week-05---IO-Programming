package com.jsonhandling.problem3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JSONExtractorTest {
    @Test
    void testExtractFields() {
        JSONExtractor extractor = new JSONExtractor();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            extractor.extractFields("test_user.json");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "Name: John Doe\nEmail: john.doe@example.com\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}