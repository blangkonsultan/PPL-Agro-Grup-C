/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author adheraprabu
 */
public class AwalView extends javax.swing.JFrame {

    /**
     * Creates new form AwalView
     */
    public AwalView() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public void MulaiMouseListener(MouseListener l) {
        this.Button_Mulai.addMouseListener(l);
    }

    public void TentangMouseListener(MouseListener l) {
        this.Button_Tentang.addMouseListener(l);
    }

    public void BantuanMouseListener(MouseListener l) {
        this.Button_Bantuan.addMouseListener(l);
    }

    public void KeluarMouseListener(MouseListener l) {
        this.Button_Keluar.addMouseListener(l);
    }

    public JButton getButton_Bantuan() {
        return Button_Bantuan;
    }

    public void setButton_Bantuan(JButton Button_Bantuan) {
        this.Button_Bantuan = Button_Bantuan;
    }

    public JButton getButton_Keluar() {
        return Button_Keluar;
    }

    public void setButton_Keluar(JButton Button_Keluar) {
        this.Button_Keluar = Button_Keluar;
    }

    public JButton getButton_Mulai() {
        return Button_Mulai;
    }

    public void setButton_Mulai(JButton Button_Mulai) {
        this.Button_Mulai = Button_Mulai;
    }

    public JButton getButton_Tentang() {
        return Button_Tentang;
    }

    public void setButton_Tentang(JButton Button_Tentang) {
        this.Button_Tentang = Button_Tentang;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Mulai = new javax.swing.JButton();
        Button_Keluar = new javax.swing.JButton();
        Button_Tentang = new javax.swing.JButton();
        Button_Bantuan = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_Mulai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/MULAI.png"))); // NOI18N
        Button_Mulai.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Button_Mulai.setBorderPainted(false);
        Button_Mulai.setContentAreaFilled(false);
        Button_Mulai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Mulai.setFocusable(false);
        getContentPane().add(Button_Mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        Button_Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/KELUAR.png"))); // NOI18N
        Button_Keluar.setBorderPainted(false);
        Button_Keluar.setContentAreaFilled(false);
        Button_Keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Keluar.setFocusable(false);
        getContentPane().add(Button_Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, 310, -1));

        Button_Tentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/TENTANG.png"))); // NOI18N
        Button_Tentang.setBorderPainted(false);
        Button_Tentang.setContentAreaFilled(false);
        Button_Tentang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Tentang.setFocusable(false);
        getContentPane().add(Button_Tentang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 310, -1));

        Button_Bantuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/BANTUAN.png"))); // NOI18N
        Button_Bantuan.setBorderPainted(false);
        Button_Bantuan.setContentAreaFilled(false);
        Button_Bantuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Bantuan.setFocusable(false);
        getContentPane().add(Button_Bantuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 310, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/BG.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Bantuan;
    private javax.swing.JButton Button_Keluar;
    private javax.swing.JButton Button_Mulai;
    private javax.swing.JButton Button_Tentang;
    private javax.swing.JLabel bg;
    // End of variables declaration//GEN-END:variables
}
