package com.csvhandling.problem2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public void writeData(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("1,John Doe,IT,5000\n");
            bw.write("2,Jane Smith,HR,4500\n");
            bw.write("3,Bob Johnson,Finance,6000\n");
            bw.write("4,Alice Brown,Marketing,4800\n");
            bw.write("5,Charlie Davis,IT,5500\n");
        }
    }
}