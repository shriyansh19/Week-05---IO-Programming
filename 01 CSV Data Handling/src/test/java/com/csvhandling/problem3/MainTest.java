package com.csvhandling.problem3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CSVRowCountTest {
    @Test
    void testCountRows() {
        CSVRowCount counter = new CSVRowCount();
        try {
            int rowCount = counter.countRows("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\students.csv");
            assertEquals(5, rowCount); // Assuming test_students.csv has 2 rows
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}