package com.jsonhandling.handsOnProblem5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONMerger merger = new JSONMerger();
        try {
            String mergedJSON = merger.mergeJSONObjects("file1.json", "file2.json");
            System.out.println(mergedJSON);
        } catch (IOException e) {
            System.err.println("Error merging JSON files: " + e.getMessage());
        }
    }
}