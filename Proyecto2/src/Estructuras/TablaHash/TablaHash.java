/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.TablaHash;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Eduardo
 */
public class TablaHash {
    private int tamano;//tamano del arreglo de la tabla hash
    private static int[] tamanos;
    private int indiceTam;
    private int ocupados;//datps almacenados en la tabla
    private float porcentajeUtil;//para ver la capacidad de la tabla hash ha sido ocupada mas que todo para hacer rehashing
    private float factorUtil;
    public NodoHash[] vectorHash;//tiene todos los nodos hash

    public TablaHash() {
        this.tamanos = new int[]{7,11,13,19,21,23,27,29,31,33,39,41,43,49,51, 53, 59, 61, 67, 71, 73, 79, 81};//tamaño inicial
        this.indiceTam = 0;
        this.ocupados = 0;
        this.factorUtil = 80.00f;//para hacer rehashing
        this.tamano = tamanos[indiceTam];//toma el valor del vector este comienza en 7
        this.vectorHash = new NodoHash[tamano];//creo el vector con 7 de tamano
        this.porcentajeUtil = calcularPorcentajeUtil();
    }
    
    //para el desbordamiento//
    private float calcularPorcentajeUtil() {
        return (ocupados * 100) / tamano;
    }
    
    private int hash2(String id) {//funcion hash funcion por division k mod t
        int temporal=CodigoASCIINombre(id);
        return temporal % tamano;
    }
    
    public int CodigoASCIINombre(String nombre) {
        int nombretamano=nombre.length();;
        int total=0;
        for (int a=0; a<nombretamano; a++) {
            char character = nombre.charAt(a); // start on the first character
            int ascii = (int) character; //convert the first character
            total=total+ascii; 
           System.out.println(character+" = "+ ascii); // print the character and it's value in ascii
        }
        System.out.println(" total "+total);

        return total;
    }
    

    
    public void insertar(String nombre,String password) {
        boolean insertado = false;

        if (porcentajeUtil <= 75.00f) {///por el desbordamiento del 50% para que haga que crezca la tabla hash
            int posicion = hash2(nombre);
            if (posicion > tamano) {//si el tamaño es mayor a la posision se le resta al tamaño osea da una ciclo 
                posicion -= tamano; // y lo inserta                
            }   
            if (vectorHash[posicion] == null || vectorHash[posicion].estado == 'b') {//datos nulos y borrados y ocupados se ingresa el dato 
                //a un nuevo nodo hash
                vectorHash[posicion] = new NodoHash( nombre,password);
                ocupados += 1;
                porcentajeUtil = calcularPorcentajeUtil();
                insertado = true;
                System.out.println("Dato " + nombre + " " + "Posicion " + posicion);

            } else {
                if (vectorHash[posicion].nombre.equals(nombre)) {
                    System.out.println("La variable a insertar ya existe en la tabla: " + nombre);
                } else {
                    for (int i = 1; i < 10; i++) {
                        int posicionActual = posicion + (i+1)^2;//cuadratica 
                        if (posicionActual > tamano) {
                            posicionActual = i;
                        }
                        if (posicionActual < tamano && validarDisponibilidadColision(posicionActual)) {
                            vectorHash[posicionActual] = new NodoHash(nombre,password);
                            ocupados += 1;//suma uno a ocupados 
                            porcentajeUtil = calcularPorcentajeUtil();//no sobrepase el 50%
                            insertado = true;
                            break;
                        }
                        //cuando hay colision automaticamente el proceso sigue hasta que se pueda insertar el dato
                        System.out.println("Colision en la pos: " + posicion);                        
                    }
                }
            }
            if (insertado == true) {
                System.out.println("Se inserto correctamente el dato " + nombre);
            } else {
                System.out.println("No se pudo insertar el dato " + nombre);
            }
        } else {
            System.out.println("Hacer Rehashing -> Porcentaje util: " + porcentajeUtil);            
            rehashing();
            insertar(nombre,password);
        }
    }
    public boolean validarDisponibilidadColision(int posicion) {
        if (vectorHash[posicion] == null || vectorHash[posicion].estado == 'b') {
            return true;
        }
        return false;
    }
    public void rehashing() {///cuando sobrepase el 75 aumente el tamano de la tabla hash
        NodoHash[] tmp = vectorHash;
        int tamanoTmp = tamano;
        if (indiceTam < tamanos.length) {
            indiceTam += 1;
            if (indiceTam == tamanos.length - 1) { //esto pasa cuando se llega al tamano maximo del arreglo o vector en este casi es 81
                System.out.println("Se alcanzo el tamano maximo del arreglo");
            }
        }
        tamano = tamanos[indiceTam];
        vectorHash = new NodoHash[tamano];
        ocupados = 0;
        porcentajeUtil = calcularPorcentajeUtil();
        for (int i = 0; i < tamanoTmp; i++) {// se va insertando el nodo hash con el arreglo aumentado de tamano
            if (tmp[i] != null) {
                insertar(tmp[i].nombre,tmp[i].password);
            }
        }
        System.out.println("Rehashing realizado correctamente");
    }
    
    
    
    
    public void generarDotTablaHash() {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("HashTable.dot");            
            pw = new PrintWriter(fw);
            pw.println("digraph G{ rankdir=LR;");
            pw.println("node [shape= record, width=.1,height=.1];");
            pw.println("nodeTable [label = \" ");
            for (int i = 0; i < vectorHash.length; i++) {//COMIENZO DEL FOR PARA LLENAR LOS DATOS DE LA HASH
                pw.print("<f" + i + "> " + i);
                if (i != vectorHash.length - 1) {
                    pw.println(" | ");
                } else {
                    pw.println("\"];");
                }
            }    ///fin for datos hash   
            for (int i = 0; i < vectorHash.length; i++) {
                if (vectorHash[i] != null) {
                    pw.println("nodo" + vectorHash[i].nombre + " [label= \"" +  "Nombre: "+vectorHash[i].nombre + " " + "Password: "+vectorHash[i].password+ "\"];");
                    pw.println("\"nodeTable\":f" + i + " -> nodo" + vectorHash[i].nombre);
                }
            }


            pw.println("}");

            try{
                String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                String fileInputPath="HashTable.dot";
                String fileOutPath="HashTable.png";            
                String tParam="-Tpng";
                String toParam="-o";
                String[] cmd=new String[5];
                cmd[0]=doPath;
                cmd[1]=tParam;
                cmd[2]=fileInputPath;
                cmd[3]=toParam;
                cmd[4]=fileOutPath;
                Runtime rt = Runtime.getRuntime();
                rt.exec(cmd);
                rt.exec("HashTable.png");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != fw) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
