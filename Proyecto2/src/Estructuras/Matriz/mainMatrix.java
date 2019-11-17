/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Matriz;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Eduardo
 */
public class mainMatrix {
    public  static void main(String[] args) throws IOException  {
        Matriz matrix= new Matriz();
        matrix.existeX("/");
        matrix.existeY("/");
        matrix.existeX("home");
        matrix.existeY("home");
        matrix.existeX("user");
        matrix.existeY("user");
        matrix.existeX("var");
        matrix.existeY("var");
        matrix.existeX("documents");
        matrix.existeY("documents");
        matrix.existeX("usac");
        matrix.existeY("usac");
        matrix.existeX("videos");
        matrix.existeY("videos");
        matrix.existeX("folder");
        matrix.existeY("folder");
        matrix.existeX("credentials");
        matrix.existeY("credentials");
        matrix.existeX("temp");
        matrix.existeY("temp");
        matrix.existeX("cache");
        matrix.existeY("cache");
        matrix.existeX("oracle");
        matrix.existeY("oracle");
        matrix.guardarMatriz("/", "/");
        matrix.guardarMatriz("home", "/");
        matrix.guardarMatriz("user", "/");
        matrix.guardarMatriz("var", "/");
        matrix.guardarMatriz("temp", "/");
        matrix.guardarMatriz("documents", "home");
        matrix.guardarMatriz("videos", "home");
        matrix.guardarMatriz("folder", "user");
        matrix.guardarMatriz("credentials", "user");
        matrix.guardarMatriz("usac", "documents");
        matrix.guardarMatriz("oracle", "var");
        matrix.guardarMatriz("cache", "temp");
        
        matrix.Grafo();
        matrix.Graficar();
        
        
            
    }
    
}
