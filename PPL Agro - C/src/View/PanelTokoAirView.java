/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author adheraprabu
 */
public class PanelTokoAirView extends javax.swing.JPanel {

    /**
     * Creates new form PanelTokoView
     */
    public PanelTokoAirView() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }

    public void BeliMouseListener(MouseListener l) {
        this.Button_beli.addMouseListener(l);
    }

    public void TambahMouseListener(MouseListener l) {
        this.Button_tambah.addMouseListener(l);
    }

    public void KurangMouseListener(MouseListener l) {
        this.Button_kurang.addMouseListener(l);
    }

    public JLabel getLabel_jmlBeliAir() {
        return Label_jmlBeliAir;
    }

    public JButton getButton_beli() {
        return Button_beli;
    }

    public void setButton_beli(JButton Button_beli) {
        this.Button_beli = Button_beli;
    }

    public JButton getButton_kurang() {
        return Button_kurang;
    }

    public void setButton_kurang(JButton Button_kurang) {
        this.Button_kurang = Button_kurang;
    }

    public JButton getButton_tambah() {
        return Button_tambah;
    }

    public void setButton_tambah(JButton Button_tambah) {
        this.Button_tambah = Button_tambah;
    }

    public void setLabel_jmlBeliAir(JLabel Label_jmlBeliAir) {
        this.Label_jmlBeliAir = Label_jmlBeliAir;
    }

    public JButton getjButton1() {
        return Button_tambah;
    }

    public void setjButton1(JButton jButton1) {
        this.Button_tambah = jButton1;
    }

    public JButton getjButton2() {
        return Button_beli;
    }

    public void setjButton2(JButton jButton2) {
        this.Button_beli = jButton2;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_tambah = new javax.swing.JButton();
        Button_kurang = new javax.swing.JButton();
        Button_beli = new javax.swing.JButton();
        Label_jmlBeliAir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Toko/plus1.png"))); // NOI18N
        Button_tambah.setBorderPainted(false);
        Button_tambah.setContentAreaFilled(false);
        Button_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_tambah.setFocusable(false);
        Button_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_tambahActionPerformed(evt);
            }
        });
        add(Button_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 60, 60));

        Button_kurang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Toko/min1.png"))); // NOI18N
        Button_kurang.setBorderPainted(false);
        Button_kurang.setContentAreaFilled(false);
        Button_kurang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kurang.setFocusable(false);
        add(Button_kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 60, 60));

        Button_beli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Toko/bel_but1.png"))); // NOI18N
        Button_beli.setToolTipText("");
        Button_beli.setBorderPainted(false);
        Button_beli.setContentAreaFilled(false);
        Button_beli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_beli.setFocusable(false);
        add(Button_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 170, -1));

        Label_jmlBeliAir.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 48)); // NOI18N
        Label_jmlBeliAir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_jmlBeliAir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Label_jmlBeliAir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 150, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Toko/kotak_jml.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Toko/icon_air.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void Button_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_tambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_tambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_beli;
    private javax.swing.JButton Button_kurang;
    private javax.swing.JButton Button_tambah;
    private javax.swing.JLabel Label_jmlBeliAir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
