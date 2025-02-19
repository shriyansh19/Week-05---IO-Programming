package com.jsonhandling.handsOnProblem6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;

public class JSONToXMLConverter {
    public String convertJSONToXML(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file
        JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));

        // Convert JSON to XML using org.json library
        JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(jsonNode));
        return XML.toString(jsonObject);
    }
}