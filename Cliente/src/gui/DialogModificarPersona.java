/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.IPersona;
import java.rmi.RemoteException;

/**
 *
 * @author Abinadad
 */
public class DialogModificarPersona extends javax.swing.JDialog {

    /**
     * Creates new form DialogModificarPersona
     */
    public DialogModificarPersona(java.awt.Frame parent, boolean modal, IPersona persona) throws RemoteException {
        super(parent, modal);
        initComponents();
        getContentPane().add(new PanelModificarPersona(this, persona));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
