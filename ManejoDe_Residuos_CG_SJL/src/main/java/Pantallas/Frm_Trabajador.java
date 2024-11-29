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
public class Frm_Trabajador extends javax.swing.JFrame {

    public Frm_Trabajador() {
        initComponents();
    }
    Trabajador_Model model = new Trabajador_Model();
    Trabajador obj = new Trabajador();
    Boolean modifica = false;
    void Carga_Objeto(){
        obj = new Trabajador();
        obj.setCodTrabajador(txt_CodTrabajador.getText());
        obj.setNombre(txt_Nombre.getText());
        obj.setApellido(txt_Apellido.getText());
        obj.setDni(txt_Dni.getText());
        obj.setSueldo(Float.parseFloat(txt_Sueldo.getText()));
        //obj.setSupervisor();
    }
    void Busca_Codigo(String cod){
        obj = model.Buscar(cod);
        if (obj.getCodTrabajador()!= ""){
            txt_Nombre.setText(obj.getNombre());
            txt_Apellido.setText(obj.getApellido());
            txt_Dni.setText(obj.getDni());
            txt_Sueldo.setText(obj.getSueldo().toString());
            cmb_Supervisor.setSelectedItem(obj.getSupervisor().getCodTrabajador());
            modifica = true;
        }
        else{
            modifica = false;
        }
    }
    void Limpia(){
        txt_CodTrabajador.setText("");
        txt_Nombre.setText("");
        txt_Apellido.setText("");
        txt_Dni.setText("");
        txt_Sueldo.setText("");
        cmb_Supervisor.setSelectedIndex(-1);
    }
    void Carga_Listado(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbl_detalle.getModel();
        modeloTabla.setRowCount(0);
        
        int[] ancho = {5,10,90,15,20,25};
        for(int i = 0; i < tbl_detalle.getColumnCount(); i++)
        {
            tbl_detalle.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }
        Vector<Trabajador> lista = model.Cargar();
            
        for(int i = 0; i < lista.size(); i++)
        {
            Object[] fila = {
                lista.get(i).getCodTrabajador(),
                lista.get(i).getNombre(), 
                lista.get(i).getApellido(),
                lista.get(i).getDni(),
                lista.get(i).getSueldo().toString(),
                lista.get(i).getSupervisor().getNombre()
            };
            modeloTabla.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_CodTrabajador = new javax.swing.JTextField();
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        cmb_Supervisor = new javax.swing.JComboBox();
        txt_Dni = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Sueldo = new javax.swing.JTextField();
        btn_grabar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        data = new javax.swing.JScrollPane();
        tbl_detalle = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_CodTrabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodTrabajadorKeyPressed(evt);
            }
        });

        jLabel8.setText("Supervisor");

        btn_grabar.setText("Grabar");
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido");

        jLabel4.setText("DNI");

        jLabel1.setText("Código");

        jLabel5.setText("Sueldo");

        tbl_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "DNI", "Sueldo", "Supervisor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        data.setViewportView(tbl_detalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Nombre)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_grabar)
                            .addComponent(btn_eliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmb_Supervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CodTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txt_Sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Supervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CodTrabajadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodTrabajadorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Busca_Codigo(txt_CodTrabajador.getText());
        }
    }//GEN-LAST:event_txt_CodTrabajadorKeyPressed

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
                model.Eliminar(txt_CodTrabajador.getText());
                Limpia();
                Carga_Listado();
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Trabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Trabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grabar;
    private javax.swing.JComboBox cmb_Supervisor;
    private javax.swing.JScrollPane data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_CodTrabajador;
    private javax.swing.JTextField txt_Dni;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Sueldo;
    // End of variables declaration//GEN-END:variables
}
