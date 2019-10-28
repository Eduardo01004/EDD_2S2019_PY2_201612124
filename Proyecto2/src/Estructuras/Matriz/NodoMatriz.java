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
public class NodoMatriz {
    public int x;
    public int y;
    public String carpeta;
    public NodoMatriz siguiente;
    public NodoMatriz atras;
    public NodoMatriz arriba;
    public NodoMatriz abajo;

    public NodoMatriz(int x, int y, String carpeta) {
        this.x = x;
        this.y = y;
        this.carpeta = carpeta;
        this.abajo = null;
        this.arriba = null;
        this.siguiente = null;
        this.atras = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getAtras() {
        return atras;
    }

    public void setAtras(NodoMatriz atras) {
        this.atras = atras;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }
    
    
    
}
