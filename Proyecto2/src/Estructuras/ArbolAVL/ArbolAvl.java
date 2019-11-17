/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.ArbolAVL;

import Estructuras.Inserts.Metodos;
import Estructuras.Matriz.NodoMatriz;
import Estructuras.TablaHash.NodoHash;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

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
        raiz = null;
    }
    /**
     * 
     * @param t
     * @return 
     */
    private int Altura(NodoAvl t){
        if(t == null){
            return -1;
        }
        
        return t.getAltura();
    }
    
    private int Max(int a, int b){
        return (a > b) ? a : b;
    }
    
    public NodoAvl RotarIzq(NodoAvl nodo){
        NodoAvl avlnodo=nodo.getDerecho();
        NodoAvl x=avlnodo.getIzquierdo();
        avlnodo.setIzquierdo(nodo);
        nodo.setDerecho(x);
        
        nodo.setAltura(Max(Altura(nodo.getIzquierdo()), Altura(nodo.getDerecho()))+1);
        avlnodo.setAltura(Max(Altura(avlnodo.getIzquierdo()),Altura(avlnodo.getDerecho()))+1);
        
        if (avlnodo.getIzquierdo() == raiz) {
            raiz = avlnodo;
        }
        return avlnodo;
    }
    
    public NodoAvl RotarDer(NodoAvl nodo){
        NodoAvl avlnode = nodo.getIzquierdo();
        NodoAvl y = avlnode.getDerecho();
        
        avlnode.setDerecho(nodo);
        nodo.setIzquierdo(y);
        
        nodo.setAltura(Max(Altura(nodo.getIzquierdo()), Altura(nodo.getDerecho())) + 1);
        avlnode.setAltura(Max(Altura(avlnode.getDerecho()), Altura(avlnode.getDerecho())) + 1);
        if (avlnode.getDerecho() == raiz) {
            raiz = avlnode;
        }
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
    		return Altura(t.getIzquierdo()) - Altura(t.getDerecho());
    	}
    }
        
    public NodoAvl Insertar(NodoAvl nodo,String nombre,String ext,String cont,String time){
        if (nodo == null) {
            return (new NodoAvl(nombre, ext, cont,time));
        }

        if (nombre.compareTo(nodo.getNombre()) < 0) {
            nodo.setIzquierdo(Insertar(nodo.getIzquierdo(), nombre, ext, cont,time));
        } else if (nombre.compareTo(nodo.getNombre()) > 0) {
            nodo.setDerecho(Insertar(nodo.getDerecho(), nombre, ext, cont,time));
        } else {
            return nodo;
        }

        nodo.setAltura(1 + Max(Altura(nodo.getIzquierdo()), Altura(nodo.getDerecho())));
        int balance = getFactorEquilibrio(nodo);

        // Balanceo Izquierda-Izquierda
        if (balance > 1 && nombre.compareTo(nodo.getIzquierdo().getNombre()) < 0) {
            return RotarDer(nodo);
        }

        // Balanceo Derecha-Derecha
        else if (balance < -1 && nombre.compareTo(nodo.getDerecho().getNombre()) > 0) {
            return RotarIzq(nodo);
        }

        // Balanceo Izquierda-Derecha
        else if (balance > 1 && nombre.compareTo(nodo.getIzquierdo().getNombre()) > 0) {
            nodo.setIzquierdo(RotarIzq(nodo.getIzquierdo()));
            return RotarDer(nodo);
        }

        // Balanceo Derecha-Izquierda
        else if (balance < -1 && nombre.compareTo(nodo.getDerecho().getNombre()) < 0) {
            nodo.setDerecho(RotarDer(nodo.getDerecho()));
            return RotarIzq(nodo);
        }

        return nodo;
        
    }
    
    public void InsertarAvl(String nombre, String extension,String contenido,String time){
        raiz=Insertar(raiz, nombre, extension, contenido, time);
    }
    
    public NodoAvl Buscar(String nombre,NodoAvl nodo){
        if(nodo == null){
            return null;
        }
        else if(nodo.getNombre().compareTo(nombre) == 0){
            return nodo;
        }
        else if(nodo.getNombre().compareTo(nombre) < 0){
            return Buscar(nombre, nodo.getDerecho());
        }
        else{
            return Buscar(nombre, nodo.getIzquierdo());
        }   
        
    }
    public void Editar(String nombre,String new_name,String ext,String contenido, String time){
        Modificar(raiz, nombre, new_name, ext,contenido,time);
        
    }
    public void Modificar(NodoAvl nodo, String nombre,String nuevo_nombre,String new_extension,String new_contenido,String time){
        NodoAvl aux = Buscar(nombre, nodo);
        NodoAvl temp=null;
        if (aux != null){
            Eliminar(nombre, nodo);
            InsertarAvl(nuevo_nombre, new_extension, new_contenido, time);
            //temp.setNombre(nuevo_nombre);
            //temp.setExtension(new_extension);
            //temp.setContenido(new_contenido);
            //temp.setTimestamp(time);
            
        }
        
    }
    public void Modificar2(NodoAvl nodo,String nombre,String extension, String contenido,String time){
        NodoAvl aux = Buscar(nombre, nodo);
        NodoAvl temp=aux;
        if (temp != null){
            
            temp.setNombre(nombre);
            temp.setExtension(extension);
            temp.setContenido(contenido);
            temp.setTimestamp(time);
            
        }
        
    }
    private NodoAvl sucesor(NodoAvl t) {
    	NodoAvl aux = t;
    	while(aux.getIzquierdo()!= null) {
    		aux = aux.getIzquierdo();
    	}
    	return aux;
    }
    private NodoAvl eliminar(String codigo, NodoAvl t) {
    	if(t == null) {
            return t;
    	}
    	if(codigo.compareTo(t.getNombre()) < 0) {
    		t.setIzquierdo(eliminar(codigo, t.getIzquierdo()));
    	} else if(codigo.compareTo(t.getNombre()) > 0) {
    		t.setDerecho(eliminar(codigo, t.getDerecho()));
    	}else {
            if((t.getIzquierdo() == null) || (t.getDerecho()== null)) {
                NodoAvl temp = null;
                if(temp == t.getIzquierdo()) {
                    temp = t.getDerecho();
                }else {
                    temp = t.getIzquierdo();
                }
                if(temp == null) {
                    temp = t;
                    t = null;
                }else {
                    t = temp;
                }
            }else {
                NodoAvl temp = nodoValorMaximo(t.getIzquierdo());
                NodoAvl aux = t.getIzquierdo();
                actualizarNodo(raiz, temp);
                //t.setDerecho(eliminar(temp.getNombre(), t.getDerecho()));
                if(t.getIzquierdo() == temp){
                    raiz.setIzquierdo(null);
                }
                
            }
    	}
    	
    	if(t == null) {
            return t;
    	}
    	
    	t.setAltura(Max(Altura(t.getIzquierdo()), Altura(t.getDerecho())) +1  );
    	int balance = getFactorEquilibrio(t);
    	
    	if(balance > 1 && getFactorEquilibrio(t.getIzquierdo()) >= 0) {
            return RotarDer(t);
    	}
        else if(balance > 1 && getFactorEquilibrio(t.getIzquierdo()) < 0) {
            t.setIzquierdo(RotarIzq(t.getIzquierdo()));
            return RotarDer(t);
    	}
        else if(balance < -1 && getFactorEquilibrio(t.getDerecho()) <= 0) {
            return RotarIzq(t);
    	}
        else if(balance < -1 && getFactorEquilibrio(t.getDerecho()) > 0) {
            t.setDerecho(RotarDer(t.getDerecho()));
            return RotarIzq(t);
    	}
    	return t;
    
    }
    private NodoAvl nodoValorMaximo(NodoAvl node) {
        NodoAvl actual = node;
        NodoAvl temporal = node;
        while (actual.getDerecho() != null) {
            temporal = actual;
            actual = actual.getDerecho();
        }
        temporal.setDerecho(null);

        return actual;
    }
    
    public void Eliminar(String name, NodoAvl nodo){
        raiz=eliminar(name, nodo);
        
    }
    private void actualizarNodo(NodoAvl raiz, NodoAvl temp) {
        raiz.setNombre(temp.getNombre());
        raiz.setExtension(temp.getExtension());
        raiz.setContenido(temp.getContenido());
        raiz.setTimestamp(temp.getTimestamp());
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
            System.out.println("Error al generar la imagen de Archivos");
        }
    }
    public void inorder(NodoAvl r){
        if(r != null){
            inorder(r.getIzquierdo());
            //System.out.print(r.getNombre()+", ");
            Metodos.al.add(r.getNombre());
            inorder(r.getDerecho());
        }
       
    }
    public void Prueba(NodoHash hash, NodoMatriz mat,String x, String y){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("Imagen.dot");
            pw = new PrintWriter(fw);
            pw.println("digraph  imagen {\n node [shape=plaintext];\n");
            mat=hash.matriz.BuscarC(y);
            pw.println("NO_HAY_CARPETAS[label=<<TABLE BORDER=\"0\">\n<TR>");
            
            if (mat != null ){
                while(mat != null){
                    pw.println(" <TD WIDTH=\"30\" HEIGHT=\"30\" BORDER=\"0\"><IMG SRC=\"imagenes/carpeta.png\"/></TD>");
                    mat=mat.arriba;
                }
            }else{
                }
                pw.println("</TR>");
                pw.println("<TR>");
                NodoMatriz mat2=hash.matriz.BuscarC(y);
                if (mat2 != null){
                    while(mat2 != null){
                        pw.println("<TD WIDTH=\"30\" HEIGHT=\"30\" BORDER=\"0\" >"+ mat2.x +"</TD>");
                        mat2=mat2.arriba;
                    }
                }
            
            pw.println("</TR></TABLE>>];");
            pw.println("struct2[label=<<TABLE BORDER=\"0\"><TR>");
            
            if (Metodos.al.size() > 0){
                for(int i=0; i<Metodos.al.size(); i++){
                    pw.println(" <TD WIDTH=\"30\" HEIGHT=\"30\" BORDER=\"0\" ><IMG SRC=\"imagenes/archivo.png\"/></TD>");
                }
                pw.println("</TR>");
                pw.println("<TR>");
                for(int j=0; j < Metodos.al.size(); j++){
                    pw.println("<TD WIDTH=\"30\" HEIGHT=\"30\" BORDER=\"0\">"+ Metodos.al.get(j) +"</TD>");
                }
            }
            else{
                pw.println("<TD>"+ "NO HAY ARCHIVOS" +"</TD>");
            }
            pw.println("</TR></TABLE>>];");
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
                System.out.println("Error en generar ");
            }
        }

        try {
            String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath =  "Imagen.dot";
            String fileOutPath = "ImagenDrive.png";

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
            System.out.println("Error al generar la imagen de Archivos");
        }
        
    }
}
