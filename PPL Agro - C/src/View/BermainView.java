/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseListener;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/**
 *
 * @author adheraprabu
 */
public class BermainView extends javax.swing.JFrame {

    /**
     * Creates new form bermainView
     */
    public BermainView() {
        initComponents();
        setLocationRelativeTo(this);

    }

    public void KembaliMouseListener(MouseListener l) {
        this.Button_kembali.addMouseListener(l);
    }

    public void kotak1MouseListener(MouseListener l) {
        this.Button_kotak1.addMouseListener(l);
    }

    public void kotak2MouseListener(MouseListener l) {
        this.Button_kotak2.addMouseListener(l);
    }

    public void kotak3MouseListener(MouseListener l) {
        this.Button_kotak3.addMouseListener(l);
    }

    public void kotak4MouseListener(MouseListener l) {
        this.Button_kotak4.addMouseListener(l);
    }

    public void kotak5MouseListener(MouseListener l) {
        this.Button_kotak5.addMouseListener(l);
    }

    public void kotak6MouseListener(MouseListener l) {
        this.Button_kotak6.addMouseListener(l);
    }

    public void kotak7MouseListener(MouseListener l) {
        this.Button_kotak7.addMouseListener(l);
    }

    public void kotak8MouseListener(MouseListener l) {
        this.Button_kotak8.addMouseListener(l);
    }

    public void pupukMouseListener(MouseListener l) {
        this.Button_pupuk.addMouseListener(l);
    }

    public void airMouseListener(MouseListener l) {
        this.Button_air.addMouseListener(l);
    }

    public void tasMouseListener(MouseListener l) {
        this.Button_tas.addMouseListener(l);
    }

    public JButton getButton_air() {
        return Button_air;
    }

    public void setButton_air(JButton Button_air) {
        this.Button_air = Button_air;
    }

    public JButton getButton_kembali() {
        return Button_kembali;
    }

    public void setButton_kembali(JButton Button_kembali) {
        this.Button_kembali = Button_kembali;
    }

    public JButton getButton_kotak1() {
        return Button_kotak1;
    }

    public void setButton_kotak1(JButton Button_kotak1) {
        this.Button_kotak1 = Button_kotak1;
    }

    public JButton getButton_kotak2() {
        return Button_kotak2;
    }

    public void setButton_kotak2(JButton Button_kotak2) {
        this.Button_kotak2 = Button_kotak2;
    }

    public JButton getButton_kotak3() {
        return Button_kotak3;
    }

    public void setButton_kotak3(JButton Button_kotak3) {
        this.Button_kotak3 = Button_kotak3;
    }

    public JButton getButton_kotak4() {
        return Button_kotak4;
    }

    public void setButton_kotak4(JButton Button_kotak4) {
        this.Button_kotak4 = Button_kotak4;
    }

    public JButton getButton_kotak5() {
        return Button_kotak5;
    }

    public void setButton_kotak5(JButton Button_kotak5) {
        this.Button_kotak5 = Button_kotak5;
    }

    public JButton getButton_kotak6() {
        return Button_kotak6;
    }

    public void setButton_kotak6(JButton Button_kotak6) {
        this.Button_kotak6 = Button_kotak6;
    }

    public JButton getButton_kotak7() {
        return Button_kotak7;
    }

    public void setButton_kotak7(JButton Button_kotak7) {
        this.Button_kotak7 = Button_kotak7;
    }

    public JButton getButton_kotak8() {
        return Button_kotak8;
    }

    public void setButton_kotak8(JButton Button_kotak8) {
        this.Button_kotak8 = Button_kotak8;
    }

    public JButton getButton_pupuk() {
        return Button_pupuk;
    }

    public void setButton_pupuk(JButton Button_pupuk) {
        this.Button_pupuk = Button_pupuk;
    }

    public JButton getButton_tas() {
        return Button_tas;
    }

    public void setButton_tas(JButton Button_tas) {
        this.Button_tas = Button_tas;
    }

