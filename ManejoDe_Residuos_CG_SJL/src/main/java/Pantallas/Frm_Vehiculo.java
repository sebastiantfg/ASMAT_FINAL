package Pantallas;
import Entidades.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Vehiculo extends javax.swing.JFrame {

    public Frm_Vehiculo() {
        initComponents();
    }
    Vehiculo_Model model = new Vehiculo_Model();
    Vehiculo obj = new Vehiculo();
    Boolean modifica = false;
    void Carga_Objeto(){
        obj = new Vehiculo();
        obj.setPlaca(txt_placa.getText());
        obj.setTipo(txt_tipo.getText());
        obj.setCapacidadCarga(Float.parseFloat(txt_capacidad.getText()));
    }
    void Busca_Codigo(String cod){
        obj = model.Buscar(cod);
        if (obj.getPlaca() != ""){
            txt_tipo.setText(obj.getTipo());
            txt_capacidad.setText(obj.getCapacidadCarga().toString());
            modifica = true;
        }
        else{
            modifica = false;
        }
    }
    void Limpia(){
        txt_placa.setText("");
        txt_tipo.setText("");
        txt_capacidad.setText("");
    }
    void Carga_Listado(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbl_detalle.getModel();
        modeloTabla.setRowCount(0);
        
        int[] ancho = {5,10,90,15,20,25};
        for(int i = 0; i < tbl_detalle.getColumnCount(); i++)
        {
            tbl_detalle.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }
        Vector<Vehiculo> lista = model.Cargar();
            
        for(int i = 0; i < lista.size(); i++)
        {
            Object[] fila = {
                lista.get(i).getPlaca(), 
                lista.get(i).getTipo(),
                lista.get(i).getCapacidadCarga()};
            modeloTabla.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_tipo = new javax.swing.JTextField();
        txt_capacidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        data = new javax.swing.JScrollPane();
        tbl_detalle = new javax.swing.JTable();
        txt_placa = new javax.swing.JTextField();
        btn_grabar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Tipo");

        jLabel3.setText("Capacidad");

        jLabel1.setText("Placa");

        tbl_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Placa", "Tipo", "Capacidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        data.setViewportView(tbl_detalle);

        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaKeyPressed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_grabar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_eliminar)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btn_grabar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                model.Eliminar(txt_placa.getText());
                Limpia();
                Carga_Listado();
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Busca_Codigo(txt_placa.getText());
        }
    }//GEN-LAST:event_txt_placaKeyPressed

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
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Vehiculo().setVisible(true);
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
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField txt_capacidad;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
