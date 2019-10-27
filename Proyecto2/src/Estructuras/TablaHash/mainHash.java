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
            tabla.insertar("Eduardo","pus");
	    tabla.insertar("Saul", "sdas");
	    tabla.generarDotTablaHash();
            //tabla.extraerNodo("Eduardo");
	    }
        
        
    
}
