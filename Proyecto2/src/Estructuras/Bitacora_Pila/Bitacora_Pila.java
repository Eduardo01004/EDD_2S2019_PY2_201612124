/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Bitacora_Pila;

import java.io.FileWriter;
import java.io.PrintWriter;

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
    
    public void Graficar(){
        FileWriter fw = null;
        PrintWriter pw = null;
        try{
            fw = new FileWriter("Bitacora.dot");
            pw = new PrintWriter(fw);
            pw.println("digraph G{ rankdir=LR;");
            pw.println("node [shape= record, width=.1,height=.1];\n");
            pw.println("nodeTable [label = \" ");
            NodoPila aux = primero;
            if (aux != null){
                while(aux != null){
                    if (aux.getSiguiente() != null){
                        pw.println("|"+"TimeStamp: "+aux.getFecha()+aux.getHora()+"&#92;n Operacion: "+aux.getOperacion()+ "&#92;n "+aux.getUsuario());
                    }
                    else{
                        pw.println("|"+aux.getFecha()+"&#92;n"+aux.getHora()+"&#92;n Operacion: "+aux.getOperacion()+ "&#92;n "+aux.getUsuario());
                    }
                    aux = aux.getSiguiente();
                }
            }
            pw.println("\"];");
            pw.println("}");
            pw.close();
            String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath =  "Bitacora.dot";
            String fileOutPath = "Bitacora.png";
            String tParam = "-Tpng";
            String toParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = doPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = toParam;
            cmd[4] = fileOutPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        }catch(Exception e){
        }
    }
    
}
