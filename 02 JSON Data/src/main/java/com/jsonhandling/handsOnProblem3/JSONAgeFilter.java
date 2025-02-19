package com.jsonhandling.handsOnProblem3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONAgeFilter {
    public void filterUsersByAge(String filePath, int ageThreshold) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file as an array of objects
        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        if (!rootNode.isArray()) {
            throw new IllegalArgumentException("JSON must be an array of objects.");
        }

        // Iterate through each object in the array
        for (JsonNode node : rootNode) {
            int age = node.path("age").asInt();
            if (age > ageThreshold) {
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node));
            }
        }
    }
}