    public JLabel getLabel_jmlAir() {
        return Label_jmlAir;
    }

    public void setLabel_jmlAir(JLabel Label_jmlAir) {
        this.Label_jmlAir = Label_jmlAir;
    }

    public JLabel getLabel_jmlPupuk() {
        return Label_jmlPupuk;
    }

    public void setLabel_jmlPupuk(JLabel Label_jmlPupuk) {
        this.Label_jmlPupuk = Label_jmlPupuk;
    }

    public JLabel getLabel_jmlUang() {
        return Label_jmlUang;
    }

    public void setLabel_jmlUang(JLabel Label_jmlUang) {
        this.Label_jmlUang = Label_jmlUang;
    }

    public JLabel getLabel_level() {
        return Label_level;
    }

    public void setLabel_level(JLabel Label_level) {
        this.Label_level = Label_level;
    }

    public JLabel getLabel_pohon1() {
        return Label_pohon1;
    }

    public void setLabel_pohon1(JLabel Label_pohon1) {
        this.Label_pohon1 = Label_pohon1;
    }

    public JLabel getLabel_pohon1_2() {
        return Label_pohon1_2;
    }

    public void setLabel_pohon1_2(JLabel Label_pohon1_2) {
        this.Label_pohon1_2 = Label_pohon1_2;
    }

    public JLabel getLabel_pohon2() {
        return Label_pohon2;
    }

    public void setLabel_pohon2(JLabel Label_pohon2) {
        this.Label_pohon2 = Label_pohon2;
    }

    public JLabel getLabel_pohon2_2() {
        return Label_pohon2_2;
    }

    public void setLabel_pohon2_2(JLabel Label_pohon2_2) {
        this.Label_pohon2_2 = Label_pohon2_2;
    }

    public JLabel getLabel_pohon3() {
        return Label_pohon3;
    }

    public void setLabel_pohon3(JLabel Label_pohon3) {
        this.Label_pohon3 = Label_pohon3;
    }

    public JLabel getLabel_pohon3_2() {
        return Label_pohon3_2;
    }

    public void setLabel_pohon3_2(JLabel Label_pohon3_2) {
        this.Label_pohon3_2 = Label_pohon3_2;
    }

    public JLabel getLabel_pohon4() {
        return Label_pohon4;
    }

    public void setLabel_pohon4(JLabel Label_pohon4) {
        this.Label_pohon4 = Label_pohon4;
    }

    public JLabel getLabel_pohon4_2() {
        return Label_pohon4_2;
    }

    public void setLabel_pohon4_2(JLabel Label_pohon4_2) {
        this.Label_pohon4_2 = Label_pohon4_2;
    }

    public JLabel getLabel_pohon5() {
        return Label_pohon5;
    }

    public void setLabel_pohon5(JLabel Label_pohon5) {
        this.Label_pohon5 = Label_pohon5;
    }

    public JLabel getLabel_pohon5_2() {
        return Label_pohon5_2;
    }

    public void setLabel_pohon5_2(JLabel Label_pohon5_2) {
        this.Label_pohon5_2 = Label_pohon5_2;
    }

    public JLabel getLabel_pohon6() {
        return Label_pohon6;
    }

    public void setLabel_pohon6(JLabel Label_pohon6) {
        this.Label_pohon6 = Label_pohon6;
    }

    public JLabel getLabel_pohon6_2() {
        return Label_pohon6_2;
    }

    public void setLabel_pohon6_2(JLabel Label_pohon6_2) {
        this.Label_pohon6_2 = Label_pohon6_2;
    }

    public JLabel getLabel_pohon7() {
        return Label_pohon7;
    }

    public void setLabel_pohon7(JLabel Label_pohon7) {
        this.Label_pohon7 = Label_pohon7;
    }

    public JLabel getLabel_pohon7_2() {
        return Label_pohon7_2;
    }

