package com.jsonhandling.handsOnProblem4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONEmailValidatorTest {
    @Test
    void testValidateEmailField() {
        JSONEmailValidator validator = new JSONEmailValidator();
        try {
            assertTrue(validator.validateEmailField("test_valid_user.json", "email_schema.json"));
            assertFalse(validator.validateEmailField("test_invalid_user.json", "email_schema.json"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}