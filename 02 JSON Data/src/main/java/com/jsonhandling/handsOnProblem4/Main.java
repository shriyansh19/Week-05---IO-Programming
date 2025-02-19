package com.jsonhandling.handsOnProblem4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONEmailValidator validator = new JSONEmailValidator();
        try {
            boolean isValid = validator.validateEmailField("user.json", "email_schema.json");
            System.out.println("Is email valid? " + isValid);
        } catch (IOException e) {
            System.err.println("Error validating email field: " + e.getMessage());
        }
    }
}