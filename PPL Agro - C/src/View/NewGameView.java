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
public class NewGameView extends javax.swing.JFrame {

    /**
     * Creates new form NewGameView
     */
    public NewGameView() {
        initComponents();
        setLocationRelativeTo(this);
    }
    
    public void KembaliMouseListener(MouseListener l) {
        this.Button_Kembali.addMouseListener(l);
    }
    
    public void LanjutkanMouseListener(MouseListener l) {
        this.Button_Lanjutkan.addMouseListener(l);
    }
    
    public void MulaiBaruMouseListener(MouseListener l) {
        this.Button_MulaiBaru.addMouseListener(l);
    }

    public JButton getButton_Kembali() {
        return Button_Kembali;
    }

    public void setButton_Kembali(JButton Button_Kembali) {
        this.Button_Kembali = Button_Kembali;
    }

    public JButton getButton_Lanjutkan() {
        return Button_Lanjutkan;
    }

    public void setButton_Lanjutkan(JButton Button_Lanjutkan) {
        this.Button_Lanjutkan = Button_Lanjutkan;
    }

    public JButton getButton_MulaiBaru() {
        return Button_MulaiBaru;
    }

    public void setButton_MulaiBaru(JButton Button_MulaiBaru) {
        this.Button_MulaiBaru = Button_MulaiBaru;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_Lanjutkan = new javax.swing.JButton();
        Button_MulaiBaru = new javax.swing.JButton();
        Button_Kembali = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_Lanjutkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/MulaiUI/lanjut.png"))); // NOI18N
        Button_Lanjutkan.setBorderPainted(false);
        Button_Lanjutkan.setContentAreaFilled(false);
        Button_Lanjutkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_Lanjutkan.setFocusable(false);
        getContentPane().add(Button_Lanjutkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        Button_MulaiBaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/MulaiUI/mulai.png"))); // NOI18N
        Button_MulaiBaru.setBorderPainted(false);
        Button_MulaiBaru.setContentAreaFilled(false);
        Button_MulaiBaru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_MulaiBaru.setFocusable(false);
        getContentPane().add(Button_MulaiBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        Button_Kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/TentangUI/BACK.png"))); // NOI18N
        Button_Kembali.setBorderPainted(false);
        Button_Kembali.setContentAreaFilled(false);
        Button_Kembali.setFocusable(false);
        getContentPane().add(Button_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/AwalUI/BG.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Kembali;
    private javax.swing.JButton Button_Lanjutkan;
    private javax.swing.JButton Button_MulaiBaru;
    private javax.swing.JLabel bg;
    // End of variables declaration//GEN-END:variables
}