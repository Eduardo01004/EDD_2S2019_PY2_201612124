/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.TablaHash;

/**
 *
 * @author Eduardo
 */
public class mainHash {
    static TablaHash tabla = new TablaHash();
	public  static void main(String[] args)  {
            tabla=new TablaHash();
            tabla.insertar("Eduardo","pus","sds");
	    tabla.insertar("Saul", "sdas","sda");
	    tabla.generarDotTablaHash();
            NodoHash nodo=tabla.extraerNodo("Saul");
            if (nodo != null){
                nodo.matriz.existeX("/");
                nodo.matriz.existeY("/");
                nodo.matriz.existeX("home");
                nodo.matriz.existeY("home");
                nodo.matriz.existeX("documents");
                nodo.matriz.existeY("documents");
                nodo.matriz.existeX("usac");
                nodo.matriz.existeY("usac");
                nodo.matriz.existeX("vendor");
                nodo.matriz.existeY("vendor");
                nodo.matriz.existeX("view");
                nodo.matriz.existeY("view");
                nodo.matriz.guardarMatriz("home", "/");
                nodo.matriz.guardarMatriz("documents", "home");
                nodo.matriz.guardarMatriz("usac", "documents");
                nodo.matriz.guardarMatriz("vendor", "documents");
                nodo.matriz.guardarMatriz("view", "vendor");
                nodo.matriz.Graficar();
            }
                nodo.matriz.Buscar("documents","vendor");
            
            
            //tabla.extraerNodo("Eduardo");
	    }
        
        
    
}
