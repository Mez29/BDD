/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.dialog;

import com.toedter.calendar.JDateChooser;
import fes.aragon.dao.CatalogoViajeDAO;
import fes.aragon.dao.DespachoDAO;
import fes.aragon.dao.PaisDAO;
import fes.aragon.dao.ProfesorDAO;
import fes.aragon.dao.ViajeDAO;
import fes.aragon.modelo.TablaViaje;
import fes.aragon.pojo.CatalogoViaje;
import fes.aragon.pojo.Despacho;
import fes.aragon.pojo.Pais;
import fes.aragon.pojo.Profesor;
import fes.aragon.pojo.Viaje;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mez29
 */
public class CRUDPViaje extends javax.swing.JDialog {
    private DefaultComboBoxModel modeloPais = new DefaultComboBoxModel();
    private DefaultComboBoxModel modeloCatalogoViaje = new DefaultComboBoxModel();
    private TablaViaje modeloTabla= new TablaViaje();

    /**
     * Creates new form CRUDProfesor
     */
    public CRUDPViaje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        IniciarComponentes();
    }
    private void IniciarComponentes(){
       try {
            PaisDAO datos = new PaisDAO();
            ArrayList<Pais> pais= new ArrayList<Pais>();
            modeloPais.addElement("Escoge un pais");
            pais=datos.buscarPais();
            for (Pais desp : pais){
                modeloPais.addElement(desp);
            }
           CatalogoViajeDAO datos2= new CatalogoViajeDAO();
           ArrayList<CatalogoViaje> viaje=new ArrayList<CatalogoViaje>();
           modeloCatalogoViaje.addElement("Escoge un motivo");
           viaje = datos2.buscarCatalogoViaje();
           for(CatalogoViaje desp:viaje){
               modeloCatalogoViaje.addElement(desp);
           }
            
            ViajeDAO tmpviaje=new ViajeDAO();
            modeloTabla.setDatos(tmpviaje.buscarViaje());
            modeloTabla.setModeloPais(modeloPais);
            modeloTabla.setModeloCatalogoViaje(modeloCatalogoViaje);
            modeloTabla.fireTableDataChanged();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        } catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(this.modeloTabla);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Fecha_In");

        jLabel2.setText("Fecha_Fin");

        jLabel3.setText("Pais");

        jLabel4.setText("Motivo");

        jComboBox1.setModel(this.modeloPais);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Almacenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(this.modeloCatalogoViaje);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(57, 57, 57)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 288, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            ViajeDAO alm=new ViajeDAO();
            Viaje tmp=this.evaluarCampos();
            if(tmp!=null){ 
            alm.insertar(tmp); 
            modeloTabla.getDatos().clear();
            alm=new ViajeDAO();
            modeloTabla.setDatos(alm.buscarViaje());
            modeloTabla.fireTableDataChanged();
            this.reiniciar();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (modeloTabla.getDatos().size()>0){
            Viaje tmp=modeloTabla.getDatos().get(this.jTable1.getSelectedRow());
            this.jDateChooser1.setDate(tmp.getFecha_Inicio());
            this.jDateChooser2.setDate(tmp.getFecha_Fin());
            for (int i = 1; i < modeloPais.getSize(); i++) {
               Pais temp=(Pais)modeloPais.getElementAt(i);
               if(tmp.getId_Pais()==temp.getId_Pais()){
                   this.jComboBox1.setSelectedIndex(i);
                   break;
               }
            }   
            for (int i = 1; i < modeloCatalogoViaje.getSize(); i++) {
               CatalogoViaje temp=(CatalogoViaje)modeloCatalogoViaje.getElementAt(i);
               if(tmp.getId_Viaje()==temp.getId_Motivo()){
                   this.jComboBox2.setSelectedIndex(i);
                   break;
               }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            ViajeDAO alm=new ViajeDAO();
            Viaje tmp=this.evaluarCampos();
            if(tmp!=null){ 
                alm.modificar(tmp);
                modeloTabla.getDatos().clear();
                alm=new ViajeDAO();
                modeloTabla.setDatos(alm.buscarViaje());
                modeloTabla.fireTableDataChanged();
                this.reiniciar();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error en la BDD");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private Viaje evaluarCampos(){
        boolean correcto =true;
        String mensajes="";
        Viaje datos=new Viaje();
        if (!correcto) {
            JOptionPane.showMessageDialog(rootPane, mensajes);
            datos=null;
        } else{
            Viaje tmp=null;
            if(this.jTable1.getSelectedRow()!=-1){
                tmp=modeloTabla.getDatos().get(this.jTable1.getSelectedRow());
            }
            if(tmp!=null){
                datos.setId_Viaje(tmp.getId_Viaje());
            }
            datos.setFecha_Inicio(new java.sql.Date(this.jDateChooser1.getDate().getTime()));
            datos.setFecha_Fin(new java.sql.Date(this.jDateChooser2.getDate().getTime()));
            datos.setId_Pais(((Pais)this.jComboBox1.getSelectedItem()).getId_Pais());
            datos.setId_Viaje(((CatalogoViaje)this.jComboBox2.getSelectedItem()).getId_Motivo());
        }
        return datos;
    }
    private void reiniciar(){
        //this.jDateChooser1=new JDateChooser();
        //this.jDateChooser2=new JDateChooser();
        this.jComboBox1.setSelectedIndex(0);
        this.jComboBox2.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(CRUDPViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDPViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDPViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDPViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CRUDPViaje dialog = new CRUDPViaje(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
