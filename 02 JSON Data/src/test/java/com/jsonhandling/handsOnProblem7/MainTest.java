package com.jsonhandling.handsOnProblem7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVToJSONConverterTest {
    @Test
    void testConvertCSVToJSON() {
        CSVToJSONConverter converter = new CSVToJSONConverter();
        try {
            String json = converter.convertCSVToJSON("test_users.csv");
            assertTrue(json.contains("\"name\" : \"John\""));
            assertTrue(json.contains("\"age\" : \"20\""));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}