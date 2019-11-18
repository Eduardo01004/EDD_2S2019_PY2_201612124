/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.Matriz;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Matriz {
    public Cabecera firstColum;
    public Cabecera lastColum;
    public Cabecera firstF;
    public Cabecera LastF;

    public Matriz() {
        this.LastF=null;
        this.firstColum=null;
        this.firstF=null;
        this.lastColum=null;
    }
    public int CodigoASCIINombre(String nombre) {
        int nombretamano=nombre.length();;
        int total=0;
        for (int a=0; a<nombretamano; a++) {
            char character = nombre.charAt(a); // start on the first character
            int ascii = (int) character; //convert the first character
            total=total+ascii; 
        }
        return total;
    }
    public void existeX(String carpeta){
        boolean estado = true;
        boolean encontrado = false;
        Cabecera temp = firstColum;
        if(firstColum == null){
           Cabecera nuevo = new Cabecera();
            nuevo.setCarpeta(carpeta);
            nuevo.setPrimero(null);
            nuevo.setSiguiente(null);
            firstColum = nuevo;
            lastColum = nuevo;
        }else{
            while(estado == true){
                if(temp != null){
                    if(temp.carpeta.compareTo(carpeta) == 0){
                        estado = false;
                        encontrado = true;
                    }else{
                        temp=temp.getSiguiente();
                    }
                }else{
                    estado = false;
                    encontrado = false;
                }
            }

            if(encontrado == false){
                Cabecera nuevo = new Cabecera();
                nuevo.setCarpeta(carpeta);
                nuevo.setPrimero(null);
                if(carpeta.compareTo(firstColum.carpeta) < 0 ){
                    nuevo.setSiguiente(firstColum);
                    firstColum = nuevo;
                }else if(carpeta.compareTo(lastColum.carpeta) > 0){
                    lastColum.setSiguiente(nuevo);
                    nuevo.setSiguiente(null);
                    lastColum = nuevo;
                }else{
                    temp = firstColum;
                    estado = true;
                    while(estado){
                        if(temp.getSiguiente() != null){
                            if(carpeta.compareTo(temp.getSiguiente().getCarpeta()) < 0){
                              estado = false;
                            }else{
                                temp = temp.getSiguiente();
                            }
                        }else{
                            estado = false;
                        }
                    }
                    Cabecera aux = temp.getSiguiente();
                    temp.setSiguiente(nuevo);
                    nuevo.setSiguiente(aux);
                }


            }
        }
    }
    
    
    public void existeY(String carpeta){
        boolean estado=true;
        boolean encontrado=false;
        Cabecera temp=firstF;
        if(firstF == null){
           Cabecera nuevo=new Cabecera();
            nuevo.carpeta=carpeta;
            nuevo.primero=null;
            nuevo.siguiente=null;
            nuevo.numero=1;
            firstF=nuevo;
            LastF=nuevo;
        }else{
            while(estado==true){
                if(temp!=null){
                    if(carpeta.compareTo(temp.carpeta) == 0){
                        estado=false;
                        encontrado=true;
                    }else{
                        temp=temp.siguiente;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }
            if(encontrado==false){
                Cabecera nuevo=new Cabecera();
                nuevo.carpeta=carpeta;
                nuevo.numero=nuevo.numero+1;
                nuevo.primero=null;
                if(carpeta.compareTo(firstF.carpeta) < 0){
                    nuevo.siguiente=firstF;
                    firstF=nuevo;
                }else if(carpeta.compareTo(LastF.carpeta) > 0){
                    LastF.siguiente=nuevo;
                    nuevo.siguiente=null;
                    LastF=nuevo;
                }else{
                    temp=firstF;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(carpeta.compareTo(temp.siguiente.carpeta) < 0){
                              estado=false;
                            }else{
                                temp=temp.siguiente;
                            }
                        }else{
                            estado=false;
                        }
                    }
                    Cabecera aux=temp.siguiente;
                    temp.siguiente=nuevo;
                    nuevo.siguiente=aux;
                }


            }
        }
    }
     public void guardarMatriz(String CarpetaA, String Carpetab){
        Cabecera auxma=firstColum;
        Cabecera aux2=firstF;
        boolean estado;
        boolean encontrado=false;
        if(auxma!=null){
            
        while(auxma.carpeta.compareTo(CarpetaA) != 0){
            auxma=auxma.siguiente;
        }
        while(aux2.carpeta.compareTo(Carpetab) != 0){
            aux2=aux2.siguiente;
        }
        
       NodoMatriz mat=new NodoMatriz(CarpetaA,Carpetab);
       NodoMatriz temp;
        
        if(auxma.primero==null){
            mat.siguiente=null;
            auxma.primero=mat;
            auxma.ultimo=mat;
        }else{
            NodoMatriz nodoma=auxma.primero;
            estado=true;
            while(estado==true){
                if(nodoma!=null){
                    if(nodoma.y.compareTo(Carpetab) == 0){
                        estado=false;
                        encontrado=true;
                    }else{
                        nodoma=nodoma.siguiente;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }
            if(encontrado==false){
                if(Carpetab.compareTo(auxma.primero.y) < 0){
                    mat.atras=null;
                    mat.siguiente=auxma.primero;
                    auxma.primero.atras=mat;
                    auxma.primero=mat;
                }else if(Carpetab.compareTo(auxma.ultimo.y) > 0){
                    mat.siguiente=null;
                    mat.atras=auxma.ultimo;
                    auxma.ultimo.siguiente=mat;
                    auxma.ultimo=mat;
                }else{
                    NodoMatriz nodoauxiliar;
                    temp=auxma.primero;
                    estado=true;
                    while(estado){
                        if(temp.siguiente!=null){
                            if(Carpetab.compareTo(temp.siguiente.y) < 0){
                              estado=false;
                            }else{
                                temp=temp.siguiente;
                            }
                        }else{
                            estado=false;
                        }
                    }
                    nodoauxiliar=temp.siguiente;
                    temp.siguiente=mat;
                    mat.siguiente=nodoauxiliar;
                }
            }
        }
        if(aux2.primero==null){
           mat.arriba=null;
           aux2.primero=mat;
           aux2.ultimo=mat;
        }else{
            NodoMatriz nodoma=aux2.primero;
            estado=true;
            encontrado=false;
            while(estado==true){
                if(nodoma!=null){
                    if(nodoma.x.compareTo(CarpetaA) == 0){
                        estado=false;
                        encontrado=true;
                    }else{
                        nodoma=nodoma.arriba;
                    }
                }else{
                    estado=false;
                    encontrado=false;
                }
            }
             if(encontrado==false){
                 if(CarpetaA.compareTo(aux2.primero.x) < 0){
                     mat.abajo=null;
                     mat.arriba=aux2.primero;
                     aux2.primero.abajo=mat;
                     aux2.primero=mat;
                 }else if(CarpetaA.compareTo(aux2.ultimo.x) > 0){
                     mat.arriba=null;
                     mat.abajo=aux2.ultimo;
                     aux2.ultimo.arriba=mat;
                     aux2.ultimo=mat;
                 }else{
                    NodoMatriz nodoauxiliar;
                     temp=aux2.primero;
                     estado=true;
                     while(estado){
                         if(temp.arriba!=null){
                             if(CarpetaA.compareTo(temp.arriba.x) < 0){
                               estado=false;
                             }else{
                                 temp=temp.arriba;
                             }
                         }else{
                             estado=false;
                         }
                     }
                     nodoauxiliar=temp.arriba;
                     temp.arriba=mat;
                     mat.arriba=nodoauxiliar;
                 }

             }

        }
        }
        }
   public void Insertar(String a,String b){
       existeX(a);
       existeY(b);
       guardarMatriz(a, b);
       
   }
   public NodoMatriz BuscarC(String x){
      Cabecera aux=firstF;
       boolean encontrado=false;
       while(aux != null){
           if(aux.carpeta.compareTo(x) == 0 ){
              encontrado=true;
              break;  
            }
           aux=aux.siguiente;
        }
        if(encontrado){
            NodoMatriz nodo=aux.primero;
            while(nodo != null){
                if(nodo.y.compareTo(x) == 0){
                    return nodo;
                }
                nodo=nodo.arriba;
            }
        }
        return null;
       
   }
   
   public NodoMatriz Buscar(String x, String y){
       Cabecera aux=firstF;
       boolean encontrado=false;
       while(aux != null){
           if(aux.carpeta.compareTo(x) == 0 ){
              encontrado=true;
              break;  
            }
           aux=aux.siguiente;
        }
        if(encontrado){
            NodoMatriz nodo=aux.primero;
            while(nodo != null){
                if(nodo.x.compareTo(y) == 0){
                    return nodo;
                }
                nodo=nodo.arriba;
            }
        }
        return null;
   }
   public Cabecera BuscarColumna(String x){
       Cabecera aux =firstColum;
       while(aux != null){
           if (aux.getCarpeta().compareTo(x) == 0){
               return aux;
           }
           aux = aux.getSiguiente();
       }
       return null;
       
   }
   
   public Cabecera BuscarFila(String y){
       Cabecera aux =firstF;
       if (aux != null){
           while(aux != null){
                if (aux.getCarpeta().compareTo(y) == 0){
                    return aux;
                }
           aux = aux.getSiguiente();
           }
       }
       
       return null;
       
   }
   
   public NodoMatriz BuscarNodos(String y){
       Cabecera aux = firstF;
       NodoMatriz temp = aux.primero;
       if(temp != null){
           while (temp != null){
               if(temp.getY().compareTo(y) == 0){
                   return temp;
               }
               temp = temp.arriba;
           }
       }
       
       return null;
   }
   public void Modificar(String x,String y,String name){

           Cabecera aux2 = BuscarColumna(x);
           if(aux2 != null){
               NodoMatriz temp = Buscar(x,y);
               if(temp != null){
                   aux2.setCarpeta(name);
                   temp.setY(name);
               }
               else{
                   JOptionPane.showMessageDialog(null, "No se puede encontrar la ruta");
               }
           }
            
       
       
   }
   
   public void Grafo(){
       FileWriter fichero = null;
       PrintWriter pw = null;
       try{
           fichero = new FileWriter("Grafo.dot");
           pw = new PrintWriter(fichero);
           pw.println("digraph G{rankdir=LR;");
           pw.println(" graph [splines=ortho, nodesep=0.5];");
           pw.println("node [shape=ellipse, style=filled]");
           Cabecera aux=firstF;
           while(aux != null){
               NodoMatriz nodo=aux.primero;
               while (nodo != null){
                   //System.out.println("la carpeta tiene: "+aux.carpeta+" con  el archivo/carpeta "+nodo.x+" Y los archivos " +no);
                   if(aux.carpeta.compareTo("/") == 0 && nodo.x.compareTo("/") == 0){
                       pw.println("\""+aux.carpeta+  "\" -> \"" +nodo.x+"\"[style=invis]");
                   }else{
                       pw.println("\""+aux.carpeta+  "\" -> \"" +nodo.x+"\"");
                   }
                   nodo=nodo.arriba;
                }
                aux=aux.siguiente;
            }
           pw.println("}");
           fichero.close();
           String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
           String fileInputPath = "Grafo.dot";
           String fileOutPath = "Grafo.png";
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
       }
       catch (Exception e) {
            e.printStackTrace();
        } 
   }
   public void Graficar(){
       FileWriter fichero = null;
       PrintWriter pw = null;
       try{
           fichero = new FileWriter("Matriz.dot");
           pw = new PrintWriter(fichero);
           Cabecera aux2=firstColum;
           Cabecera aux=firstF;
           pw.println("digraph G{");
           pw.println("node [shape = box]");
           pw.println("raiz[label=\"Matriz\"  group=1];");
           if (aux != null){
               while(aux != null){
                   pw.println(aux.hashCode()+" [label=\""+aux.carpeta+"\" group = 1];");
                   aux=aux.siguiente;
               }
               aux=firstF;
               while(aux != null){
                   if(aux.siguiente != null){
                       pw.println(aux.hashCode()+"->"+aux.siguiente.hashCode()+"[dir=normal];");
                   }
                   aux=aux.siguiente;
               }
               
               while(aux2 != null){
                   int level = CodigoASCIINombre(aux2.carpeta)+2;
                   pw.println(aux2.hashCode()+" [label=\""+aux2.carpeta+"\" group = " +level+"];");
                   aux2=aux2.siguiente;
               }
               aux2=firstColum;
               while(aux2 != null){
                   if(aux2.siguiente != null){
                       pw.println(aux2.hashCode()+"->"+aux2.siguiente.hashCode()+"[dir=normal];");
                   }
                   aux2=aux2.siguiente;
               }              
               aux=firstF;
               aux2=firstColum;
               pw.println("raiz ->"+aux.hashCode());
               pw.println("raiz ->"+aux2.hashCode());
               pw.println("{ rank  = same; raiz ");
               while(aux2 != null){
                   pw.println(aux2.hashCode()+";");
                   aux2=aux2.siguiente;
               }
               pw.println("}");
               aux2=firstColum;
               while(aux2 != null){
                   int level=CodigoASCIINombre(aux2.carpeta)+2;
                   NodoMatriz temp=aux2.primero;
                   if(temp != null){
                       while(temp != null){
                           if (temp.x.compareTo("/") == 0 && temp.y.compareTo("/") == 0){
                               pw.print(temp.hashCode()+" [style=invis,fillcolor=seashell2,label= \""+temp.y+"/"+temp.x+"\" group = "+level+" ];");
                               
                           }else{
                               pw.println(temp.hashCode()+" [style=filled,fillcolor=seashell2,label= \""+temp.y+"/"+temp.x+"\" group = "+level+" ];");
                           }
                           
                           temp=temp.siguiente;
                       }
                   }
                   aux2=aux2.siguiente;
               }
               aux=firstF;
               while(aux != null){
                   NodoMatriz temp=aux.primero;
                   if(temp != null){
                       if(temp.x.compareTo("/") == 0 && temp.y.compareTo("/")==0){
                            pw.println(aux.hashCode()+"->"+temp.hashCode()+"[style= invis];");
                       }
                       else{
                            pw.println(aux.hashCode()+"->"+temp.hashCode()+"[dir=both];");
                       }
                       while(temp.arriba != null){
                           if (temp.x.compareTo("/")==0 && temp.y.compareTo("/")==0){
                               //pw.println(temp.hashCode()+"->"+temp.arriba.hashCode());
                           }else{
                           pw.println(temp.hashCode()+"->"+temp.arriba.hashCode()+"[dir=both];");
                           }
                           temp=temp.arriba;
                       }
                       pw.println("{ rank = same; "+aux.hashCode()+";");
                       temp=aux.primero;
                       while(temp != null){
                           pw.println(temp.hashCode()+";");
                           temp=temp.arriba;
                       }
                       pw.println("}");
                       
                   }
                   aux=aux.siguiente;
               }
               aux2=firstColum;
               while(aux2 != null){
                   NodoMatriz temp = aux2.primero;
                   if(temp != null){
                       if(temp.x.compareTo("/") == 0 && temp.y.compareTo("/")==0){
                            pw.println(aux2.hashCode()+"->"+temp.hashCode()+"[style= invis];");
                       }
                       else{
                            pw.println(aux2.hashCode()+"->"+temp.hashCode()+"[dir=both];");
                       }
                      
                       while(temp.siguiente != null){
                           pw.println(temp.hashCode()+"->"+temp.siguiente.hashCode()+"[dir=both];");
                           temp=temp.siguiente;
                       }
                   }
                   aux2=aux2.siguiente;
               }
               
               
           }
           pw.println("}");
           fichero.close();
           String doPath="C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
           String fileInputPath = "Matriz.dot";
           String fileOutPath = "Matriz.png";
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
           
       }catch(Exception e){}
   }
    
    
    
}
