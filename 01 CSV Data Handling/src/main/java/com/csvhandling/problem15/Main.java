package com.csvhandling.problem15;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CSVEncryption encryption = new CSVEncryption();

            // Encrypt the CSV file
            encryption.encryptCSV("C:\\Users\\shriy\\OneDrive\\Pictures\\Documents\\Desktop\\Capgemini Training\\Java Full Stack\\Week 05 - IO Programming\\01 CSV Data Handling\\src\\main\\resources\\employees.csv", "encrypted_employees.csv");
            System.out.println("CSV file encrypted successfully.");

            // Decrypt the CSV file
            encryption.decryptCSV("encrypted_employees.csv", "decrypted_employees.csv");
            System.out.println("CSV file decrypted successfully.");
        } catch (Exception e) {
            System.err.println("Error during encryption/decryption: " + e.getMessage());
        }
    }
}