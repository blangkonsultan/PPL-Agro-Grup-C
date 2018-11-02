/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.AwalView;
import View.BermainView;
import View.MulaiView;
import View.NewGameView;
import View.PopUpAssetView;
import View.PopUpKeluarView;
import View.PopUpMasukkanNamaView;
import View.PopUpPilihHutanView;
import View.TentangView;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author adheraprabu
 */
public class UserController {

    UserModel userM;
    AwalView awal = new AwalView();
    TentangView tentang = new TentangView();
    MulaiView mulai = new MulaiView();
    NewGameView newGame = new NewGameView();
    BermainView bermain = new BermainView();
    PopUpKeluarView dialogKeluar;
    PopUpMasukkanNamaView dialogMasukkanNama;
    PopUpPilihHutanView dialogPilihHutan;
    PopUpAssetView dialogAsset;
    public static String username = "";
    Timer time;
    boolean hutanHujan;

//    boolean pindah = false;
//    private final int sekon = 40;
//    private final int sekonLama = 120;
    public UserController(AwalView awal, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        //Constructor untuk memanggil frame Awal
        this.awal = awal;
        this.userM = userM;
        awal.setVisible(true);
        awal.MulaiMouseListener(new MulaiMouseListenner());
        awal.BantuanMouseListener(new BantuanMouseListener());
        awal.TentangMouseListener(new TentangMouseListenner());
        awal.KeluarMouseListener(new KeluarMouseListenner());

        dialogKeluar = new PopUpKeluarView(awal, true);
        dialogKeluar.TidakMouseListener(new TidakKeluarMouseListenner());
        dialogKeluar.YaMouseListener(new YaKeluarMouseListenner());

        dialogMasukkanNama = new PopUpMasukkanNamaView(newGame, true);
        dialogMasukkanNama.OkMouseListener(new OkMouseLitener());

    }

    public UserController(TentangView tentang, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        this.tentang = tentang;
        this.userM = userM;
        tentang.setVisible(true);
        tentang.KembaliMouseListener(new KembaliTentangMouseListenner());
    }

    public UserController(MulaiView mulai, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        this.mulai = mulai;
        this.userM = userM;
        mulai.setVisible(true);
        mulai.getButton_hujantropis().setVisible(true);
        mulai.getButton_hutanMusim().setVisible(false);
        mulai.getLabel_username().setText(username);
        mulai.BackMouseListener(new BackMulaiMouseListener());
        mulai.PrevMouseListener(new PrevMouseListener());
        mulai.NextMouseListener(new NextMouseListener());
        mulai.PilihMouseListener(new PilihMulaiMouseListener());

        dialogPilihHutan = new PopUpPilihHutanView(mulai, true);
        dialogPilihHutan.TidakMouseListener(new TidakMulaiMouseListenner());
        dialogPilihHutan.YaMouseListener(new YaMulaiMouseListenner());

    }

    public UserController(NewGameView newGame, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        this.newGame = newGame;
        this.userM = userM;
        newGame.setVisible(true);
        newGame.KembaliMouseListener(new KembaliNewgameMouseListener());
        newGame.MulaiBaruMouseListener(new MulaiBaruMouseLisener());
        newGame.LanjutkanMouseListener(new LanjutkanMouseLitener());

    }

