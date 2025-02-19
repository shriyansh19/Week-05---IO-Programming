package com.jsonhandling.problem2;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJSONConverter {
    public String convertCarToJSON(Car car) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
    }
}