package com.jsonhandling.handsOnProblem3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JSONAgeFilterTest {
    @Test
    void testFilterUsersByAge() {
        JSONAgeFilter filter = new JSONAgeFilter();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            filter.filterUsersByAge("test_users.json", 25);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "{\n" +
                "  \"name\" : \"Jane\",\n" +
                "  \"age\" : 30,\n" +
                "  \"email\" : \"jane@example.com\"\n" +
                "}\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}