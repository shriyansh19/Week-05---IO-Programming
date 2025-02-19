package com.jsonhandling.handsOnProblem7;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.Arrays;

public class CSVToJSONConverter {
    public String convertCSVToJSON(String csvFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values[i]);
                }
                jsonArray.add(jsonObject);
            }
        }

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
    }
}