package com.jsonhandling.handsOnProblem1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONReader {
    public void printKeysAndValues(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        rootNode.fields().forEachRemaining(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}