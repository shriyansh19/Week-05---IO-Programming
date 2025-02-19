package com.jsonhandling.handsOnProblem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JSONReaderTest {
    @Test
    void testPrintKeysAndValues() {
        JSONReader reader = new JSONReader();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            reader.printKeysAndValues("test_user.json");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "name: \"John Doe\"\nage: 30\nemail: \"john.doe@example.com\"\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}