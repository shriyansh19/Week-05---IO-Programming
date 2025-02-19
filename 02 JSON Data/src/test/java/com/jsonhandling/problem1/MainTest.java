package com.jsonhandling.problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentJSONCreatorTest {
    @Test
    void testCreateStudentJSON() {
        StudentJSONCreator creator = new StudentJSONCreator();
        try {
            String json = creator.createStudentJSON();
            assertTrue(json.contains("\"name\" : \"John Cena\""));
            assertTrue(json.contains("\"age\" : 20"));
            assertTrue(json.contains("\"subjects\" : [ \"Math\", \"Science\", \"History\" ]"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}