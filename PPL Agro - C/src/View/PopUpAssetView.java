/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author adheraprabu
 */
public class PopUpAssetView extends javax.swing.JDialog {

    /**
     * Creates new form PopUpAssetView
     */
    public PopUpAssetView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    public void CloseMouseListener(MouseListener l) {
        this.Button_close.addMouseListener(l);
    }
    public void PohonJatiMouseListener(MouseListener l) {
        this.Button_pohonJati.addMouseListener(l);
    }
    public void PohonCemaraMouseListener(MouseListener l) {
        this.Button_pohonCemara.addMouseListener(l);
    }
    public void PohonKapurMouseListener(MouseListener l) {
        this.Button_pohonKapur.addMouseListener(l);
    }
    public void PohonKayuBesiMouseListener(MouseListener l) {
        this.Button_pohonKayuBesi.addMouseListener(l);
    }
    public void PohonKayuHitamMouseListener(MouseListener l) {
        this.Button_pohonKayuHitam.addMouseListener(l);
    }
    public void PohonPilangMouseListener(MouseListener l) {
        this.Button_pohonPilang.addMouseListener(l);
    }
    public void PohonPinusMouseListener(MouseListener l) {
        this.Button_pohonPinus.addMouseListener(l);
    }
    public void PohonSakuraMouseListener(MouseListener l) {
        this.Button_pohonSakura.addMouseListener(l);
    }

    public void setButton_close(JButton Button_close) {
        this.Button_close = Button_close;
    }

    public void setButton_pohonJati(JButton Button_pohonJati) {
        this.Button_pohonJati = Button_pohonJati;
    }

    public JButton getButton_close() {
        return Button_close;
    }

    public JButton getButton_pohonJati() {
        return Button_pohonJati;
    }

    public JButton getButton_pohonCemara() {
        return Button_pohonCemara;
    }

    public void setButton_pohonCemara(JButton Button_pohonCemara) {
        this.Button_pohonCemara = Button_pohonCemara;
    }

    public JButton getButton_pohonKapur() {
        return Button_pohonKapur;
    }

    public void setButton_pohonKapur(JButton Button_pohonKapur) {
        this.Button_pohonKapur = Button_pohonKapur;
    }

    public JButton getButton_pohonKayuBesi() {
        return Button_pohonKayuBesi;
    }

    public void setButton_pohonKayuBesi(JButton Button_pohonKayuBesi) {
        this.Button_pohonKayuBesi = Button_pohonKayuBesi;
    }

    public JButton getButton_pohonKayuHitam() {
        return Button_pohonKayuHitam;
    }

    public void setButton_pohonKayuHitam(JButton Button_pohonKayuHitam) {
        this.Button_pohonKayuHitam = Button_pohonKayuHitam;
    }

    public JButton getButton_pohonPilang() {
        return Button_pohonPilang;
    }

    public void setButton_pohonPilang(JButton Button_pohonPilang) {
        this.Button_pohonPilang = Button_pohonPilang;
    }

    public JButton getButton_pohonPinus() {
        return Button_pohonPinus;
    }

    public void setButton_pohonPinus(JButton Button_pohonPinus) {
        this.Button_pohonPinus = Button_pohonPinus;
    }

    public JButton getButton_pohonSakura() {
        return Button_pohonSakura;
    }

    public void setButton_pohonSakura(JButton Button_pohonSakura) {
        this.Button_pohonSakura = Button_pohonSakura;
    }

    public JLabel getLabel_jmlPohonCemara() {
        return Label_jmlPohonCemara;
    }

    public void setLabel_jmlPohonCemara(JLabel Label_jmlPohonCemara) {
        this.Label_jmlPohonCemara = Label_jmlPohonCemara;
    }

    public JLabel getLabel_jmlPohonJati() {
        return Label_jmlPohonJati;
    }

