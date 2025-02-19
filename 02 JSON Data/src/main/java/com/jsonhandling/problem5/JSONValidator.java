package com.jsonhandling.problem5;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONValidator {
    public boolean validateJSONStructure(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            // Check for required fields
            if (!rootNode.has("name") || !rootNode.has("age")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false; // Invalid JSON structure
        }
    }
}