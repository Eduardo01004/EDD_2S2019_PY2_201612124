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
public class Bitacora_Pila {
    public NodoPila primero;
    public NodoPila ultimo;

    public Bitacora_Pila() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void Insertar(String fecha, String hora, String operacion, String usuario){
        NodoPila nuevo= new NodoPila(fecha, hora, operacion, usuario);
        if(primero == null){
            primero = nuevo;
            nuevo.siguiente = null;
            ultimo = primero;
        }
        else{
            nuevo.siguiente = primero;
            primero = nuevo;
        }
            
    }
    
    public void Mostrar(){
        NodoPila aux=primero;
        if(aux != null){
            while(aux != null){
                System.out.println(aux.getFecha()+" "+aux.getHora()+" "+aux.getOperacion()+" "+aux.getUsuario());
                aux=aux.getSiguiente();
            }
        }
        
    }
    
}
