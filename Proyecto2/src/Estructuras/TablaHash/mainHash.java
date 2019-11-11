/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.TablaHash;

import Estructuras.Inserts.Metodos;
import Estructuras.Matriz.NodoMatriz;

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
                NodoMatriz s = nodo.matriz.BuscarC("home");
                if (s != null){
                    s.arbol.InsertarAvl("un_archivo", "Sd", "asd","asd");
                    s.arbol.InsertarAvl("otro_archivo", "Sd", "asd","asd");
                    s.arbol.GraficarAVL("Usuario");
                    s.arbol.inorder(s.arbol.raiz);
                    s.arbol.Prueba(nodo, s, "home", "vendor");
                    /*while (s!= null ){
                        for (int i = 0; i< Metodos.al.size(); i++){
                          System.out.println("Carpeta Padre : " + s.y +" Carpetas Dentro: " +s.x+ " archivos: " +Metodos.al.get(i));
                                
                        }
                        s=s.arriba;
                    }*/
                    
                    //System.out.println(s.arbol.raiz.nombre);
                    
                }else System.out.println("No se encuentra");
                
            }
               
            
            
            //tabla.extraerNodo("Eduardo");
	    }
        
        
    
}
