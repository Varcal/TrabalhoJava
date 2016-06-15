/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author varcal
 */
public class StringHelper {
    
    public static String encriptar(String senha){
        
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhaEncriptada = hexString.toString();

            return senhaEncriptada;
        } catch (NoSuchAlgorithmException e) {
            return "Erro ao encriptar a senha";
        }        
        catch(UnsupportedEncodingException e){
            return "Erro ao encriptar a senha";
        }
    }    
}