    public void setLabel_pohon7_2(JLabel Label_pohon7_2) {
        this.Label_pohon7_2 = Label_pohon7_2;
    }

    public JLabel getLabel_pohon8() {
        return Label_pohon8;
    }

    public void setLabel_pohon8(JLabel Label_pohon8) {
        this.Label_pohon8 = Label_pohon8;
    }

    public JLabel getLabel_pohon8_2() {
        return Label_pohon8_2;
    }

    public void setLabel_pohon8_2(JLabel Label_pohon8_2) {
        this.Label_pohon8_2 = Label_pohon8_2;
    }

    public JLabel getLabel_tanah1() {
        return Label_tanah1;
    }

    public void setLabel_tanah1(JLabel Label_tanah1) {
        this.Label_tanah1 = Label_tanah1;
    }

    public JLabel getLabel_tanah2() {
        return Label_tanah2;
    }

    public void setLabel_tanah2(JLabel Label_tanah2) {
        this.Label_tanah2 = Label_tanah2;
    }

    public JLabel getLabel_tanah3() {
        return Label_tanah3;
    }

    public void setLabel_tanah3(JLabel Label_tanah3) {
        this.Label_tanah3 = Label_tanah3;
    }

    public JLabel getLabel_tanah4() {
        return Label_tanah4;
    }

    public void setLabel_tanah4(JLabel Label_tanah4) {
        this.Label_tanah4 = Label_tanah4;
    }

    public JLabel getLabel_tanah5() {
        return Label_tanah5;
    }

    public void setLabel_tanah5(JLabel Label_tanah5) {
        this.Label_tanah5 = Label_tanah5;
    }

    public JLabel getLabel_tanah6() {
        return Label_tanah6;
    }

    public void setLabel_tanah6(JLabel Label_tanah6) {
        this.Label_tanah6 = Label_tanah6;
    }

    public JLabel getLabel_tanah7() {
        return Label_tanah7;
    }

    public void setLabel_tanah7(JLabel Label_tanah7) {
        this.Label_tanah7 = Label_tanah7;
    }

    public JLabel getLabel_tanah8() {
        return Label_tanah8;
    }

