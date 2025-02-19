package com.jsonhandling.handsOnProblem8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;
import java.util.Properties;

public class DatabaseToJSONReport {
    public String generateJSONReport(String dbUrl, String username, String password) throws SQLException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try (Connection conn = DriverManager.getConnection(dbUrl, props);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, age, email FROM users")) {

            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("age", rs.getInt("age"));
                jsonObject.put("email", rs.getString("email"));
                jsonArray.add(jsonObject);
            }
        }

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
    }
}