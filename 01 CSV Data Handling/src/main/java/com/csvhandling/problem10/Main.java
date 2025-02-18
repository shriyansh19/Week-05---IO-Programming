package com.csvhandling.problem10;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVMerger merger = new CSVMerger();
        try {
            merger.mergeCSVFiles("students1.csv", "students2.csv", "merged_students.csv");
            System.out.println("Merged records saved to merged_students.csv.");
        } catch (IOException e) {
            System.err.println("Error processing the files: " + e.getMessage());
        }
    }
}