    public void setLabel_tanah8(JLabel Label_tanah8) {
        this.Label_tanah8 = Label_tanah8;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button_kembali = new javax.swing.JButton();
        Label_jmlPupuk = new javax.swing.JLabel();
        Label_jmlAir = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label_pohon1_2 = new javax.swing.JLabel();
        Label_pohon2_2 = new javax.swing.JLabel();
        Label_pohon3_2 = new javax.swing.JLabel();
        Label_pohon4_2 = new javax.swing.JLabel();
        Label_pohon5_2 = new javax.swing.JLabel();
        Label_pohon6_2 = new javax.swing.JLabel();
        Label_pohon7_2 = new javax.swing.JLabel();
        Label_pohon8_2 = new javax.swing.JLabel();
        Label_pohon1 = new javax.swing.JLabel();
        Label_pohon2 = new javax.swing.JLabel();
        Label_pohon3 = new javax.swing.JLabel();
        Label_pohon4 = new javax.swing.JLabel();
        Label_pohon5 = new javax.swing.JLabel();
        Label_pohon6 = new javax.swing.JLabel();
        Label_pohon7 = new javax.swing.JLabel();
        Label_pohon8 = new javax.swing.JLabel();
        Label_tanah1 = new javax.swing.JLabel();
        Label_tanah2 = new javax.swing.JLabel();
        Label_tanah3 = new javax.swing.JLabel();
        Label_tanah4 = new javax.swing.JLabel();
        Label_tanah5 = new javax.swing.JLabel();
        Label_tanah6 = new javax.swing.JLabel();
        Label_tanah7 = new javax.swing.JLabel();
        Label_tanah8 = new javax.swing.JLabel();
        Button_kotak1 = new javax.swing.JButton();
        Button_kotak2 = new javax.swing.JButton();
        Button_kotak3 = new javax.swing.JButton();
        Button_kotak4 = new javax.swing.JButton();
        Button_kotak5 = new javax.swing.JButton();
        Button_kotak6 = new javax.swing.JButton();
        Button_kotak7 = new javax.swing.JButton();
        Button_kotak8 = new javax.swing.JButton();
        Button_air = new javax.swing.JButton();
        Button_pupuk = new javax.swing.JButton();
        Button_tas = new javax.swing.JButton();
        Label_jmlUang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Label_level = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/TentangUI/BACK.png"))); // NOI18N
        Button_kembali.setBorderPainted(false);
        Button_kembali.setContentAreaFilled(false);
        Button_kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kembali.setFocusable(false);
        getContentPane().add(Button_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        Label_jmlPupuk.setFont(new java.awt.Font("Niagara Engraved", 1, 18)); // NOI18N
        Label_jmlPupuk.setForeground(new java.awt.Color(255, 255, 255));
        Label_jmlPupuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_jmlPupuk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(Label_jmlPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 100, 20));

        Label_jmlAir.setFont(new java.awt.Font("Niagara Engraved", 1, 18)); // NOI18N
        Label_jmlAir.setForeground(new java.awt.Color(255, 255, 255));
        Label_jmlAir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_jmlAir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(Label_jmlAir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 100, 20));

        Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/jml_air.png"))); // NOI18N
        getContentPane().add(Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/jml_pupuk.png"))); // NOI18N
        getContentPane().add(Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        Label_pohon1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        Label_pohon2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        Label_pohon3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        Label_pohon4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        Label_pohon5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        Label_pohon6_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        Label_pohon7_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Label_pohon8_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon2.png"))); // NOI18N
        getContentPane().add(Label_pohon8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        Label_pohon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        Label_pohon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, -1));

        Label_pohon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        Label_pohon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, -1));

        Label_pohon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        Label_pohon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        Label_pohon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        Label_pohon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pohon1.png"))); // NOI18N
        getContentPane().add(Label_pohon8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, -1, -1));

        Label_tanah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        Label_tanah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, -1, 30));

        Label_tanah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        Label_tanah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        Label_tanah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        Label_tanah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        Label_tanah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        Label_tanah8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tanah.png"))); // NOI18N
        getContentPane().add(Label_tanah8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, -1, -1));

        Button_kotak1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak1.setBorderPainted(false);
        Button_kotak1.setContentAreaFilled(false);
        Button_kotak1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak1.setFocusable(false);
        Button_kotak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        Button_kotak2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak2.setBorderPainted(false);
        Button_kotak2.setContentAreaFilled(false);
        Button_kotak2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak2.setFocusable(false);
        Button_kotak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak2ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, -1, -1));

        Button_kotak3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak3.setBorderPainted(false);
        Button_kotak3.setContentAreaFilled(false);
        Button_kotak3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak3.setFocusable(false);
        Button_kotak3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak3ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        Button_kotak4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak4.setBorderPainted(false);
        Button_kotak4.setContentAreaFilled(false);
        Button_kotak4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak4.setFocusable(false);
        Button_kotak4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak4ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        Button_kotak5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak5.setBorderPainted(false);
        Button_kotak5.setContentAreaFilled(false);
        Button_kotak5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak5.setFocusable(false);
        Button_kotak5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak5ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        Button_kotak6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak6.setBorderPainted(false);
        Button_kotak6.setContentAreaFilled(false);
        Button_kotak6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak6.setFocusable(false);
        Button_kotak6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak6ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));

        Button_kotak7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak7.setBorderPainted(false);
        Button_kotak7.setContentAreaFilled(false);
        Button_kotak7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak7.setFocusable(false);
        Button_kotak7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak7ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, -1));

        Button_kotak8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak.png"))); // NOI18N
        Button_kotak8.setBorderPainted(false);
        Button_kotak8.setContentAreaFilled(false);
        Button_kotak8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_kotak8.setFocusable(false);
        Button_kotak8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_kotak8ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_kotak8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, -1));

        Button_air.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/alat_siram1.png"))); // NOI18N
        Button_air.setBorderPainted(false);
        Button_air.setContentAreaFilled(false);
        Button_air.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_air.setFocusable(false);
        getContentPane().add(Button_air, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 90, 90));

        Button_pupuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/pupuk1.png"))); // NOI18N
        Button_pupuk.setBorderPainted(false);
        Button_pupuk.setContentAreaFilled(false);
        Button_pupuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_pupuk.setFocusable(false);
        getContentPane().add(Button_pupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 90, 90));

        Button_tas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/tas.png"))); // NOI18N
        Button_tas.setBorderPainted(false);
        Button_tas.setContentAreaFilled(false);
        Button_tas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_tas.setFocusable(false);
        getContentPane().add(Button_tas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 690, 70, -1));

        Label_jmlUang.setFont(new java.awt.Font("Niagara Engraved", 1, 24)); // NOI18N
        Label_jmlUang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_jmlUang.setToolTipText("");
        getContentPane().add(Label_jmlUang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 704, 170, 40));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("01");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 60, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/dollar.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, -1, -1));

        Label_level.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        Label_level.setForeground(new java.awt.Color(255, 255, 255));
        Label_level.setText("Level");
        getContentPane().add(Label_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/kotak_uang.png"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 700, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Lahan/lahan.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_kotak8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak8ActionPerformed

    private void Button_kotak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak2ActionPerformed

    private void Button_kotak4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak4ActionPerformed

    private void Button_kotak6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak6ActionPerformed

    private void Button_kotak3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak3ActionPerformed

    private void Button_kotak5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak5ActionPerformed

    private void Button_kotak7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak7ActionPerformed

    private void Button_kotak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_kotak1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_kotak1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_air;
    private javax.swing.JButton Button_kembali;
    private javax.swing.JButton Button_kotak1;
    private javax.swing.JButton Button_kotak2;
    private javax.swing.JButton Button_kotak3;
    private javax.swing.JButton Button_kotak4;
    private javax.swing.JButton Button_kotak5;
    private javax.swing.JButton Button_kotak6;
    private javax.swing.JButton Button_kotak7;
    private javax.swing.JButton Button_kotak8;
    private javax.swing.JButton Button_pupuk;
    private javax.swing.JButton Button_tas;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label_jmlAir;
    private javax.swing.JLabel Label_jmlPupuk;
    private javax.swing.JLabel Label_jmlUang;
    private javax.swing.JLabel Label_level;
    private javax.swing.JLabel Label_pohon1;
    private javax.swing.JLabel Label_pohon1_2;
    private javax.swing.JLabel Label_pohon2;
    private javax.swing.JLabel Label_pohon2_2;
    private javax.swing.JLabel Label_pohon3;
    private javax.swing.JLabel Label_pohon3_2;
    private javax.swing.JLabel Label_pohon4;
    private javax.swing.JLabel Label_pohon4_2;
    private javax.swing.JLabel Label_pohon5;
    private javax.swing.JLabel Label_pohon5_2;
    private javax.swing.JLabel Label_pohon6;
    private javax.swing.JLabel Label_pohon6_2;
    private javax.swing.JLabel Label_pohon7;
    private javax.swing.JLabel Label_pohon7_2;
    private javax.swing.JLabel Label_pohon8;
    private javax.swing.JLabel Label_pohon8_2;
    private javax.swing.JLabel Label_tanah1;
    private javax.swing.JLabel Label_tanah2;
    private javax.swing.JLabel Label_tanah3;
    private javax.swing.JLabel Label_tanah4;
    private javax.swing.JLabel Label_tanah5;
    private javax.swing.JLabel Label_tanah6;
    private javax.swing.JLabel Label_tanah7;
    private javax.swing.JLabel Label_tanah8;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
