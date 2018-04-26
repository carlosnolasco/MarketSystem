/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hugo
 */
public class categorias extends javax.swing.JFrame {
 private final CRUD crud = new CRUD();
    private DefaultTableModel model;
    private int idActual = 0;
    public categorias() {
        initComponents();
        this.inicioTabla();
        this.TabCategoria.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                int x1 =TabCategoria.getSelectedRow();
                if(model.getRowCount() > 0 && TabCategoria.getSelectedRow() >= 0){
                    LlenadoCampos(TabCategoria.getSelectedRow());
                }
            }
        });
        if(this.model.getRowCount() > 0){
            this.TabCategoria.setRowSelectionInterval(0, 0);
        }
    }
private void inicioTabla(){
        this.model = (DefaultTableModel)(this.TabCategoria.getModel());
        this.TabCategoria.setModel(this.model);
      
       
      
        this.LlenarTabla();
    }
    private void LlenarTabla(){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerCategorias();
            while(rs.next()){
                Object row [] = new Object[2];
                for (int i = 0; i < 2; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void LlenarTabla(String param){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerCategoriaP(param);
            while(rs.next()){
                Object row [] = new Object[2];
                for (int i = 0; i < 2; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void LlenarTabla(int id){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerCategoriaId( id);
            while(rs.next()){
                Object row [] = new Object[2];
                for (int i = 0; i < 2; i++) {
                    row[i] = rs.getObject(i+1);
                }
                //Agregamos cada registro al modelo de la tabla
                model.addRow(row);
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarTabla(){
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i-=1;
        }
    }
     private void createNew(){
        this.limpiarTabla();
        this.idActual = 0;
        this.nombreCategoria.setText("");
    }
    private void LlenadoCampos(int row){
        if(this.model.getRowCount() > 0){
            this.nombreCategoria.setText(this.model.getValueAt(row, 1).toString());
            
            idActual = Integer.parseInt(model.getValueAt(row, 0).toString());
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabCategoria = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreCategoria = new javax.swing.JTextField();
        Nuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        AgregarCategoria = new javax.swing.JButton();
        ModificarCategoria = new javax.swing.JButton();
        EliminarCategoria = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", " Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabCategoria);
        if (TabCategoria.getColumnModel().getColumnCount() > 0) {
            TabCategoria.getColumnModel().getColumn(0).setMinWidth(0);
            TabCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabCategoria.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        jLabel1.setText("Nombre categoría");

        Nuevo.setText("Nueva categoría");
        Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoMouseClicked(evt);
            }
        });
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nombreCategoria)
                .addGap(18, 18, 18)
                .addComponent(Nuevo)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo)
                    .addComponent(jLabel1))
                .addGap(50, 50, 50))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        AgregarCategoria.setText("Agregar categoría");
        AgregarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarCategoriaMouseClicked(evt);
            }
        });
        AgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCategoriaActionPerformed(evt);
            }
        });

        ModificarCategoria.setText("Modificar categoría");
        ModificarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarCategoriaMouseClicked(evt);
            }
        });

        EliminarCategoria.setText("Eliminar categoría");
        EliminarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarCategoriaMouseClicked(evt);
            }
        });
        EliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(AgregarCategoria)
                .addGap(28, 28, 28)
                .addComponent(ModificarCategoria)
                .addGap(18, 18, 18)
                .addComponent(EliminarCategoria)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(AgregarCategoria)
                .addComponent(ModificarCategoria)
                .addComponent(EliminarCategoria))
        );

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarCategoriaMouseClicked
        String NombreC;
       NombreC = this.nombreCategoria.getText();
      
       
        Boolean res = false;
        if( NombreC.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del Producto\nCódigo de barras\nPrecio de Compra\nPrecio de Venta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        
            ResultSet rs = (crud.insertarCategoria(NombreC));
            try {
                if(rs.next()){
                    res = true;
                    this.idActual = (int)(rs.getLong(1));
                    
                this.LlenarTabla();
                }
            } catch (SQLException ex) {
                return;
            }
    }//GEN-LAST:event_AgregarCategoriaMouseClicked

    private void ModificarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarCategoriaMouseClicked
                  String NombreC;
       NombreC = this.nombreCategoria.getText();
    
        
        
        if( NombreC.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del Producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }    
        
        Boolean res = false;
        
        res = (crud.actualizarCategoria(this.idActual,NombreC));
        
        if(res){
            JOptionPane.showMessageDialog(this, "Cambios guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla(this.idActual);
            this.TabCategoria.setRowSelectionInterval(0, 0);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudieron guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ModificarCategoriaMouseClicked

    private void AgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarCategoriaActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoActionPerformed

    private void NuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoMouseClicked
       this.createNew();
    }//GEN-LAST:event_NuevoMouseClicked

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
       Productos ventana=new Productos();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_RegresarActionPerformed

    private void EliminarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarCategoriaMouseClicked
        int id = Integer.parseInt(String.valueOf(TabCategoria.getValueAt(TabCategoria.getSelectedRow(),0)));
        int confirmacion = JOptionPane.showConfirmDialog(this,"¿Está seguro en borrar el producto?", "Error",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
        if(crud.eliminarCategoria(id)){
        this.LlenarTabla();
        System.out.println("Borradoo");
        }else{
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
       
    }//GEN-LAST:event_EliminarCategoriaMouseClicked

    private void EliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCategoria;
    private javax.swing.JButton EliminarCategoria;
    private javax.swing.JButton ModificarCategoria;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Regresar;
    private javax.swing.JTable TabCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreCategoria;
    // End of variables declaration//GEN-END:variables
}
