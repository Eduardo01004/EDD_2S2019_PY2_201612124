/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.ArbolAVL;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Eduardo
 */
public class ArbolAvl {
    public NodoAvl raiz;
    public int Fe=0;
    /**
     * 
     */
    public ArbolAvl() {
        this.raiz = null;
    }
    /**
     * 
     * @param t
     * @return 
     */
    private int Altura(NodoAvl t){
        return t == null? -1 : t.altura;
    }
    
    private int Max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    
    public NodoAvl RotarIzq(NodoAvl nodo){
        NodoAvl avlnodo=nodo.getIzquierdo();
        nodo.setIzquierdo(avlnodo.getDerecho());
        avlnodo.setDerecho(nodo);
        nodo.setAltura(Max(Altura(nodo.getIzquierdo()), Altura(nodo.getDerecho()))+1);
        avlnodo.setAltura(Max(Altura(avlnodo.getIzquierdo()), nodo.getAltura())+1);
        
        return avlnodo;
    }
    
    public NodoAvl RotarDer(NodoAvl nodo){
        NodoAvl avlnode = nodo.getDerecho();
        nodo.setDerecho(avlnode.getIzquierdo());
        avlnode.setIzquierdo(nodo);
        nodo.setAltura(Max(Altura(nodo.getIzquierdo()), Altura(nodo.getDerecho())) + 1);
        avlnode.setAltura(Max(Altura(avlnode.getDerecho()), nodo.getAltura()) + 1);
        return avlnode;
    }
 
    public NodoAvl RotarDobleIzq(NodoAvl nodo){
        nodo.setIzquierdo(RotarDer(nodo.getIzquierdo()));
        return RotarIzq(nodo);
    }
    
    public NodoAvl RotarDobleDer(NodoAvl nodo){
        nodo.setDerecho(RotarIzq(nodo.getDerecho()));
        return RotarDer(nodo);
    }
    
    private int getFactorEquilibrio(NodoAvl t) {
    	if(t == null) {
    		return 0;
    	}else {
    		return Altura(t.getIzquierdo())-Altura(t.getDerecho());
    	}
    }
        
    public NodoAvl Insertar(String nombre,String extension,String contenido,String time,NodoAvl nuevo){
        if (nuevo == null){
            nuevo = new NodoAvl(nombre, extension, contenido, time);
        }
        else if(nombre.compareTo(nuevo.getNombre()) < 0){
            nuevo.setIzquierdo(Insertar(nombre, extension, contenido, time, nuevo.getIzquierdo()));
            if(getFactorEquilibrio(nuevo) == 2){
                if(nombre.compareTo(nuevo.getIzquierdo().getNombre()) < 0){
                    nuevo = RotarIzq(nuevo);
                }
                else{
                    nuevo = RotarDobleIzq(nuevo);
                }   
            } 
        }else if(nombre.compareTo(nuevo.getNombre()) > 0){
            nuevo.setDerecho(Insertar(nombre, extension, contenido, time, nuevo.getDerecho()));
            if(getFactorEquilibrio(nuevo) == 2){
                if(nombre.compareTo(nuevo.getDerecho().getNombre()) > 0){
                    nuevo = RotarDer(nuevo);
                }
                else{
                    nuevo = RotarDobleDer(nuevo);
                }
            }
        }
        else{
            
            System.out.println("Ya existe");
        }
        nuevo.setAltura(Max(Altura(nuevo.getIzquierdo()), Altura(nuevo.getDerecho())) + 1);
        
        return nuevo;
    }
    
    public void InsertarAvl(String nombre, String extension,String contenido,String time){
        raiz = Insertar(nombre, extension, contenido, time,raiz);
    }
    
    public NodoAvl Buscar(String nombre,NodoAvl nodo){
        if(nodo == null){
            return null;
        }
        else if(nodo.getNombre().compareTo(nombre) == 0){
            return nodo;
        }
        else if(nodo.getNombre().compareTo(nombre) < 0){
            return Buscar(nombre, nodo.derecho);
        }
        else{
            return Buscar(nombre, nodo.getIzquierdo());
        }   
        
    }
    
    public void CodigoInterno(NodoAvl raiz,PrintWriter file,String user){
        if (raiz != null){
            CodigoInterno(raiz.getIzquierdo(), file,user);
            Fe=Altura(raiz.getIzquierdo())-Altura(raiz.getIzquierdo());
            file.write(raiz.getNombre()+"[label=\"<C0>|Nombre: "+raiz.getNombre()+"&#92;n Contenido: "+raiz.getContenido()+"&#92;n Extension: "+raiz.getExtension()+"&#92;n FE: " +Fe+ "&#92;n Altura: "+raiz.getAltura()+
                                       "&#92;n TimeStamp: "+ raiz.getTimestamp()+"&#92;n Propietario: "+user+"|<C1>\"];\n");
            if (raiz.getDerecho() != null){
                file.write(raiz.getNombre() + "->" + raiz.getDerecho().getNombre()+"\n");
            }
            if (raiz.getIzquierdo() != null){
                file.write(raiz.getNombre() + "->" + raiz.getIzquierdo().getNombre()+"\n");
            }
            
            CodigoInterno(raiz.getDerecho(), file,user);
        }
        
    }
    
    public void GraficarAVL(String user){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Avl.dot");
            pw = new PrintWriter(fw);
            pw.println("digraph ArbolAVl{rankdir=TB;\n");
            pw.println("graph [splines=compound, nodesep=0.5];\n");
            pw.println("node [shape=record, style=filled,fillcolor=seashell2,width=0.7,height=0.2];\n");
            CodigoInterno(raiz, pw,user);
            pw.println("}\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fw) {
                    fw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("Error en generar grafo de Usuarios");
            }
        }

        try {
            String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath =  "Avl.dot";
            String fileOutPath = "Avl.png";

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

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al generar la imagen de Usuarios");
        }
    }
    
    public void inorder(NodoAvl r){
        if(r != null){
            inorder(r.getIzquierdo());
            System.out.print(r.getNombre()+", ");
            inorder(r.getDerecho());
        }
    }
}