    public UserController(BermainView bermain, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        this.bermain = bermain;
        this.userM = userM;
        bermain.setVisible(true);
        bermain.getLabel_tanah1().setVisible(false);
        bermain.getLabel_tanah2().setVisible(false);
        bermain.getLabel_tanah3().setVisible(false);
        bermain.getLabel_tanah4().setVisible(false);
        bermain.getLabel_tanah5().setVisible(false);
        bermain.getLabel_tanah6().setVisible(false);
        bermain.getLabel_tanah7().setVisible(false);
        bermain.getLabel_tanah8().setVisible(false);
        bermain.getLabel_pohon1().setVisible(false);
        bermain.getLabel_pohon2().setVisible(false);
        bermain.getLabel_pohon3().setVisible(false);
        bermain.getLabel_pohon4().setVisible(false);
        bermain.getLabel_pohon5().setVisible(false);
        bermain.getLabel_pohon6().setVisible(false);
        bermain.getLabel_pohon7().setVisible(false);
        bermain.getLabel_pohon8().setVisible(false);
        bermain.getLabel_tanah8().setVisible(false);
        bermain.getLabel_pohon1_2().setVisible(false);
        bermain.getLabel_pohon2_2().setVisible(false);
        bermain.getLabel_pohon3_2().setVisible(false);
        bermain.getLabel_pohon4_2().setVisible(false);
        bermain.getLabel_pohon5_2().setVisible(false);
        bermain.getLabel_pohon6_2().setVisible(false);
        bermain.getLabel_pohon7_2().setVisible(false);
        bermain.getLabel_pohon8_2().setVisible(false);
        bermain.KembaliMouseListener(new KembaliBermainMouseListener());
        bermain.kotak1MouseListener(new kotak1Listener());
        bermain.kotak2MouseListener(new kotak2Listener());
        bermain.kotak3MouseListener(new kotak3Listener());
        bermain.kotak4MouseListener(new kotak4Listener());
        bermain.kotak5MouseListener(new kotak5Listener());
        bermain.kotak6MouseListener(new kotak6Listener());
        bermain.kotak7MouseListener(new kotak7Listener());
        bermain.kotak8MouseListener(new kotak8Listener());
        bermain.pupukMouseListener(new pupukListener());
        bermain.airMouseListener(new airListener());
        bermain.tasMouseListener(new tasListener());

        dialogAsset = new PopUpAssetView(bermain, true);
        dialogAsset.CloseMouseListener(new CloseListener());
        dialogAsset.PohonJatiMouseListener(new pohonjatiListener());
        dialogAsset.PohonCemaraMouseListener(new pohonCemaraListener());
        dialogAsset.PohonKapurMouseListener(new pohonKapurListener());
        dialogAsset.PohonKayuBesiMouseListener(new pohonKayuBesiListener());
        dialogAsset.PohonKayuHitamMouseListener(new pohonKayuHitamListener());
        dialogAsset.PohonPilangMouseListener(new pohonPilangListener());
        dialogAsset.PohonPinusMouseListener(new pohonPinusListener());
        dialogAsset.PohonSakuraMouseListener(new pohonSakuraListener());
    }

    private void setIcon(JButton button, String resource) {
        //Method untuk mengganti icon button
        button.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void tanam(String frame, int sec) {
        if (frame.equalsIgnoreCase("bermain")) {
            if (!bermain.getLabel_tanah1().isVisible()) {
                bermain.getLabel_tanah1().setVisible(true);
                timer("bermain", 1, sec);
            } else if (!bermain.getLabel_tanah2().isVisible()) {
                bermain.getLabel_tanah2().setVisible(true);
                timer("bermain", 2, sec);
            } else if (!bermain.getLabel_tanah3().isVisible()) {
                bermain.getLabel_tanah3().setVisible(true);
                timer("bermain", 3, sec);
            } else if (!bermain.getLabel_tanah4().isVisible()) {
                bermain.getLabel_tanah4().setVisible(true);
                timer("bermain", 4, sec);
            } else if (!bermain.getLabel_tanah5().isVisible()) {
                bermain.getLabel_tanah5().setVisible(true);
                timer("bermain", 5, sec);
            } else if (!bermain.getLabel_tanah6().isVisible()) {
                bermain.getLabel_tanah6().setVisible(true);
                timer("bermain", 6, sec);
            } else if (!bermain.getLabel_tanah7().isVisible()) {
                bermain.getLabel_tanah7().setVisible(true);
                timer("bermain", 7, sec);
            } else if (!bermain.getLabel_tanah8().isVisible()) {
                bermain.getLabel_tanah8().setVisible(true);
                timer("bermain", 8, sec);
            }
        }
    }

    private void timer(String frame, int lahan, int sek) {

        ActionListener gameTimer = new ActionListener() {
            int sec = sek;

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(sec);
                sec--;

                if (frame.equalsIgnoreCase("bermain")) {
                    if (sec == 20) {
                        if (bermain.getLabel_tanah1().isVisible() && lahan == 1) {
                            bermain.getLabel_pohon1().setVisible(true);
                        }
                        if (bermain.getLabel_tanah2().isVisible() && lahan == 2) {
                            bermain.getLabel_pohon2().setVisible(true);
                        }

                        if (bermain.getLabel_tanah3().isVisible() && lahan == 3) {
                            bermain.getLabel_pohon3().setVisible(true);
                        }
                        if (bermain.getLabel_tanah4().isVisible() && lahan == 4) {
                            bermain.getLabel_pohon4().setVisible(true);
                        }
                        if (bermain.getLabel_tanah5().isVisible() && lahan == 5) {
                            bermain.getLabel_pohon5().setVisible(true);
                        }
                        if (bermain.getLabel_tanah6().isVisible() && lahan == 6) {
                            bermain.getLabel_pohon6().setVisible(true);
                        }
                        if (bermain.getLabel_tanah7().isVisible() && lahan == 7) {
                            bermain.getLabel_pohon7().setVisible(true);
                        }
                        if (bermain.getLabel_tanah8().isVisible() && lahan == 8) {
                            bermain.getLabel_pohon8().setVisible(true);
                        }
                    }
                    if (sec == 0) {
                        if (bermain.getLabel_pohon1().isVisible() && lahan == 1) {
                            bermain.getLabel_pohon1_2().setVisible(true);
                            bermain.getLabel_pohon1().setVisible(false);

                        }
                        if (bermain.getLabel_pohon2().isVisible() && lahan == 2) {
                            bermain.getLabel_pohon2_2().setVisible(true);
                            bermain.getLabel_pohon2().setVisible(false);

                        }
                        if (bermain.getLabel_pohon3().isVisible() && lahan == 3) {
                            bermain.getLabel_pohon3_2().setVisible(true);
                            bermain.getLabel_pohon3().setVisible(false);
//                           
                        }
                        if (bermain.getLabel_pohon4().isVisible() && lahan == 4) {
                            bermain.getLabel_pohon4_2().setVisible(true);
                            bermain.getLabel_pohon4().setVisible(false);

                        }
                        if (bermain.getLabel_pohon5().isVisible() && lahan == 5) {
                            bermain.getLabel_pohon5_2().setVisible(true);
                            bermain.getLabel_pohon5().setVisible(false);

                        }
                        if (bermain.getLabel_pohon6().isVisible() && lahan == 6) {
                            bermain.getLabel_pohon6_2().setVisible(true);
                            bermain.getLabel_pohon6().setVisible(false);

                        }
                        if (bermain.getLabel_pohon7().isVisible() && lahan == 7) {
                            bermain.getLabel_pohon7_2().setVisible(true);
                            bermain.getLabel_pohon7().setVisible(false);

                        }
                        if (bermain.getLabel_pohon8().isVisible() && lahan == 8) {
                            bermain.getLabel_pohon8_2().setVisible(true);
                            bermain.getLabel_pohon8().setVisible(false);

                        }
                    }
                }

            }

        };
        time = new Timer(1000, gameTimer);
        time.start();

    }

