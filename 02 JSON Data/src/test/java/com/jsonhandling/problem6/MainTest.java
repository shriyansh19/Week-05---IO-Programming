package com.jsonhandling.problem6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

class ListToJSONArrayConverterTest {
    @Test
    void testConvertListToJSON() {
        ListToJSONArrayConverter converter = new ListToJSONArrayConverter();
        try {
            String json = converter.convertListToJSON(Arrays.asList(
                    new User("John", 25),
                    new User("Jane", 30)
            ));
            assertTrue(json.contains("\"name\" : \"John\""));
            assertTrue(json.contains("\"age\" : 25"));
            assertTrue(json.contains("\"name\" : \"Jane\""));
            assertTrue(json.contains("\"age\" : 30"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}