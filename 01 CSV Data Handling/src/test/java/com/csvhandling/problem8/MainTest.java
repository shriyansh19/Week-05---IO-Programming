package com.csvhandling.problem8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CSVValidatorTest {
    @Test
    void testValidateCSV() {
        CSVValidator validator = new CSVValidator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            validator.validateCSV("test_contacts.csv"); // Use a test CSV file
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }

        String expectedOutput = "Invalid email at line 2: invalid.email\n" +
                "Invalid phone number at line 3: 12345\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}