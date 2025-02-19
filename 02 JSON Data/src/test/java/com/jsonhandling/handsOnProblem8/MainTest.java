package com.jsonhandling.handsOnProblem8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseToJSONReportTest {
    @Test
    void testGenerateJSONReport() {
        DatabaseToJSONReport generator = new DatabaseToJSONReport();
        try {
            String json = generator.generateJSONReport(
                    "jdbc:h2:mem:testdb", // Use an in-memory H2 database for testing
                    "sa",
                    ""
            );
            assertTrue(json.contains("\"name\" : \"John\""));
            assertTrue(json.contains("\"age\" : 25"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}