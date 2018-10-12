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
import View.PopUpKeluarView;
import View.PopUpMasukkanNamaView;
import View.PopUpPilihHutanView;
import View.TentangView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
    public static String username = "";
    boolean pindah = false;

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
        bermain.KembaliMouseListener(new KembaliBermainMouseListener());
    }

    private void setIcon(JButton button, String resource) {
        //Method untuk mengganti icon button
        button.setIcon(new ImageIcon(getClass().getResource(resource)));
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
                mulai.getLabel_username().setText(username);
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
