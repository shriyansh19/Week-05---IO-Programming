package com.csvhandling.problem15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

class CSVEncryptionTest {
    @Test
    void testEncryptAndDecryptCSV() {
        try {
            CSVEncryption encryption = new CSVEncryption();

            // Encrypt the CSV file
            encryption.encryptCSV("test_employees.csv", "test_encrypted_employees.csv");

            // Decrypt the CSV file
            encryption.decryptCSV("test_encrypted_employees.csv", "test_decrypted_employees.csv");

            // Verify the content of the decrypted file matches the original
            try (BufferedReader brOriginal = new BufferedReader(new FileReader("test_employees.csv"));
                 BufferedReader brDecrypted = new BufferedReader(new FileReader("test_decrypted_employees.csv"))) {

                String originalLine, decryptedLine;
                while ((originalLine = brOriginal.readLine()) != null && (decryptedLine = brDecrypted.readLine()) != null) {
                    assertEquals(originalLine, decryptedLine);
                }
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}