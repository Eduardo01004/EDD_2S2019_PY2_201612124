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
public class NodoPila {
    public String fecha;
    public String hora;
    public String operacion;
    public String usuario;
    NodoPila siguiente;

    public NodoPila(String fecha, String hora, String operacion, String usuario) {
        this.fecha = fecha;
        this.hora = hora;
        this.operacion = operacion;
        this.usuario = usuario;
        this.siguiente = null;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
