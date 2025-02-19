package com.jsonhandling.problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarToJSONConverterTest {
    @Test
    void testConvertCarToJSON() {
        Car car = new Car("Toyota", "Corolla", 2020);
        CarToJSONConverter converter = new CarToJSONConverter();
        try {
            String json = converter.convertCarToJSON(car);
            assertTrue(json.contains("\"make\" : \"Toyota\""));
            assertTrue(json.contains("\"model\" : \"Corolla\""));
            assertTrue(json.contains("\"year\" : 2020"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}