package com.jsonhandling.handsOnProblem6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JSONToXMLConverterTest {
    @Test
    void testConvertJSONToXML() {
        JSONToXMLConverter converter = new JSONToXMLConverter();
        try {
            String xml = converter.convertJSONToXML("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json");
            assertTrue(xml.contains("<name>John Doe</name>"));
            assertTrue(xml.contains("<age>30</age>"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}