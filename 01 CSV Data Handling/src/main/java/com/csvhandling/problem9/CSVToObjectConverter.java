package com.csvhandling.problem9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjectConverter {
    public List<Student> convertToObjects(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                int marks = Integer.parseInt(data[3].trim());
                students.add(new Student(id, name, age, marks));
            }
        }
        return students;
    }
}