    public void setLabel_jmlPohonJati(JLabel Label_jmlPohonJati) {
        this.Label_jmlPohonJati = Label_jmlPohonJati;
    }

    public JLabel getLabel_jmlPohonKapur() {
        return Label_jmlPohonKapur;
    }

    public void setLabel_jmlPohonKapur(JLabel Label_jmlPohonKapur) {
        this.Label_jmlPohonKapur = Label_jmlPohonKapur;
    }

    public JLabel getLabel_jmlPohonKayuBesi() {
        return Label_jmlPohonKayuBesi;
    }

    public void setLabel_jmlPohonKayuBesi(JLabel Label_jmlPohonKayuBesi) {
        this.Label_jmlPohonKayuBesi = Label_jmlPohonKayuBesi;
    }

    public JLabel getLabel_jmlPohonKayuHitam() {
        return Label_jmlPohonKayuHitam;
    }

    public void setLabel_jmlPohonKayuHitam(JLabel Label_jmlPohonKayuHitam) {
        this.Label_jmlPohonKayuHitam = Label_jmlPohonKayuHitam;
    }

    public JLabel getLabel_jmlPohonPilang() {
        return Label_jmlPohonPilang;
    }

    public void setLabel_jmlPohonPilang(JLabel Label_jmlPohonPilang) {
        this.Label_jmlPohonPilang = Label_jmlPohonPilang;
    }

    public JLabel getLabel_jmlPohonPinus() {
        return Label_jmlPohonPinus;
    }

    public void setLabel_jmlPohonPinus(JLabel Label_jmlPohonPinus) {
        this.Label_jmlPohonPinus = Label_jmlPohonPinus;
    }

    public JLabel getLabel_jmlPohonSakura() {
        return Label_jmlPohonSakura;
    }

