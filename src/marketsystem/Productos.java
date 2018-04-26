package marketsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {

 private final CRUD crud = new CRUD();
    private DefaultTableModel model;
    private int idActual = 0;
    ArrayList idCategorias = new ArrayList();;
    ArrayList idDistribuidores = new ArrayList();
    public Productos() {
        initComponents();
        this.inicioTabla();
        this.TabProductos.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                int x1 =TabProductos.getSelectedRow();
                if(model.getRowCount() > 0 && TabProductos.getSelectedRow() >= 0){
                    LlenadoCampos(TabProductos.getSelectedRow());
                }
            }
        });
        if(this.model.getRowCount() > 0){
            this.TabProductos.setRowSelectionInterval(0, 0);
        }
        this.fillComboCategories();
        this.fillComboDistr();
    }
    private void inicioTabla(){
        this.model = (DefaultTableModel)(this.TabProductos.getModel());
        this.TabProductos.setModel(this.model);
        
      
        this.LlenarTabla();
    }
    private void LlenarTabla(){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerProductos();
            while(rs.next()){
                Object row [] = new Object[6];
                for (int i = 0; i < 6; i++) {
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
            ResultSet rs = crud.obtenerProductosP(param);
            while(rs.next()){
                Object row [] = new Object[6];
                for (int i = 0; i < 6; i++) {
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
            ResultSet rs = crud.obtenerProductoId( id);
            while(rs.next()){
                Object row [] = new Object[6];
                for (int i = 0; i < 6; i++) {
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
        this.txtNombre.setText("");
        this.txtBarCode.setText("");
        this.txtPrecioCompra.setText("");
        this.txtPrecioVenta.setText("");
        this.txtNombre.requestFocus();
    }
    private void LlenadoCampos(int row){
        if(this.model.getRowCount() > 0){
            this.txtNombre.setText(this.model.getValueAt(row, 1).toString());
            this.txtBarCode.setText(this.model.getValueAt(row, 2).toString());
            this.txtPrecioCompra.setText(this.model.getValueAt(row, 3).toString());
            this.txtPrecioVenta.setText(this.model.getValueAt(row, 4).toString());
            idActual = Integer.parseInt(model.getValueAt(row, 0).toString());
        }
    }
    private void fillComboCategories(){
        try{
            ResultSet rs = crud.obtenerCategorias();
            while(rs.next()){
                for(int i=0;i<1;i++){
                    this.cbxCategorias.addItem(rs.getObject(2).toString());
                    this.idCategorias.add(rs.getObject(1).toString());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void fillComboDistr(){
        try{
            ResultSet rs = crud.obtenerDistribuidores();
            while(rs.next()){
                for(int i=0;i<1;i++){
                    this.cbxDistribuidores.addItem(rs.getObject(2).toString());
                    this.idDistribuidores.add(rs.getObject(1).toString());
                }
            }
            int x = 0;
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnAddCat = new javax.swing.JButton();
        btnAddDist = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabProductos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtBarCode = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        cbxCategorias = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxDistribuidores = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        pnlImage = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel6.setText("Productos");

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(193, 193, 193)
                .addComponent(btnBack)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnBorrar.setText("Eliminar producto");
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });

        btnAddCat.setText("Añadir categorías");
        btnAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCatActionPerformed(evt);
            }
        });

        btnAddDist.setText("Añadir Distribuidores");
        btnAddDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCat)
                .addGap(18, 18, 18)
                .addComponent(btnAddDist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnBorrar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnGuardar)
                    .addComponent(btnAddCat)
                    .addComponent(btnAddDist))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        TabProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IDNombreProducto", "NombreProducto", "CodigoBarras", "PrecioCompra", "PrecioVenta", "Categoria"
            }
        ));
        jScrollPane2.setViewportView(TabProductos);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Tipo");

        jLabel5.setText("Precio de Venta");

        jLabel3.setText("Precio de Compra");

        jLabel2.setText("Código de Barras");

        jLabel1.setText("Nombre del Producto");

        txtBarCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarCodeKeyTyped(evt);
            }
        });

        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel8.setText("Distribuidor");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtBarCode)
                            .addComponent(txtPrecioCompra)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(cbxDistribuidores, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxDistribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        btnBuscar.setText("Buscar Producto");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnNew.setText("Nuevo Producto");
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNew)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNew))
                .addContainerGap())
        );

        pnlImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      VentanaPrincipal principal=new VentanaPrincipal();
      principal.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtBarCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarCodeKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBarCodeKeyTyped

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char c=evt.getKeyChar(); 
        if(!Character.isDigit(c)) { 
            evt.consume();
        }  
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        char c=evt.getKeyChar(); 
        if(!Character.isDigit(c)) { 
            evt.consume();
        } 
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        String NombreP,CodigoB,PrecioC,PrecioV;
        NombreP = this.txtNombre.getText();
        CodigoB= this.txtBarCode.getText();
        PrecioC = this.txtPrecioCompra.getText();
        PrecioV= this.txtPrecioVenta.getText();
        int categoriaId = Integer.parseInt(this.idCategorias.get(this.cbxCategorias.getSelectedIndex()).toString());
        int distId = Integer.parseInt(this.idDistribuidores.get(this.cbxDistribuidores.getSelectedIndex()).toString());
        if( NombreP.trim().length() == 0 || 
            CodigoB.trim().length() == 0 || 
            PrecioC.trim().length() == 0 || 
            PrecioV.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del Producto\nCódigo de barras\nPrecio de Compra\nPrecio de Venta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        if(idActual == 0){
            
        }else{
            
        }
        ResultSet rs = (crud.insertarProducto(NombreP,Long.parseLong(CodigoB), Float.parseFloat(PrecioC),Float.parseFloat(PrecioV),distId,categoriaId));
        try {
            if(rs.next()){
                this.idActual = (int)(rs.getLong(1));
            }
            this.LlenarTabla();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        String busqueda = this.txtBusqueda.getText();
        if(!"".equals(busqueda.trim()) && busqueda.length() > 0){
            this.LlenarTabla(busqueda);
            
        }else{
            JOptionPane.showMessageDialog(this, "No hay ningún criterio de búsqueda.\nSe mostrarán todos los registros.", "Empleados", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla();
        }
        this.txtBusqueda.setText("");
        if(this.model.getRowCount() > 0){
            this.TabProductos.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        this.createNew();
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCatActionPerformed
        categorias c=new categorias();
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddCatActionPerformed

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
          int id = Integer.parseInt(String.valueOf(TabProductos.getValueAt(TabProductos.getSelectedRow(),0)));
        int confirmacion = JOptionPane.showConfirmDialog(this,"¿Está seguro en borrar el producto?", "Error",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
        if(crud.eliminarProducto(id)){
        this.LlenarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnAddDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDistActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabProductos;
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnAddDist;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cbxCategorias;
    private javax.swing.JComboBox<String> cbxDistribuidores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
