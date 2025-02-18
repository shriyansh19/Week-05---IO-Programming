package com.csvhandling.problem14;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
import java.util.Iterator;

public class JSONCSVConverter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void jsonToCSV(String jsonFilePath, String csvFilePath) throws IOException {
        JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));
        ArrayNode arrayNode = (ArrayNode) rootNode;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            // Write header
            Iterator<String> fieldNames = arrayNode.get(0).fieldNames();
            bw.write(String.join(",", fieldNames));
            bw.newLine();

            // Write data
            for (JsonNode node : arrayNode) {
                Iterator<JsonNode> elements = node.elements();
                StringBuilder row = new StringBuilder();
                while (elements.hasNext()) {
                    row.append(elements.next().asText()).append(",");
                }
                bw.write(row.substring(0, row.length() - 1)); // Remove trailing comma
                bw.newLine();
            }
        }
    }

    public void csvToJSON(String csvFilePath, String jsonFilePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            ArrayNode jsonArray = objectMapper.createArrayNode();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JsonNode jsonObject = objectMapper.createObjectNode();
                for (int i = 0; i < headers.length; i++) {
                    ((ObjectNode) jsonObject).put(headers[i], values[i]);
                }
                jsonArray.add(jsonObject);
            }

            objectMapper.writeValue(new File(jsonFilePath), jsonArray);
        }
    }
}