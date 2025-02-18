package com.csvhandling.problem9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

class CSVToObjectConverterTest {
    @Test
    void testConvertToObjects() {
        CSVToObjectConverter converter = new CSVToObjectConverter();
        try {
            List<Student> students = converter.convertToObjects("test_students.csv");
            assertEquals(2, students.size());
            assertEquals("John", students.get(0).getName());
            assertEquals(85, students.get(0).getMarks());
        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}