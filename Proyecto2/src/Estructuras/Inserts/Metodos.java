/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Inserts;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Metodos {
    private static String nombre_user = "";
    private static String carpeta_file1 = "";
    private static String carpeta_file2 = "";
    public  static ArrayList<String> al = new ArrayList<String>();
    
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
    
    public byte[] Imagen(File Archivo){
        byte[] img = new byte[1024*100];
        try{
        FileInputStream entrada = new FileInputStream(Archivo);
        entrada.read(img);
        }catch(Exception x){
            
        }
        return img;  
    }

    public static String getNombre_user() {
        return nombre_user;
    }

    public static void setNombre_user(String nombre_user) {
        Metodos.nombre_user = nombre_user;
    }

    public static String getCarpeta_file1() {
        return carpeta_file1;
    }

    public static void setCarpeta_file1(String carpeta_file1) {
        Metodos.carpeta_file1 = carpeta_file1;
    }

    public static String getCarpeta_file2() {
        return carpeta_file2;
    }

    public static void setCarpeta_file2(String carpeta_file2) {
        Metodos.carpeta_file2 = carpeta_file2;
    }

    
    
}
