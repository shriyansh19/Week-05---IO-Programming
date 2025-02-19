package com.ipl.censor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {
    public void applyCensorship(String inputPath, String outputPath) throws IOException {
        List<String[]> rows = new ArrayList<>();

        // Read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            boolean isHeader = true;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) {
                    headers = data; // Save header row
                    isHeader = false;
                } else {
                    // Mask team names
                    data[1] = maskTeamName(data[1]); // team1
                    data[2] = maskTeamName(data[2]); // team2

                    // Redact player of the match
                    data[6] = "REDACTED"; // player_of_match
                }
                rows.add(data);
            }
        }

        // Write sanitized CSV to output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            CharSequence headers = null;
            bw.write(String.join(",", headers));
            bw.newLine();

            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }

    private String maskTeamName(String teamName) {
        return teamName.split(" ")[0] + " ***";
    }
}