/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Estructuras.ArbolAVL.NodoAvl;
import Estructuras.Inserts.Insert_Hash;
import Estructuras.Inserts.Metodos;
import Estructuras.Matriz.Cabecera;
import Estructuras.Matriz.NodoMatriz;
import Estructuras.TablaHash.NodoHash;
import com.csvreader.CsvReader;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Crear_Archivo extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Archivo
     */
    Insert_Hash hash;
    Date date = new Date();
    public Crear_Archivo() {
        initComponents();
        setLocationRelativeTo(null);
        Mostrar_ComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CB_Carpetas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_Carga = new javax.swing.JButton();
        CB_Carpeta2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ext = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_contenido = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carga de Archivos");

        jLabel1.setText("Capeta 1");

        CB_Carpetas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carpetas" }));

        jLabel2.setText("Nombre");

        btn_Carga.setText("Carga Masiva");
        btn_Carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CargaActionPerformed(evt);
            }
        });

        CB_Carpeta2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carpetas" }));

        jLabel3.setText("Carpeta 2");

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel4.setText("Extension");

        jLabel5.setText("Contenido");

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(txt_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CB_Carpetas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_Carpeta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_ext, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Carga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CB_Carpetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(CB_Carpeta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btn_Carga)
                    .addComponent(jButton1))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CargaActionPerformed
        Carga_Archivos();
        
    }//GEN-LAST:event_btn_CargaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //CB_Carpeta2.removeAllItems();
        //CB_Carpetas.removeAllItems();
        Manejo_Archivos manejo = new Manejo_Archivos();
        manejo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        NodoHash pito=hash.tabla.extraerNodo(Metodos.getNombre_user());
        if (pito != null){
            NodoMatriz aux=pito.matriz.Buscar(CB_Carpetas.getSelectedItem().toString(),CB_Carpeta2.getSelectedItem().toString());
            if(aux != null){
                aux.arbol.InsertarAvl(txt_name.getText(),txt_ext.getName(),txt_contenido.getText(),hourdateFormat.format(date));
                aux.arbol.GraficarAVL(Metodos.getNombre_user());
                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                hash.bitacora.Insertar("Fecha: "+dateFormat.format(date)," Hora: "+ hourFormat.format(date), " Creo el Archivo " +
                    txt_name.getText(), " Usuario: "+ Metodos.getNombre_user());
                hash.bitacora.Graficar();
                JOptionPane.showMessageDialog(null, "Archivo Creado");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encuentra la direccion");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void Mostrar_ComboBox(){
        NodoHash nodo=hash.tabla.extraerNodo(Metodos.getNombre_user());
        if (nodo != null){
            Cabecera aux=nodo.matriz.firstColum;
            while(aux != null){
                CB_Carpetas.addItem(aux.carpeta);
                CB_Carpeta2.addItem(aux.carpeta);
            aux=aux.siguiente;
            }
        }
    }
    public void Carga_Archivos(){
        try{
            JFileChooser file=new JFileChooser();
            file.showOpenDialog(this);
            File abre=file.getSelectedFile();
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
            if (abre != null){
               CsvReader leerUser=new CsvReader(abre.toString());
               leerUser.readHeaders();
               while (leerUser.readRecord()){
                    NodoHash pito=hash.tabla.extraerNodo(Metodos.getNombre_user());
                    if (pito != null){
                        NodoMatriz aux=pito.matriz.Buscar(CB_Carpetas.getSelectedItem().toString(),CB_Carpeta2.getSelectedItem().toString());
                        if(aux != null){
                            NodoAvl rai = aux.arbol.Buscar(leerUser.get(0).split("\\.")[0], aux.arbol.raiz);
                            if (rai == null){
                                aux.arbol.InsertarAvl(leerUser.get(0).split("\\.")[0], leerUser.get(0).split("\\.")[1], leerUser.get(1),hourdateFormat.format(date) );
                                aux.arbol.GraficarAVL(Metodos.getNombre_user());
                                hash.bitacora.Insertar("Fecha: "+dateFormat.format(date)," Hora: "+ hourFormat.format(date), " Creo el Archivo " +
                                leerUser.get(0).split("\\.")[0], " Usuario: "+ Metodos.getNombre_user());
                                hash.bitacora.Graficar();
                            }
                            else{
                                int msj =JOptionPane.showConfirmDialog(null, "Desea Sobreescribir el Archivo ");
                                if (msj == JOptionPane.YES_OPTION){
                                    aux.arbol.Modificar2(aux.arbol.raiz, leerUser.get(0).split("\\.")[0], leerUser.get(0).split("\\.")[1], leerUser.get(1),hourdateFormat.format(date) );
                                }else{
                                    
                                }
                            }
                            
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "No se encuentra la direccion");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No se encuentra el usuario","Advertencia",JOptionPane.WARNING_MESSAGE);
                    }
                    
               }
               JOptionPane.showMessageDialog(null, "Archivos Cargados con exito");
               leerUser.close();
            }  


            }
            catch(IOException ex)
            {
              JOptionPane.showMessageDialog(null,ex+"" +
                    "\nNo se ha encontrado el archivo",
                          "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
             }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crear_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Archivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Carpeta2;
    private javax.swing.JComboBox<String> CB_Carpetas;
    private javax.swing.JButton btn_Carga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_contenido;
    private javax.swing.JTextField txt_ext;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
