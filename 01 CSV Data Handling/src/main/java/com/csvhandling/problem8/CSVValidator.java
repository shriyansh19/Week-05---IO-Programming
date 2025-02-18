package com.csvhandling.problem8;

import java.io.*;
import java.util.regex.Pattern;

public class CSVValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public void validateCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.printf("Invalid row at line %d: Missing columns%n", lineNumber);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.printf("Invalid email at line %d: %s%n", lineNumber, email);
                }

                if (!phone.matches("\\d{10}")) {
                    System.out.printf("Invalid phone number at line %d: %s%n", lineNumber, phone);
                }
            }
        }
    }
}