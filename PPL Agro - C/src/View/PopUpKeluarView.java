/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author adheraprabu
 */
public class PopUpKeluarView extends javax.swing.JDialog {

    /**
     * Creates new form PopUpKeluarView
     */
    public PopUpKeluarView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        setBackground(new Color(0, 0, 0, 0));
    }

    public void YaMouseListener(MouseListener l) {
        this.Button_ya.addMouseListener(l);
    }

    public void TidakMouseListener(MouseListener l) {
        this.Button_tidak.addMouseListener(l);
    }

    public JButton getButton_tidak() {
        return Button_tidak;
    }

    public void setButton_tidak(JButton Button_tidak) {
        this.Button_tidak = Button_tidak;
    }

    public JButton getButton_ya() {
        return Button_ya;
    }

    public void setButton_ya(JButton Button_ya) {
        this.Button_ya = Button_ya;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_ya = new javax.swing.JButton();
        Button_tidak = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setModalExclusionType(null);
        setModalityType(null);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_ya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/PopUpKeluarUI/ya2.png"))); // NOI18N
        Button_ya.setBorderPainted(false);
        Button_ya.setContentAreaFilled(false);
        Button_ya.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_ya.setFocusable(false);
        getContentPane().add(Button_ya, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 320, -1));

        Button_tidak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/PopUpKeluarUI/tidak.png"))); // NOI18N
        Button_tidak.setBorderPainted(false);
        Button_tidak.setContentAreaFilled(false);
        Button_tidak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_tidak.setFocusable(false);
        getContentPane().add(Button_tidak, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 330, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/PopUpKeluarUI/kotak.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_tidak;
    private javax.swing.JButton Button_ya;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
