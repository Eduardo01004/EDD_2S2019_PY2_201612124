/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras.ArbolAVL;

import Estructuras.Inserts.Metodos;

/**
 *
 * @author Eduardo
 */
public class main {
    public  static void main(String[] args)  {
        ArbolAvl avl = new ArbolAvl();
        avl.InsertarAvl("Archivo", ".h", "pito", "546546");
        avl.InsertarAvl("Jojo", ".h", "pito", "546546");
        avl.InsertarAvl("Holi", ".h", "pito", "546546");
        avl.InsertarAvl("For", ".h", "pito", "546546");
        avl.InsertarAvl("Main", ".h", "pito", "546546");

        //avl.inorder(avl.raiz);
        //avl.Editar("Hola", "Zorro","sda","Sadfas","454");
        avl.Eliminar("Holi", avl.raiz);
        avl.Eliminar("Archivo", avl.raiz);
        //avl.InsertarAvl("Farmacia", ".h", "pito", "546546");
        //avl.InsertarAvl("Rodrigo", ".h", "pito", "546546");
        //avl.Eliminar("Chrome", avl.raiz);
        System.out.println("Despues de Modificar ");
        //avl.inorder(avl.raiz);
        avl.inorder(avl.raiz);
        for (int i = 0; i<Metodos.al.size();i++){
            System.out.println(Metodos.al.get(i));
        }
        //Metodos.al.clear();
        avl.GraficarAVL("NOMBRE");
        //avl.Prueba();

    }
    
}
