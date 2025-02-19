package com.jsonhandling.problem1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StudentJSONCreator {
    public String createStudentJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a JSON object
        ObjectNode student = objectMapper.createObjectNode();
        student.put("name", "John Cena");
        student.put("age", 20);
        student.putArray("subjects").add("Math").add("Science").add("History");

        // Convert to JSON string
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
    }
}