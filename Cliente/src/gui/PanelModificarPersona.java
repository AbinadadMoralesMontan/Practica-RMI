/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.IPersona;
import Interfaces.IPersonaController;
import Cliente.RMI;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Abinadad
 */
public class PanelModificarPersona extends javax.swing.JPanel {

    private IPersona persona;
    private JDialog dialogParent;
    
    public PanelModificarPersona(JDialog dialogParent, IPersona persona) throws RemoteException {
        initComponents();
        this.dialogParent = dialogParent;
        this.persona = persona;
        nombreTextField.setText(persona.getNombre());
        telefonoTextField.setText(persona.getTelefono());
        emailTextField.setText(persona.getEmail());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        telefonoTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Teléfono");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email");

        nombreTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        telefonoTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        aceptarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aceptarButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(telefonoTextField)))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aceptarButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {
            String nombre = nombreTextField.getText();
            String telefono = telefonoTextField.getText();
            String email = emailTextField.getText();
            
            if(nombre.length()==0){
                JOptionPane.showMessageDialog(this, "Ingrese nombre","Validación",JOptionPane.ERROR_MESSAGE);
                nombreTextField.requestFocus();
                return;
            }else{
                persona.setNombre(nombre);
            }
            
            if(telefono.length()>0){
                persona.setTelefono(telefono);
            }else{
                persona.setTelefono(null);
            }
            
            if(email.length()==0){
                JOptionPane.showMessageDialog(this, "Ingrese email","Validación",JOptionPane.ERROR_MESSAGE);
                telefonoTextField.requestFocus();
                return;
            }else{
                persona.setEmail(email);
            }
            
            int respuesta = RMI.getIPersonaController().update(persona);
            
            if(respuesta == IPersonaController.UPDATE_EXITO){
                JOptionPane.showMessageDialog(this, "Persona modificada con éxito","Operación exitosa",JOptionPane.INFORMATION_MESSAGE);
                dialogParent.dispose();
            }else if(respuesta == IPersonaController.UPDATE_SIN_EXITO){
                JOptionPane.showMessageDialog(this, "No fue posible completar la operación","Operación no completada",JOptionPane.ERROR_MESSAGE);
                
            }else if(respuesta == IPersonaController.UPDATE_INEXISTENTE){
                JOptionPane.showMessageDialog(this, "No fue posible completar la operación\n"
                        +"Es probable que la persona haya sido eliminada\n Con aterioridad","Operación no completada",JOptionPane.ERROR_MESSAGE);
                dialogParent.dispose();
            }        
        } catch (RemoteException ex) {
            Logger.getLogger(PanelModificarPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField telefonoTextField;
    // End of variables declaration//GEN-END:variables
}
