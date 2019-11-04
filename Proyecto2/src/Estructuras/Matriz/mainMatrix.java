/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Matriz;

/**
 *
 * @author Eduardo
 */
public class mainMatrix {
    public  static void main(String[] args)  {
        Matriz matrix= new Matriz();
        matrix.existeX("/");
        matrix.existeY("/");
        matrix.existeX("home");
        matrix.existeY("home");
        matrix.existeX("documents");
        matrix.existeY("documents");
        matrix.existeX("usac");
        matrix.existeY("usac");
        matrix.existeX("vendor");
        matrix.existeY("vendor");
        matrix.existeX("view");
        matrix.existeY("view");
        matrix.guardarMatriz("home", "/");
        matrix.guardarMatriz("documents", "home");
        matrix.guardarMatriz("usac", "documents");
        matrix.guardarMatriz("vendor", "documents");
        matrix.guardarMatriz("view", "vendor");
        
        
        matrix.Graficar();
            
    }
    
}
