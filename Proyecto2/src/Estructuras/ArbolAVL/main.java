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
public class main {
    public  static void main(String[] args)  {
        ArbolAvl avl = new ArbolAvl();
        avl.InsertarAvl("Edua", ".h", "pito", "546546");
        avl.InsertarAvl("Copo", ".h", "pito", "546546");
        avl.InsertarAvl("Caca", ".h", "pito", "546546");
        avl.InsertarAvl("Pofo", ".h", "pito", "546546");
        avl.InsertarAvl("Aca", ".h", "pito", "546546");
        avl.InsertarAvl("Powq", ".h", "pito", "546546");
        avl.GraficarAVL();
        avl.inorder(avl.raiz);
    }
    
}
