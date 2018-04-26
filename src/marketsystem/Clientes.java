package marketsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hugo
 */
public class Clientes extends javax.swing.JFrame {
private final CRUD crud = new CRUD();
    private DefaultTableModel model;
    private int idActual = 0;
    public Clientes() {
        initComponents();
        this.inicioTabla();
        this.TabClientes.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if (!lse.getValueIsAdjusting()) {
                int x1 =TabClientes.getSelectedRow();
                if(model.getRowCount() > 0 && TabClientes.getSelectedRow() >= 0){
                    LlenadoCampos(TabClientes.getSelectedRow());
                }
            }
        });
        if(this.model.getRowCount() > 0){
            this.TabClientes.setRowSelectionInterval(0, 0);
        }
    
    }
    private void inicioTabla(){
        this.model = (DefaultTableModel)(this.TabClientes.getModel());
        this.TabClientes.setModel(this.model);
        
      
        this.LlenarTabla();
    }
    private void LlenarTabla(){
        this.limpiarTabla();
        try{
            ResultSet rs = crud.obtenerClientes();
            while(rs.next()){
                Object row [] = new Object[11];
                for (int i = 0; i < 11; i++) {
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
            ResultSet rs = crud.obtenerClientesP(param);
            while(rs.next()){
                Object row [] = new Object[11];
                for (int i = 0; i < 11; i++) {
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
            ResultSet rs = crud.obtenerClientesId( id);
            while(rs.next()){
                Object row [] = new Object[11];
                for (int i = 0; i < 11; i++) {
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
        this.Nombres.setText("");
        this.PrimerA.setText("");
        this.SegundoA.setText("");
        this.Calle.setText("");
        this.Colonia.setText("");
        this.CodigoP.setText("");
        this.NumeroC.setText("");
        this.NumeroFijo.setText("");
        this.NumeroCel.setText("");
        this.Correo.setText("");
        this.Nombres.requestFocus();
    }
    private void LlenadoCampos(int row){
        if(this.model.getRowCount() > 0){
            this.Nombres.setText(this.model.getValueAt(row, 1).toString());
            this.PrimerA.setText(this.model.getValueAt(row, 2).toString());
            this.SegundoA.setText(this.model.getValueAt(row, 3).toString());
            this.Calle.setText(this.model.getValueAt(row, 4).toString());
            this.Colonia.setText(this.model.getValueAt(row,5).toString());
            this.CodigoP.setText(this.model.getValueAt(row,6).toString());
            this.NumeroC.setText(this.model.getValueAt(row,7).toString());
            this.NumeroFijo.setText(this.model.getValueAt(row,8).toString());
            this.NumeroCel.setText(this.model.getValueAt(row,9).toString());
            this.Correo.setText(this.model.getValueAt(row,10).toString());
            idActual = Integer.parseInt(model.getValueAt(row, 0).toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SegundoA = new javax.swing.JTextField();
        Colonia = new javax.swing.JTextField();
        Calle = new javax.swing.JTextField();
        Nombres = new javax.swing.JTextField();
        PrimerA = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        RegistrarEmpleado = new javax.swing.JButton();
        ActualizarEmpleado = new javax.swing.JButton();
        EliminarEmpleado = new javax.swing.JButton();
        RegresarEmpleados = new javax.swing.JButton();
        NuevoCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabClientes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        NumeroFijo = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        NumeroCel = new javax.swing.JTextField();
        CodigoP = new javax.swing.JTextField();
        NumeroC = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        Buscar = new javax.swing.JTextField();
        BuscarCliente = new javax.swing.JButton();

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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(SegundoA, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Calle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Colonia)
                    .addComponent(PrimerA))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrimerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SegundoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel3.setText("Segundo apellido(opcional)");

        jLabel2.setText("Primer apellido");

        jLabel5.setText("Calle");

        jLabel1.setText("Nombre(s)");

        jLabel7.setText("Colonia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel6.setText(" Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(387, 387, 387))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        RegistrarEmpleado.setText("Registrar empleado");
        RegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarEmpleadoMouseClicked(evt);
            }
        });
        RegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarEmpleadoActionPerformed(evt);
            }
        });

        ActualizarEmpleado.setText("Actualizar empleado");
        ActualizarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarEmpleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ActualizarEmpleadoMouseEntered(evt);
            }
        });

        EliminarEmpleado.setText("Eliminar empleado");
        EliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarEmpleadoMouseClicked(evt);
            }
        });

        RegresarEmpleados.setText("Regresar");
        RegresarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarEmpleadosActionPerformed(evt);
            }
        });

        NuevoCliente.setText("Nuevo Cliente");
        NuevoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegresarEmpleados)
                .addGap(87, 87, 87)
                .addComponent(NuevoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RegistrarEmpleado)
                .addGap(18, 18, 18)
                .addComponent(ActualizarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EliminarEmpleado)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistrarEmpleado)
                    .addComponent(ActualizarEmpleado)
                    .addComponent(EliminarEmpleado)
                    .addComponent(RegresarEmpleados)
                    .addComponent(NuevoCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre(s)", "Primer apellido", "Segundo apellido", "Calle", "Colonia", "CP", "NumeroCasa", "TelefonoFijo", "TelefonoCelular", "Correo"
            }
        ));
        jScrollPane2.setViewportView(TabClientes);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodigoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(NumeroFijo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NumeroCel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Correo)
                    .addComponent(NumeroC))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumeroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumeroFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumeroCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel13.setText("Teléfono fijo");

        jLabel14.setText("Número de casa");

        jLabel16.setText("Teléfono celular");

        jLabel17.setText("Código Postal");

        jLabel18.setText("Correo ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(27, 27, 27)
                .addComponent(jLabel18)
                .addGap(130, 130, 130))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        BuscarCliente.setText("Buscar Cliente");
        BuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BuscarCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarEmpleadoActionPerformed

    private void RegresarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarEmpleadosActionPerformed
  VentanaPrincipal principal=new VentanaPrincipal();
      principal.setVisible(true);
      this.setVisible(false);      
    }//GEN-LAST:event_RegresarEmpleadosActionPerformed

    private void RegistrarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarEmpleadoMouseClicked
         String nombreC,primerAC,segundoAC,calleC,coloniaC,cpC,numeroCC,telFC,telCC,correoC;
        nombreC = this.Nombres.getText();
        primerAC= this.PrimerA.getText();
        segundoAC = this.SegundoA.getText();
        calleC= this.Calle.getText();
        coloniaC=this.Colonia.getText();
        cpC=this.CodigoP.getText();
        numeroCC=this.NumeroC.getText();
        telFC=this.NumeroFijo.getText();
        telCC=this.NumeroCel.getText();
        correoC=this.Correo.getText();
        Boolean res = false;
        if( nombreC.trim().length() == 0 || 
            primerAC.trim().length() == 0 || 
            segundoAC.trim().length() == 0 || 
            calleC.trim().length() == 0 || 
            coloniaC.trim().length() == 0 ||
            cpC.trim().length() == 0 || 
            numeroCC.trim().length() == 0 ||
            telFC.trim().length() == 0 ||
            telCC.trim().length() == 0 ||
            correoC.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del Cliente\nPrimero Apellido\nCalle\nColonia\nCódigo Postal\nNúmero de casa\nTeléfono Fijo\nCorreo electrónico", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        ResultSet rs = (crud.insertarClientes(nombreC,primerAC,segundoAC,calleC,coloniaC,cpC,numeroCC,telFC,telCC,correoC));
        try {
            if(rs.next()){
                res = true;
                this.idActual = (int)(rs.getLong(1));
            }
            this.LlenarTabla();
        } catch (SQLException ex) {
        
    }                
    }//GEN-LAST:event_RegistrarEmpleadoMouseClicked

    private void NuevoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoClienteMouseClicked
       this.createNew();
    }//GEN-LAST:event_NuevoClienteMouseClicked

    private void BuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarClienteMouseClicked
      String busqueda = this.Buscar.getText();
        if(!"".equals(busqueda.trim()) && busqueda.length() > 0){
            this.LlenarTabla(busqueda);
            
        }else{
            JOptionPane.showMessageDialog(this, "No hay ningún criterio de búsqueda.\nSe mostrarán todos los registros.", "Empleados", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla();
        }
        this.Buscar.setText("");
        if(this.model.getRowCount() > 0){
            this.TabClientes.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_BuscarClienteMouseClicked

    private void EliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarEmpleadoMouseClicked
         int id = Integer.parseInt(String.valueOf(TabClientes.getValueAt(TabClientes.getSelectedRow(),0)));
        int confirmacion = JOptionPane.showConfirmDialog(this,"¿Está seguro en borrar el producto?", "Error",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
        if(crud.eliminarClientes(id)){
        this.LlenarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Error al realizar la consulta","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_EliminarEmpleadoMouseClicked

    private void ActualizarEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEmpleadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarEmpleadoMouseEntered

    private void ActualizarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEmpleadoMouseClicked
            String nombreC,primerAC,segundoAC,calleC,coloniaC,cpC,numeroCC,telFC,telCC,correoC;
        nombreC = this.Nombres.getText();
        primerAC= this.PrimerA.getText();
        segundoAC = this.SegundoA.getText();
        calleC= this.Calle.getText();
        coloniaC=this.Colonia.getText();
        cpC=this.CodigoP.getText();
        numeroCC=this.NumeroC.getText();
        telFC=this.NumeroFijo.getText();
        telCC=this.NumeroCel.getText();
        correoC=this.Correo.getText();
       
        if( nombreC.trim().length() == 0 || 
            primerAC.trim().length() == 0 || 
            segundoAC.trim().length() == 0 || 
            calleC.trim().length() == 0 || 
            coloniaC.trim().length() == 0 ||
            cpC.trim().length() == 0 || 
            numeroCC.trim().length() == 0 ||
            telFC.trim().length() == 0 ||
            telCC.trim().length() == 0 ||
            correoC.trim().length() == 0){
            JOptionPane.showMessageDialog(this, "Los siguientes campos son requeridos:\nNombre del Cliente\nPrimero Apellido\nCalle\nColonia\nCódigo Postal\nNúmero de casa\nTeléfono Fijo\nCorreo electrónico", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Boolean res = false;
        
        res = (crud.actualizarClientes(this.idActual,nombreC,primerAC,segundoAC,calleC,coloniaC,cpC,numeroCC,telFC,telCC,correoC ));
        
        if(res){
            JOptionPane.showMessageDialog(this, "Cambios guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.LlenarTabla(this.idActual);
            this.TabClientes.setRowSelectionInterval(0, 0);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudieron guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ActualizarEmpleadoMouseClicked

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarEmpleado;
    private javax.swing.JTextField Buscar;
    private javax.swing.JButton BuscarCliente;
    private javax.swing.JTextField Calle;
    private javax.swing.JTextField CodigoP;
    private javax.swing.JTextField Colonia;
    private javax.swing.JTextField Correo;
    private javax.swing.JButton EliminarEmpleado;
    private javax.swing.JTextField Nombres;
    private javax.swing.JButton NuevoCliente;
    private javax.swing.JTextField NumeroC;
    private javax.swing.JTextField NumeroCel;
    private javax.swing.JTextField NumeroFijo;
    private javax.swing.JTextField PrimerA;
    private javax.swing.JButton RegistrarEmpleado;
    private javax.swing.JButton RegresarEmpleados;
    private javax.swing.JTextField SegundoA;
    private javax.swing.JTable TabClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
