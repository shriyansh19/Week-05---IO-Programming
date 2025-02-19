package com.jsonhandling.problem4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONMergerTest {
    @Test
    void testMergeJSONObjects() {
        JSONMerger merger = new JSONMerger();
        try {
            String mergedJSON = merger.mergeJSONObjects("test_file1.json", "test_file2.json");
            assertTrue(mergedJSON.contains("\"name\" : \"John Doe\""));
            assertTrue(mergedJSON.contains("\"age\" : 30"));
            assertTrue(mergedJSON.contains("\"city\" : \"New York\""));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}