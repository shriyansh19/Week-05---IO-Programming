package com.ipl.censor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Process JSON input
            String jsonInputPath = "C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\ipl_matches.json";
            String jsonOutputPath = "censored_ipl_matches.json";
            IPLCensor.processJSON(jsonInputPath, jsonOutputPath);

            // Process CSV input
            String csvInputPath = "C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\02 JSON Data\\src\\main\\resources\\ipl_matches.csv";
            String csvOutputPath = "censored_ipl_matches.csv";
            IPLCensor.processCSV(csvInputPath, csvOutputPath);

            System.out.println("Censorship applied successfully. Check output files.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}