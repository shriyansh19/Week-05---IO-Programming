package com.jsonhandling.problem5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONValidatorTest {
    @Test
    void testValidateJSONStructure() {
        JSONValidator validator = new JSONValidator();
        try {
            assertTrue(validator.validateJSONStructure("test_valid_user.json"));
            assertFalse(validator.validateJSONStructure("test_invalid_user.json"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}