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
public class Cabecera {
    public Cabecera siguiente;
    public Cabecera anterior;
    public NodoMatriz primero;
    public NodoMatriz ultimo;
    public int numero;
    public String carpeta;

    public Cabecera() {
        this.siguiente=null;
        this.anterior=null;
        this.primero=null;
        this.ultimo=null;
    }

    public Cabecera getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cabecera siguiente) {
        this.siguiente = siguiente;
    }

    public Cabecera getAnterior() {
        return anterior;
    }

    public void setAnterior(Cabecera anterior) {
        this.anterior = anterior;
    }

    public NodoMatriz getPrimero() {
        return primero;
    }

    public void setPrimero(NodoMatriz primero) {
        this.primero = primero;
    }

    public NodoMatriz getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoMatriz ultimo) {
        this.ultimo = ultimo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }
    
    
    
    
    
}
