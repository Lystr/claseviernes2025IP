/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author slaye
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "admin";

        // Hashing
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());

        // Convert bytes to hex
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("Hashed Password: " + hexString.toString());
    }
}
//ff7bd97b1a7789ddd2775122fd6817f3173672da9f802ceec57f284325bf589f
//73c3de4175449987ef6047f6e0bea91c1036a8599b43113b3f990104ab294a47