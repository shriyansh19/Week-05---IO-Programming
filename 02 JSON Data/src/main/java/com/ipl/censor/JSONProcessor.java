package com.ipl.censor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JSONProcessor {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void applyCensorship(String inputPath, String outputPath) throws IOException {
        // Read JSON file
        JsonNode rootNode = objectMapper.readTree(new File(inputPath));
        if (!rootNode.isArray()) {
            throw new IllegalArgumentException("JSON must be an array of objects.");
        }

        ArrayNode matches = (ArrayNode) rootNode;

        // Apply censorship rules
        for (JsonNode match : matches) {
            ObjectNode matchNode = (ObjectNode) match;

            // Mask team names
            maskTeamName(matchNode, "team1");
            maskTeamName(matchNode, "team2");

            // Redact player of the match
            matchNode.put("player_of_match", "REDACTED");

            // Mask team names in score object
            JsonNode scoreNode = matchNode.get("score");
            if (scoreNode != null && scoreNode.isObject()) {
                ((ObjectNode) scoreNode).setAll(maskScore((ObjectNode) scoreNode));
            }
        }

        // Write sanitized JSON to output file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), matches);
    }

    private void maskTeamName(ObjectNode node, String fieldName) {
        String teamName = node.path(fieldName).asText();
        if (!teamName.isEmpty()) {
            String maskedName = teamName.split(" ")[0] + " ***";
            node.put(fieldName, maskedName);
        }
    }

    private ObjectNode maskScore(ObjectNode scoreNode) {
        ObjectNode maskedScore = scoreNode.objectNode();
        scoreNode.fields().forEachRemaining(entry -> {
            String teamName = entry.getKey();
            String maskedName = teamName.split(" ")[0] + " ***";
            maskedScore.put(maskedName, entry.getValue().asInt());
        });
        return maskedScore;
    }
}