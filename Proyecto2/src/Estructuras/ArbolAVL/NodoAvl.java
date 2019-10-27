/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.ArbolAVL;

/**
 *
 * @author Eduardo
 */
public class NodoAvl {
    public String nombre;
    public String extension;
    public String contenido;
    public String timestamp;
    public int altura;
    public NodoAvl izquierdo;
    public NodoAvl derecho;

    public NodoAvl(String nombre, String extension, String contenido, String timestamp) {
        this.nombre = nombre;
        this.extension = extension;
        this.contenido = contenido;
        this.timestamp = timestamp;
        this.altura = 0;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAvl getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAvl izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAvl getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAvl derecho) {
        this.derecho = derecho;
    }
    
    
    
    
    
}
