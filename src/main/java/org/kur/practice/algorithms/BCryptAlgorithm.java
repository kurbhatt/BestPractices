package org.kur.practice.algorithms;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by Keyur on 29/8/17.
 * This class Demonstrate the use of BCrypt library for generating secure hash.
 */
public class BCryptAlgorithm {

    public static void main(String[] args) {
        String plainText = "thisismypassword";

        String hashedPassword = hashPassword(plainText);
        System.out.println("Hashed Password using BCrypt: " + hashedPassword);
        System.out.println("BCrypt Verification: " + verifyPassword(plainText , hashedPassword));
    }

    private static String hashPassword(String plainText){
        String salt = BCrypt.gensalt(15);
        return BCrypt.hashpw(plainText, salt);
    }

    private static Boolean verifyPassword(String plainText, String hashedPassword){
        if(null == hashedPassword || !hashedPassword.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(plainText, hashedPassword);
    }
}
