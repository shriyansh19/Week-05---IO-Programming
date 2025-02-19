package com.jsonhandling.problem3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONExtractor {
    public void extractFields(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        String name = rootNode.path("name").asText();
        String email = rootNode.path("email").asText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}