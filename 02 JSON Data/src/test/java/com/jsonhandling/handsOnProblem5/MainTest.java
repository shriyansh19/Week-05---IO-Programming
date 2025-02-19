package com.jsonhandling.handsOnProblem5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONFileMergerTest {
    @Test
    <JSONFileMerger>
    void testMergeJSONFiles() {
        JSONFileMerger merger = new JSONFileMerger();
        try {
            String mergedJSON = merger.mergeJSONFiles("test_file1.json", "test_file2.json");
            assertTrue(mergedJSON.contains("\"name\" : \"John Doe\""));
            assertTrue(mergedJSON.contains("\"age\" : 30"));
            assertTrue(mergedJSON.contains("\"city\" : \"New York\""));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}