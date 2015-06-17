/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facci.csUtilitarios;

import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;
import com.sun.org.apache.xml.internal.utils.StringComparable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author HPENVY
 */
public class csUtilitarios {

    public static String getMd5Hash(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
//        MD5 md5Hasher = MD5.Create();
//        byte[] data = md5Hasher.ComputeHash(Encoding.getBytes(input));
//
//        StringBuilder sBuilder = new StringBuilder();
//
//        for (int i = 0; i < data.length; i++)
//        {
//            sBuilder.append(data[i]+("x2"));
//        }
//
//        return sBuilder.toString();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] data = md.digest(input.getBytes("UTF-8"));
            StringBuilder sBuilder = new StringBuilder(2*data.length);
            for (byte b : data) {
                sBuilder.append(String.format("%02x", b&0xff));
            }
            return  sBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    public static boolean verifyMd5Hash(String input, String hash) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        String hashOfInput = getMd5Hash(input);
//        StringComparer comparer = StringComparer.OrdinalIgnoreCase;
//        if (0 == comparer.Compare(hashOfInput, hash))

        if (hashOfInput.equalsIgnoreCase(hash))
        { return true; }
        else 
        { return false; }
    }
    private String desencriptar(String val)
    {
        return "";
    }
    
}
