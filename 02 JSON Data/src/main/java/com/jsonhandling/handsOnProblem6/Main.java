package com.jsonhandling.handsOnProblem6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONToXMLConverter converter = new JSONToXMLConverter();
        try {
            String xml = converter.convertJSONToXML("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\user.json");
            System.out.println(xml);
        } catch (IOException e) {
            System.err.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}