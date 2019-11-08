/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Inserts;

import java.security.MessageDigest;

/**
 *
 * @author Eduardo
 */
public class Metodos {
    private static String nombre_user = "";
    
    public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
    
    
}

    public static String getNombre_user() {
        return nombre_user;
    }

    public static void setNombre_user(String nombre_user) {
        Metodos.nombre_user = nombre_user;
    }
    
}