    public void setLabel_jmlPohonSakura(JLabel Label_jmlPohonSakura) {
        this.Label_jmlPohonSakura = Label_jmlPohonSakura;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_jmlPohonKayuHitam = new javax.swing.JLabel();
        Label_jmlPohonKapur = new javax.swing.JLabel();
        Label_jmlPohonSakura = new javax.swing.JLabel();
        Label_jmlPohonPilang = new javax.swing.JLabel();
        Label_jmlPohonKayuBesi = new javax.swing.JLabel();
        Label_jmlPohonCemara = new javax.swing.JLabel();
        Label_jmlPohonPinus = new javax.swing.JLabel();
        Label_jmlPohonJati = new javax.swing.JLabel();
        Button_close = new javax.swing.JButton();
        Button_pohonKayuHitam = new javax.swing.JButton();
        Button_pohonKapur = new javax.swing.JButton();
        Button_pohonSakura = new javax.swing.JButton();
        Button_pohonPilang = new javax.swing.JButton();
        Button_pohonKayuBesi = new javax.swing.JButton();
        Button_pohonCemara = new javax.swing.JButton();
        Button_pohonPinus = new javax.swing.JButton();
        Button_pohonJati = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_jmlPohonKayuHitam.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonKayuHitam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonKayuHitam, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 60, 20));

        Label_jmlPohonKapur.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonKapur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonKapur, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 60, 20));

        Label_jmlPohonSakura.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonSakura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonSakura, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 60, 20));

        Label_jmlPohonPilang.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonPilang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonPilang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 60, 20));

        Label_jmlPohonKayuBesi.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonKayuBesi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonKayuBesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 60, 20));

        Label_jmlPohonCemara.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonCemara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonCemara, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 60, 20));

        Label_jmlPohonPinus.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonPinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonPinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 60, 20));

        Label_jmlPohonJati.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Label_jmlPohonJati.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Label_jmlPohonJati, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 60, 20));

        Button_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/back-01.png"))); // NOI18N
        Button_close.setBorderPainted(false);
        Button_close.setContentAreaFilled(false);
        Button_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_close.setFocusable(false);
        Button_close.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Button_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_closeActionPerformed(evt);
            }
        });
        getContentPane().add(Button_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 80));

        Button_pohonKayuHitam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/2.png"))); // NOI18N
        Button_pohonKayuHitam.setBorderPainted(false);
        Button_pohonKayuHitam.setContentAreaFilled(false);
        Button_pohonKayuHitam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonKayuHitam.setFocusable(false);
        getContentPane().add(Button_pohonKayuHitam, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 100, -1));

        Button_pohonKapur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/3.png"))); // NOI18N
        Button_pohonKapur.setBorderPainted(false);
        Button_pohonKapur.setContentAreaFilled(false);
        Button_pohonKapur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonKapur.setFocusable(false);
        getContentPane().add(Button_pohonKapur, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 100, -1));

        Button_pohonSakura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/4.png"))); // NOI18N
        Button_pohonSakura.setBorderPainted(false);
        Button_pohonSakura.setContentAreaFilled(false);
        Button_pohonSakura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonSakura.setFocusable(false);
        getContentPane().add(Button_pohonSakura, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 100, -1));

        Button_pohonPilang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/5.png"))); // NOI18N
        Button_pohonPilang.setBorderPainted(false);
        Button_pohonPilang.setContentAreaFilled(false);
        Button_pohonPilang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonPilang.setFocusable(false);
        getContentPane().add(Button_pohonPilang, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, -1));

        Button_pohonKayuBesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/6.png"))); // NOI18N
        Button_pohonKayuBesi.setBorderPainted(false);
        Button_pohonKayuBesi.setContentAreaFilled(false);
        Button_pohonKayuBesi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonKayuBesi.setFocusable(false);
        getContentPane().add(Button_pohonKayuBesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 100, -1));

        Button_pohonCemara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/7.png"))); // NOI18N
        Button_pohonCemara.setBorderPainted(false);
        Button_pohonCemara.setContentAreaFilled(false);
        Button_pohonCemara.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonCemara.setFocusable(false);
        getContentPane().add(Button_pohonCemara, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 100, -1));

        Button_pohonPinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/8.png"))); // NOI18N
        Button_pohonPinus.setBorderPainted(false);
        Button_pohonPinus.setContentAreaFilled(false);
        Button_pohonPinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonPinus.setFocusable(false);
        getContentPane().add(Button_pohonPinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 100, -1));

        Button_pohonJati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/1.png"))); // NOI18N
        Button_pohonJati.setBorderPainted(false);
        Button_pohonJati.setContentAreaFilled(false);
        Button_pohonJati.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pohonJati.setFocusable(false);
        Button_pohonJati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_pohonJatiActionPerformed(evt);
            }
        });
        getContentPane().add(Button_pohonJati, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Asset/asset.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_closeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_closeActionPerformed

    private void Button_pohonJatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_pohonJatiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_pohonJatiActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_close;
    private javax.swing.JButton Button_pohonCemara;
    private javax.swing.JButton Button_pohonJati;
    private javax.swing.JButton Button_pohonKapur;
    private javax.swing.JButton Button_pohonKayuBesi;
    private javax.swing.JButton Button_pohonKayuHitam;
    private javax.swing.JButton Button_pohonPilang;
    private javax.swing.JButton Button_pohonPinus;
    private javax.swing.JButton Button_pohonSakura;
    private javax.swing.JLabel Label_jmlPohonCemara;
    private javax.swing.JLabel Label_jmlPohonJati;
    private javax.swing.JLabel Label_jmlPohonKapur;
    private javax.swing.JLabel Label_jmlPohonKayuBesi;
    private javax.swing.JLabel Label_jmlPohonKayuHitam;
    private javax.swing.JLabel Label_jmlPohonPilang;
    private javax.swing.JLabel Label_jmlPohonPinus;
    private javax.swing.JLabel Label_jmlPohonSakura;
    private javax.swing.JLabel bg;
    // End of variables declaration//GEN-END:variables
}
