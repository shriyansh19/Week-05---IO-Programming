package com.jsonhandling.problem4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JSONMerger {
    public String mergeJSONObjects(String filePath1, String filePath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the first JSON object
        JsonNode json1 = objectMapper.readTree(new File(filePath1));

        // Read the second JSON object
        JsonNode json2 = objectMapper.readTree(new File(filePath2));

        // Merge the two JSON objects
        ObjectNode merged = objectMapper.createObjectNode();
        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);

        // Convert to JSON string
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged);
    }
}