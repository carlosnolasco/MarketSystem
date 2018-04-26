
package marketsystem;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Contraseña_cambio extends javax.swing.JFrame {
private CRUD crud;
    public Contraseña_cambio() {
        initComponents();
        try{
           crud = new CRUD(); 
        
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        PanelContraseña = new javax.swing.JPanel();
        LabelContraseña = new javax.swing.JLabel();
        LabelAnterior = new javax.swing.JLabel();
        LabelNueva = new javax.swing.JLabel();
        LabelNueva2 = new javax.swing.JLabel();
        LabelAnterior1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        txtLastP = new javax.swing.JPasswordField();
        txtNewP = new javax.swing.JPasswordField();
        txtNewP2 = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio de Contraseña");

        PanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelTitulo.setPreferredSize(new java.awt.Dimension(330, 50));

        LabelTitulo.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(51, 51, 51));
        LabelTitulo.setText("CAMBIO DE CONTRASEÑA");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(LabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTitulo)
                .addContainerGap())
        );

        PanelContraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        LabelContraseña.setText("Proporcionar la contraseña anterior, seguido con la nueva dos veces.");

        LabelAnterior.setText("Escribe la contraseña anterior: ");

        LabelNueva.setText("Escribe la contraseña nueva: ");

        LabelNueva2.setText("Escribe la contraseña de nuevo: ");

        LabelAnterior1.setText("Escribe el usuario: ");

        javax.swing.GroupLayout PanelContraseñaLayout = new javax.swing.GroupLayout(PanelContraseña);
        PanelContraseña.setLayout(PanelContraseñaLayout);
        PanelContraseñaLayout.setHorizontalGroup(
            PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContraseñaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContraseñaLayout.createSequentialGroup()
                        .addComponent(LabelNueva2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNewP2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelContraseñaLayout.createSequentialGroup()
                        .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelAnterior1)
                            .addComponent(LabelNueva)
                            .addComponent(LabelAnterior))
                        .addGap(19, 19, 19)
                        .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLastP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewP, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                    .addComponent(LabelContraseña))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelContraseñaLayout.setVerticalGroup(
            PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContraseñaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelContraseña)
                .addGap(21, 21, 21)
                .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAnterior1)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAnterior)
                    .addComponent(txtLastP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNueva)
                    .addComponent(txtNewP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNueva2)
                    .addComponent(txtNewP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        btnCambiar.setText("Cambiar");
        btnCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarMouseClicked(evt);
            }
        });

        BotonRegresar.setText("Regresar");
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(BotonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(PanelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonRegresar)
                    .addComponent(btnCambiar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void btnCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarMouseClicked
        // TODO add your handling code here:
        
        String contranueva = txtNewP.getText();
        String contraanterior = txtLastP.getText();
        String contranueva2 = txtNewP2.getText();
        String usuarios=usuario.getText();
        ResultSet pass = crud.login(usuarios, contraanterior);
        if (contranueva.trim().length() == 0 || contraanterior.trim().length() == 0 || contranueva2.trim().length() == 0 || usuarios.trim().length()==0) {
            JOptionPane.showMessageDialog(this, "Falta llenar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            if(pass.next()){
                if (contranueva.equals(contraanterior)) {
                    JOptionPane.showMessageDialog(this, "La contraseña nueva debe ser diferente a la anterior", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (contranueva.equals(contranueva2)) {
                    if (crud.changePass(contranueva, contraanterior,usuarios)) {
                        JOptionPane.showMessageDialog(this, "Contraseña cambiada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Error al cambiar contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No coinciden las contraseñas nuevas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Las credenciales no son válidas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnCambiarMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Contraseña_cambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contraseña_cambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contraseña_cambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contraseña_cambio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contraseña_cambio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LabelAnterior;
    private javax.swing.JLabel LabelAnterior1;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelNueva;
    private javax.swing.JLabel LabelNueva2;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PanelContraseña;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JPasswordField txtLastP;
    private javax.swing.JPasswordField txtNewP;
    private javax.swing.JPasswordField txtNewP2;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