    public void stopTimer(String frame, int lahan) {

        time.stop();
    }

    private class pohonSakuraListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("lama");
                tanam("bermain", 1200);
            } else {
                tanam("bermain", 40);
                System.out.println("cepat");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonPinusListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("cepat");
                tanam("bermain", 40);
            } else {
                tanam("bermain", 1200);
                System.out.println("lama");
            }

            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonPilangListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("cepat");
                tanam("bermain", 40);
            } else {
                tanam("bermain", 1200);
                System.out.println("lama");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonKayuHitamListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("lama");
                tanam("bermain", 1200);
            } else {
                tanam("bermain", 40);
                System.out.println("cepat");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonKayuBesiListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("cepat");
                tanam("bermain", 40);
            } else {
                tanam("bermain", 1200);
                System.out.println("lama");
            }
            dialogAsset.dispose();
       
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonKapurListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (hutanHujan) {
                System.out.println("lama");
                tanam("bermain", 1200);
            } else {
                tanam("bermain", 40);
                System.out.println("cepat");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonCemaraListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if ( hutanHujan) {
                System.out.println("cepat");
                tanam("bermain", 40);
            } else {
                tanam("bermain", 1200);
                System.out.println("lama");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonjatiListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
           if ( hutanHujan) {
                System.out.println("lama");
                tanam("bermain", 1200);
            } else {
                tanam("bermain", 40);
                System.out.println("cepat");
            }
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class tasListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogAsset.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class airListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(bermain.getButton_air(), "/View/Lahan/alat_siram2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain.getButton_air(), "/View/Lahan/alat_siram1.png");
        }
    }

    private class CloseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogAsset.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogAsset.getButton_close(), "/View/Asset/back-02.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogAsset.getButton_close(), "/View/Asset/back-01.png");
        }
    }

    private class pupukListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(bermain.getButton_pupuk(), "/View/Lahan/pupuk2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain.getButton_pupuk(), "/View/Lahan/pupuk1.png");
        }
    }

    private class kotak8Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak6Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak7Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak5Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak4Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak3Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak2Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class kotak1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("bisa");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class KembaliBermainMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(mulai, userM);
                bermain.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(bermain.getButton_kembali(), "/View/TentangUI/BACK2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain.getButton_kembali(), "/View/TentangUI/BACK.png");
        }
    }

    private class YaMulaiMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(bermain, userM);
                mulai.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogPilihHutan.getButton_ya(), "/View/MulaiUI/ya.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogPilihHutan.getButton_ya(), "/View/MulaiUI/ya1.png");
        }
    }

    private class TidakMulaiMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogPilihHutan.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogPilihHutan.getButton_tidak(), "/View/MulaiUI/tidak.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogPilihHutan.getButton_tidak(), "/View/MulaiUI/tidak1.png");
        }
    }

    private class OkMouseLitener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                username = dialogMasukkanNama.getTextField_namaUaer().getText();
                if (username.equals("")) {
                    JOptionPane.showMessageDialog(newGame, "Username TIdak Boleh Kosong!!!");
                } else {
                    userM.tambahUser(username);
                    dialogMasukkanNama.dispose();
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogMasukkanNama.getButton_Ok(), "/View/MulaiUI/ok1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogMasukkanNama.getButton_Ok(), "/View/MulaiUI/ok.png");
        }
    }

    private class LanjutkanMouseLitener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(newGame.getButton_Lanjutkan(), "/View/MulaiUI/lanjut1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(newGame.getButton_Lanjutkan(), "/View/MulaiUI/lanjut.png");
        }
    }

    private class MulaiBaruMouseLisener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(mulai, userM);
                newGame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(newGame.getButton_MulaiBaru(), "/View/MulaiUI/mulai1.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(newGame.getButton_MulaiBaru(), "/View/MulaiUI/mulai.png");
        }
    }

    private class KembaliNewgameMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(awal, userM);
                newGame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(newGame.getButton_Kembali(), "/View/TentangUI/BACK2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(newGame.getButton_Kembali(), "/View/TentangUI/BACK.png");
        }
    }

    private class PilihMulaiMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            System.out.println("hutan hujan :" + hutanHujan);
            dialogPilihHutan.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(mulai.getButton_Pilih(), "/View/MulaiUI/PILIH2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(mulai.getButton_Pilih(), "/View/MulaiUI/PILIH.png");
        }
    }

    private class PrevMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(mulai.getButton_hutanHujan(), "/View/MulaiUI/hujantropis_htm.png");
            setIcon(mulai.getButton_HutanMusim(), "/View/MulaiUI/musim_brw.png");
            mulai.getButton_hujantropis().setVisible(true);
            mulai.getButton_hutanMusim().setVisible(false);
            hutanHujan = true;

            System.out.println("hutan hujan :" + hutanHujan);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            setIcon(mulai.getButton_prev(), "/View/MulaiUI/LEFT2.png");

        }

        @Override
        public void mouseExited(MouseEvent e) {

            setIcon(mulai.getButton_prev(), "/View/MulaiUI/LEFT.png");

        }
    }

    private class NextMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(mulai.getButton_HutanMusim(), "/View/MulaiUI/musim_htm.png");
            setIcon(mulai.getButton_hutanHujan(), "/View/MulaiUI/hujantropis_brw.png");
            mulai.getButton_hujantropis().setVisible(false);
            mulai.getButton_hutanMusim().setVisible(true);
            hutanHujan = false;

            System.out.println("hutan hujan :" + hutanHujan);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(mulai.getButton_next(), "/View/MulaiUI/NEXT.png");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(mulai.getButton_next(), "/View/MulaiUI/RIGHT.png");
        }
    }

    private class BackMulaiMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(awal, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mulai.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            setIcon(mulai.getButton_Back(), "/View/TentangUI/BACK2.png");

        }

        @Override
        public void mouseExited(MouseEvent e) {

            setIcon(mulai.getButton_Back(), "/View/TentangUI/BACK.png");
        }
    }

    private class KembaliTentangMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tentang.dispose();
            try {
                new UserController(awal, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(tentang.getButton_kembali(), "/View/TentangUI/BACK2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tentang.getButton_kembali(), "/View/TentangUI/BACK.png");
        }
    }

    private class YaKeluarMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            awal.dispose();
            dialogKeluar.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogKeluar.getButton_ya(), "/View/PopUpKeluarUI/ya.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogKeluar.getButton_ya(), "/View/PopUpKeluarUI/ya2.png");
        }
    }

    private class TidakKeluarMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKeluar.dispose();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(dialogKeluar.getButton_tidak(), "/View/PopUpKeluarUI/tidak2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogKeluar.getButton_tidak(), "/View/PopUpKeluarUI/tidak.png");
        }
    }

    private class KeluarMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogKeluar.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(awal.getButton_Keluar(), "/View/AwalUI/KELUAR2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Keluar(), "/View/AwalUI/KELUAR.png");
        }
    }

    private class TentangMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            awal.dispose();
            try {
                new UserController(tentang, userM);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(awal.getButton_Tentang(), "/View/AwalUI/TENTANG2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Tentang(), "/View/AwalUI/TENTANG.png");
        }
    }

    private class BantuanMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(awal.getButton_Bantuan(), "/View/AwalUI/BANTUAN2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Bantuan(), "/View/AwalUI/BANTUAN.png");
        }
    }

    private class MulaiMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                new UserController(newGame, userM);
                awal.dispose();
                dialogMasukkanNama.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(awal.getButton_Mulai(), "/View/AwalUI/MULAI2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(awal.getButton_Mulai(), "/View/AwalUI/MULAI.png");
        }
    }
}
