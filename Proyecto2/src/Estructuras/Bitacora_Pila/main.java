/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Bitacora_Pila;

/**
 *
 * @author Eduardo
 */
public class main {
    
    public  static void main(String[] args)  {
        Bitacora_Pila pila= new Bitacora_Pila();
        pila.Insertar("25/10/2019", "16:40", "elimino"+"1","Saul");
        pila.Insertar("26/10/2019", "16:41", "elimino","Saul");
        pila.Insertar("27/10/2019", "16:42", "elimino","Saul");
        pila.Insertar("28/10/2019", "16:43", "elimino","Saul");
        pila.Insertar("29/10/2019", "16:44", "elimino","Saul");
        pila.Mostrar();    
    }
    
}
