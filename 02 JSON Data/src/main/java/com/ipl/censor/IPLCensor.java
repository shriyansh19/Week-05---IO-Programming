package com.ipl.censor;

import java.io.IOException;

public class IPLCensor {
    public static void processJSON(String inputPath, String outputPath) throws IOException {
        JSONProcessor processor = new JSONProcessor();
        processor.applyCensorship(inputPath, outputPath);
    }

    public static void processCSV(String inputPath, String outputPath) throws IOException {
        CSVProcessor processor = new CSVProcessor();
        processor.applyCensorship(inputPath, outputPath);
    }
}