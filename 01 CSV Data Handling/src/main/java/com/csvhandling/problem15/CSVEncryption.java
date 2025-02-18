package com.csvhandling.problem15;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class CSVEncryption {
    private SecretKey secretKey;

    public CSVEncryption() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        this.secretKey = keyGen.generateKey();
    }

    public void encryptCSV(String inputFilePath, String outputFilePath) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                byte[] encryptedBytes = cipher.doFinal(line.getBytes());
                String encryptedLine = Base64.getEncoder().encodeToString(encryptedBytes);
                bw.write(encryptedLine);
                bw.newLine();
            }
        }
    }

    public void decryptCSV(String inputFilePath, String outputFilePath) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                byte[] decodedBytes = Base64.getDecoder().decode(line);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                bw.write(new String(decryptedBytes));
                bw.newLine();
            }
        }
    }
}