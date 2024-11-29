package Pantallas;

import Entidades.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Frm_Usuario extends javax.swing.JFrame {
    public Frm_Usuario() {
        initComponents();
    }

    Usuario_Model model = new Usuario_Model();
    Usuario obj = new Usuario();
    Boolean modifica = false;
    void Carga_Objeto(){
        obj = new Usuario();
        obj.setCodUsuario(txt_CodUsuario.getText());
        obj.setNombre(txt_Nombre.getText());
        obj.setApellido(txt_Apellido.getText());
        obj.setDni(txt_Dni.getText());
        obj.setContraseña(txt_contraseña.getText());
        obj.setCorreo(txt_Correo.getText());
    }
    void Busca_Codigo(String cod){
        obj = model.Buscar(cod);
        if (obj.getCodUsuario()!= ""){
            txt_Nombre.setText(obj.getNombre());
            txt_Apellido.setText(obj.getApellido());
            txt_Dni.setText(obj.getDni());
            txt_contraseña.setText(obj.getContraseña());
            txt_Correo.setText(obj.getCorreo());
            modifica = true;
        }
        else{
            modifica = false;
        }
    }
    void Limpia(){
        txt_CodUsuario.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Dni.setText("");
        txt_contraseña.setText("");
        txt_Correo.setText("");
    }
    void Carga_Listado(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbl_detalle.getModel();
        modeloTabla.setRowCount(0);
        
        int[] ancho = {5,10,90,15,20,25};
        for(int i = 0; i < tbl_detalle.getColumnCount(); i++)
        {
            tbl_detalle.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }
        Vector<Usuario> lista = model.Cargar();
            
        for(int i = 0; i < lista.size(); i++)
        {
            Object[] fila = {
                lista.get(i).getCodUsuario(),
                lista.get(i).getNombre(), 
                lista.get(i).getApellido(),
                lista.get(i).getDni(),
                lista.get(i).getCorreo()
            };
            modeloTabla.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Apellido = new javax.swing.JTextField();
        txt_Dni = new javax.swing.JTextField();
        btn_grabar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        data = new javax.swing.JScrollPane();
        tbl_detalle = new javax.swing.JTable();
        txt_contraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_CodUsuario = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btn_grabar.setText("Grabar");
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("DNI");

        jLabel1.setText("Código");

        tbl_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "DNI", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        data.setViewportView(tbl_detalle);

        jLabel6.setText("Contraseña");

        txt_CodUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodUsuarioKeyPressed(evt);
            }
        });

        jLabel7.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_Nombre)
                                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_CodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_grabar)
                                    .addComponent(btn_eliminar)))
                            .addComponent(txt_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Correo))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_grabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        if (modifica){
            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea modificar?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION)
            {
                Carga_Objeto();
                model.Modificar(obj);
                Limpia();
                Carga_Listado();
            }
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea grabar?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION)
            {
                Carga_Objeto();
                model.Insertar(obj);
                Limpia();
                Carga_Listado();
            }
        }
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (modifica){
            int confirm = JOptionPane.showConfirmDialog(null, "¿Desea eliminar?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION)
            {
                Carga_Objeto();
                model.Eliminar(txt_CodUsuario.getText());
                Limpia();
                Carga_Listado();
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Carga_Listado();
    }//GEN-LAST:event_formWindowActivated

    private void txt_CodUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Busca_Codigo(txt_CodUsuario.getText());
        }
    }//GEN-LAST:event_txt_CodUsuarioKeyPressed

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
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grabar;
    private javax.swing.JScrollPane data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_CodUsuario;
    private javax.swing.JTextField txt_Correo;
    private javax.swing.JTextField txt_Dni;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_contraseña;
    // End of variables declaration//GEN-END:variables
}
