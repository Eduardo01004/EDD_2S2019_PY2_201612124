/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Estructuras.ArbolAVL.NodoAvl;
import Estructuras.Inserts.Insert_Hash;
import Estructuras.Inserts.Metodos;
import Estructuras.Matriz.NodoMatriz;
import Estructuras.TablaHash.NodoHash;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Edit_File extends javax.swing.JFrame {

    /**
     * Creates new form Edit_File
     */
    Insert_Hash hash;
    public Edit_File() {
        initComponents();
        Mostrar_Files();
        setLocationRelativeTo(null);
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
        CB_File = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_extension = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_contenido = new javax.swing.JTextField();
        txt_time = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar");

        jLabel1.setText("ARCHIVO");

        CB_File.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Archivos" }));
        CB_File.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_FileItemStateChanged(evt);
            }
        });
        CB_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_FileActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Extension");

        jLabel4.setText("Contenido");

        jLabel5.setText("TimeStamp");

        txt_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timeActionPerformed(evt);
            }
        });

        jButton2.setText("exit");
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(72, 72, 72)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(82, 82, 82)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(72, 72, 72)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CB_File, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_extension, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_time, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(txt_contenido)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CB_File, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_extension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_time, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NodoHash nodo=hash.tabla.extraerNodo(Metodos.getNombre_user());
        if (nodo != null){
            NodoMatriz aux=nodo.matriz.Buscar(Metodos.getCarpeta_file1(),Metodos.getCarpeta_file2());
                if(aux != null){
                    Date date = new Date();
                    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    hash.bitacora.Insertar("Fecha: "+dateFormat.format(date)," Hora: "+ hourFormat.format(date), " Modifico el Archivo " 
                            + CB_File.getSelectedItem().toString()+" a "+txt_name.getText() , " Usuario: "+ Metodos.getNombre_user());
                    hash.bitacora.Graficar();
                    
                    NodoAvl rama = aux.arbol.Buscar(CB_File.getSelectedItem().toString(), aux.arbol.raiz);
                    if (rama != null){
                        aux.arbol.Editar(CB_File.getSelectedItem().toString(), txt_name.getText(), txt_extension.getText(), txt_contenido.getText(), txt_time.getText());
                        aux.arbol.GraficarAVL(Metodos.getNombre_user());
                        JOptionPane.showMessageDialog(null, "Arcbivo Modificado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre!!");
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(null, "No se encuentra la direccion");
                }
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CB_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_FileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_FileActionPerformed

    private void CB_FileItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_FileItemStateChanged
        NodoHash nodo=hash.tabla.extraerNodo(Metodos.getNombre_user());
        if (nodo != null){
            NodoMatriz aux=nodo.matriz.Buscar(Metodos.getCarpeta_file1(),Metodos.getCarpeta_file2());
                if(aux != null){
                    NodoAvl temp = aux.arbol.Buscar(CB_File.getSelectedItem().toString(), aux.arbol.raiz);
                    if (temp != null){
                        txt_name.setText(temp.getNombre());
                        txt_extension.setText(temp.getExtension());
                        txt_contenido.setText(temp.getContenido());
                        txt_time.setText(temp.getTimestamp());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encuentra el archivo");
                    }
                       
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra la direccion");
                }
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentra el usuario");
        }
    }//GEN-LAST:event_CB_FileItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //CB_File.removeAllItems();
        Manejo_Archivos manejo = new Manejo_Archivos();
        manejo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void Mostrar_Files(){
        NodoHash nodo=hash.tabla.extraerNodo(Metodos.getNombre_user());
        if (nodo != null){
            NodoMatriz aux=nodo.matriz.Buscar(Metodos.getCarpeta_file1(),Metodos.getCarpeta_file2());
                if(aux != null){
                    aux.arbol.inorder(aux.arbol.raiz);
                    
                }
                for(int i = 0; i < Metodos.al.size(); i++){
                        CB_File.addItem(Metodos.al.get(i));
                        System.out.println(Metodos.al.get(i));
                    }
            
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
            java.util.logging.Logger.getLogger(Edit_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_File.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_File().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_File;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_contenido;
    private javax.swing.JTextField txt_extension;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_time;
    // End of variables declaration//GEN-END:variables
}
