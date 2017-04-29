/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementrsa;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author S
 */
public class ImplementRSA {
    public static void main(String[] args) throws UnsupportedEncodingException{
        rsaclass rsa = new rsaclass();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter plaintext");
        String plaintext = input.nextLine();
        
        System.out.println("Encrypting String: " + plaintext);
        System.out.println("String in Bytes: "
                + byteToString(plaintext.getBytes()));
        
        byte[] encrypted = rsa.encrypt(plaintext.getBytes());
        System.out.println("Encrypted: " + byteToString(encrypted));
        
        byte[] decrypted = rsa.decrypt(encrypted);
        
        System.out.println("Decrypted Bytes: " + byteToString(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));
    }
    
    private static String byteToString(byte[] encrypted)
    {
        String r = "";
        for (byte b : encrypted)
        {
            r += Byte.toString(b);
        }
        return r;
    }
}
