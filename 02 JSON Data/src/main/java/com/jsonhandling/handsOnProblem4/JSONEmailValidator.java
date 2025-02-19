package com.jsonhandling.handsOnProblem4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class JSONEmailValidator {
    public boolean validateEmailField(String jsonFilePath, String schemaFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load JSON and Schema
        JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));
        JsonNode schemaNode = objectMapper.readTree(new File(schemaFilePath));

        // Create a JSON Schema Validator
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaNode);

        // Validate the JSON against the schema
        Set<ValidationMessage> validationMessages = schema.validate(jsonNode);
        if (validationMessages.isEmpty()) {
            return true; // Valid
        } else {
            validationMessages.forEach(System.out::println); // Print validation errors
            return false; // Invalid
        }
    }
}