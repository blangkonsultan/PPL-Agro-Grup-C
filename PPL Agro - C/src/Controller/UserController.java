/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.AwalView;
import View.Bermain1View;
import View.MulaiView;
import View.NewGameView;
import View.PanelTokoAirView;
import View.PanelTokoBibitView;
import View.PanelTokoPupukView;
import View.PopUpAssetView;
import View.PopUpKeluarView;
import View.PopUpMasukkanNamaView;
import View.PopUpPilihHutanView;
import View.PopUpShopView;
import View.PopUpUangKurangView;
import View.TentangView;
import java.awt.Button;
import java.awt.GridBagLayout;
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
import javax.swing.JLabel;
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
    Bermain1View bermain1 = new Bermain1View();
    PopUpKeluarView dialogKeluar;
    PopUpMasukkanNamaView dialogMasukkanNama;
    PopUpPilihHutanView dialogPilihHutan;
    PopUpAssetView dialogAsset;
    PopUpShopView dialogToko;
    PopUpUangKurangView dialogUangKurang;
    GridBagLayout layout = new GridBagLayout();
    PanelTokoAirView tokoAir = new PanelTokoAirView();
    PanelTokoPupukView tokoPupuk = new PanelTokoPupukView();
    PanelTokoBibitView tokoBibit = new PanelTokoBibitView();
    int air[] = {3, 0};// index pertama air saat ini, index kedua yg akan dibeli
    int hargaAir = 5;
    int hargaPupuk = 15;
    int pupuke[] = {3, 0};// index pertama pupuk saat ini, index kedua yg akan dibeli
    int bibit[] = {5, 5, 5, 5, 5, 5, 5, 5};//jumlah bibit tiap pohon
    //karet,pilang, cemara,kapur,pinus,kayu hitam, kayu besi,jati
//    int bibitbeli[] = {0, 0, 0, 0, 0, 0, 0, 0};//bibit yg akan dibeli
    int[] sekonTumbuh = new int[11];
    byte[] kotakAktif = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static String username = "";
    Timer time;
    byte hutan = 0;
    int uang = 100;
    boolean siram = false;
    boolean pupuk = false;

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

    public UserController(Bermain1View bermain1, UserModel userM) throws SQLException {
        this.userM = new UserModel();
        this.bermain1 = bermain1;
        this.userM = userM;
        bermain1.setVisible(true);
        bermain1.getLabel_tanah1().setVisible(false);
        bermain1.getLabel_tanah2().setVisible(false);
        bermain1.getLabel_tanah3().setVisible(false);
        bermain1.getLabel_tanah4().setVisible(false);
        bermain1.getLabel_pohon1().setVisible(false);
        bermain1.getLabel_pohon2().setVisible(false);
        bermain1.getLabel_pohon3().setVisible(false);
        bermain1.getLabel_pohon4().setVisible(false);
        bermain1.getLabel_pohon1_2().setVisible(false);
        bermain1.getLabel_pohon2_2().setVisible(false);
        bermain1.getLabel_pohon3_2().setVisible(false);
        bermain1.getLabel_pohon4_2().setVisible(false);
        bermain1.getLabel_jmlUang().setText(Integer.toString(uang));

        bermain1.KembaliMouseListener(new KembaliBermainMouseListener());
        bermain1.kotak1MouseListener(new kotak1Listener());
        bermain1.kotak2MouseListener(new kotak2Listener());
        bermain1.kotak3MouseListener(new kotak3Listener());
        bermain1.kotak4MouseListener(new kotak4Listener());
        bermain1.pupukMouseListener(new pupukListener());
        bermain1.airMouseListener(new airListener());
        bermain1.tasMouseListener(new tasListener());
        bermain1.ShopMouseListener(new ShopListener());
        bermain1.Pohon1_2MouseListener(new Pohon1_2Lvl1Listener());
        bermain1.Pohon2_2MouseListener(new Pohon2_2Lvl1Listener());
        bermain1.Pohon3_2MouseListener(new Pohon3_2Lvl1Listener());
        bermain1.Pohon4_2MouseListener(new Pohon4_2Lvl1Listener());
        bermain1.Pohon1MouseListener(new Pohon1Lvl1Listener());
        bermain1.Pohon2MouseListener(new Pohon2Lvl1Listener());
        bermain1.Pohon3MouseListener(new Pohon3Lvl1Listener());
        bermain1.Pohon4MouseListener(new Pohon4Lvl1Listener());
        bermain1.Tanah1MouseListener(new Tanah1Lvl1Listener());
        bermain1.Tanah2MouseListener(new Tanah2Lvl1Listener());
        bermain1.Tanah3MouseListener(new Tanah3Lvl1Listener());
        bermain1.Tanah4MouseListener(new Tanah4Lvl1Listener());

        dialogAsset = new PopUpAssetView(bermain1, true);
        dialogAsset.CloseMouseListener(new CloseListener());
        dialogAsset.PohonJatiMouseListener(new pohonjatiListener());
        dialogAsset.PohonCemaraMouseListener(new pohonCemaraListener());
        dialogAsset.PohonKapurMouseListener(new pohonKapurListener());
        dialogAsset.PohonKayuBesiMouseListener(new pohonKayuBesiListener());
        dialogAsset.PohonKayuHitamMouseListener(new pohonKayuHitamListener());
        dialogAsset.PohonPilangMouseListener(new pohonPilangListener());
        dialogAsset.PohonPinusMouseListener(new pohonPinusListener());
        dialogAsset.PohonKaretMouseListener(new pohonKaretListener());

        dialogToko = new PopUpShopView(bermain1, true);
        dialogToko.getDynamicPanel().setLayout(layout);
        dialogToko.getDynamicPanel().add(tokoAir);
        dialogToko.getDynamicPanel().add(tokoPupuk);
        dialogToko.getDynamicPanel().add(tokoBibit);
        dialogToko.getDynamicPanel().setVisible(false);
        dialogToko.AirMouseListener(new AirTokoListener());
        dialogToko.PupukMouseListener(new PupukTokoListener());
        dialogToko.BibitMouseListener(new BibitTokoListener());
        dialogToko.CloseMouseListener(new CloseTokoListener());
        tokoAir.BeliMouseListener(new BeliAirListener());
        tokoAir.KurangMouseListener(new KurangJmlAirListener());
        tokoAir.TambahMouseListener(new TambahJmlAirListener());
        tokoPupuk.BeliMouseListener(new BeliPupukListener());
        tokoPupuk.KurangMouseListener(new KurangJmlPupukListener());
        tokoPupuk.TambahMouseListener(new TambahJmlPupukListener());
        tokoBibit.JatiMouseListener(new JatiTokoListener());
        tokoBibit.CemaraMouseListener(new CemaraTokoListener());
        tokoBibit.KapurMouseListener(new KapurTokoListener());
        tokoBibit.KaretMouseListener(new KaretTokoListener());
        tokoBibit.KayuBesiMouseListener(new KayuBesiTokoListener());
        tokoBibit.KayuHitamMouseListener(new KayuHitamTokoListener());
        tokoBibit.PilangMouseListener(new PilangTokoListener());
        tokoBibit.PinusMouseListener(new PinusTokoListener());

        dialogUangKurang = new PopUpUangKurangView(bermain1, true);
        dialogUangKurang.TutupMouseListener(new TutupUangKurang());
    }

    private void beliBibit(int pohon) {
        if (pohon == 0) {
            if (uang >= 35) {
                bibit[0] += 1;
                uang -= 35;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonKaret().setText(Integer.toString(bibit[0]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 1) {
            if (uang >= 40) {
                bibit[1] += 1;
                uang -= 40;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonPilang().setText(Integer.toString(bibit[1]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 2) {
            if (uang >= 45) {
                bibit[2] += 1;
                uang -= 45;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonCemara().setText(Integer.toString(bibit[2]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 3) {
            if (uang >= 50) {
                bibit[3] += 1;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonKapur().setText(Integer.toString(bibit[3]));
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 4) {
            if (uang >= 55) {
                bibit[4] += 1;
                uang -= 55;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonPinus().setText(Integer.toString(bibit[4]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 5) {
            if (uang >= 60) {
                bibit[5] += 1;
                uang -= 60;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonKayuHitam().setText(Integer.toString(bibit[5]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 6) {
            if (uang >= 80) {
                bibit[6] += 1;
                uang -= 80;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonKayuBesi().setText(Integer.toString(bibit[6]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        } else if (pohon == 7) {
            if (uang >= 75) {
                bibit[7] += 1;
                uang -= 75;
                bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
                dialogAsset.getLabel_jmlPohonJati().setText(Integer.toString(bibit[7]));
                JOptionPane.showMessageDialog(tokoBibit, "Bibit Berhasil Dibeli!");
            } else {
                dialogUangKurang.setVisible(true);
            }
        }
    }

    private void beliAir() {

        if (air[1] == 0) {
            JOptionPane.showMessageDialog(tokoAir, "Jumlah Tidak Boleh Kosong");
        } else if (uang >= (hargaAir * air[1])) {
            uang -= (hargaAir * air[1]);
            air[0] += air[1];
            air[1] = 0;
            JOptionPane.showMessageDialog(tokoAir, "Berhasil Membeli Air");
            tokoAir.getLabel_jmlBeliAir().setText(Integer.toString(air[1]));
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
        } else {
            dialogUangKurang.setVisible(true);
            air[1] = 0;
            tokoAir.getLabel_jmlBeliAir().setText(Integer.toString(air[1]));
        }

    }

    private void beliPupuk() {
        if (pupuke[1] == 0) {
            JOptionPane.showMessageDialog(tokoPupuk, "Jumlah Tidak Boleh Kosong");
        } else if (uang >= (hargaPupuk * pupuke[1])) {
            uang -= (hargaPupuk * pupuke[1]);
            pupuke[0] += pupuke[1];
            pupuke[1] = 0;
            JOptionPane.showMessageDialog(tokoPupuk, "Berhasil Membeli Pupuk");
            tokoPupuk.getLabel_jmlBeliPupuk().setText(Integer.toString(pupuke[1]));
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
        } else {
            dialogUangKurang.setVisible(true);
            pupuke[1] = 0;
            tokoPupuk.getLabel_jmlBeliPupuk().setText(Integer.toString(pupuke[1]));
        }

    }

    private void siram(int lahan) {
        if (siram) {
            if (air[0] > 0) {
                System.out.println("siram");
                air[0] -= 1;
                if (lahan == 1) {
                    sekonTumbuh[0] -= 15;
                    System.out.println("waktu lahan 1 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 2) {
                    sekonTumbuh[1] -= 15;
                    System.out.println("waktu lahan 2 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 3) {
                    sekonTumbuh[2] -= 15;
                    System.out.println("waktu lahan 3 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 4) {
                    sekonTumbuh[3] -= 15;
                    System.out.println("waktu lahan 4 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 5) {
                    sekonTumbuh[4] -= 15;
                    System.out.println("waktu lahan 5 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 6) {
                    sekonTumbuh[5] -= 15;
                    System.out.println("waktu lahan 6 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 7) {
                    sekonTumbuh[6] -= 15;
                    System.out.println("waktu lahan 7 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 8) {
                    sekonTumbuh[7] -= 15;
                    System.out.println("waktu lahan 8 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 9) {
                    sekonTumbuh[8] -= 15;
                    System.out.println("waktu lahan 9 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 10) {
                    sekonTumbuh[9] -= 15;
                    System.out.println("waktu lahan 10 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 11) {
                    sekonTumbuh[10] -= 15;
                    System.out.println("waktu lahan 11 berkurang 15 detik");
                    siram = false;
                }

                if (lahan == 12) {
                    sekonTumbuh[11] -= 15;
                    System.out.println("waktu lahan 12 berkurang 15 detik");
                    siram = false;
                }
            }
        }
    }

    private void pupuk(int lahan) {
        if (pupuk) {
            if (pupuke[0] > 0) {
                System.out.println("pupuk");
                pupuke[0] -= 1;
                if (lahan == 1) {
                    sekonTumbuh[0] -= 15;
                    System.out.println("waktu lahan 1 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 2) {
                    sekonTumbuh[1] -= 15;
                    System.out.println("waktu lahan 2 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 3) {
                    sekonTumbuh[2] -= 15;
                    System.out.println("waktu lahan 3 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 4) {
                    sekonTumbuh[3] -= 15;
                    System.out.println("waktu lahan 4 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 5) {
                    sekonTumbuh[4] -= 15;
                    System.out.println("waktu lahan 5 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 6) {
                    sekonTumbuh[5] -= 15;
                    System.out.println("waktu lahan 6 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 7) {
                    sekonTumbuh[6] -= 15;
                    System.out.println("waktu lahan 7 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 8) {
                    sekonTumbuh[7] -= 15;
                    System.out.println("waktu lahan 8 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 9) {
                    sekonTumbuh[8] -= 15;
                    System.out.println("waktu lahan 9 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 10) {
                    sekonTumbuh[9] -= 15;
                    System.out.println("waktu lahan 10 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 11) {
                    sekonTumbuh[10] -= 15;
                    System.out.println("waktu lahan 11 berkurang 15 detik");
                    pupuk = false;
                }

                if (lahan == 12) {
                    sekonTumbuh[11] -= 15;
                    System.out.println("waktu lahan 12 berkurang 15 detik");
                    pupuk = false;
                }
            }
        }
    }

    private void tebang(int lahan) {

        if (bermain1.getLabel_pohon1_2().isVisible() && lahan == 1) {
            uang += 100;
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
            bermain1.getLabel_pohon1().setVisible(false);
            bermain1.getLabel_pohon1_2().setVisible(false);
            bermain1.getLabel_tanah1().setVisible(false);
            kotakAktif[0] = 0;
        }

        if (bermain1.getLabel_pohon2_2().isVisible() && lahan == 2) {
            uang += 100;
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
            bermain1.getLabel_pohon2().setVisible(false);
            bermain1.getLabel_pohon2_2().setVisible(false);
            bermain1.getLabel_tanah2().setVisible(false);
            kotakAktif[1] = 0;
        }

        if (bermain1.getLabel_pohon3_2().isVisible() && lahan == 3) {
            uang += 100;
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
            bermain1.getLabel_pohon3().setVisible(false);
            bermain1.getLabel_pohon3_2().setVisible(false);
            bermain1.getLabel_tanah3().setVisible(false);
            kotakAktif[2] = 0;
        }

        if (bermain1.getLabel_pohon4_2().isVisible() && lahan == 4) {
            uang += 100;
            bermain1.getLabel_jmlUang().setText(Integer.toString(uang));
            bermain1.getLabel_pohon4().setVisible(false);
            bermain1.getLabel_pohon4_2().setVisible(false);
            bermain1.getLabel_tanah4().setVisible(false);
            kotakAktif[3] = 0;
        }
    }

    private void setIcon(JButton button, String resource) {
        //Method untuk mengganti icon button
        button.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void setIconLabel(JLabel label, String resource) {
        label.setIcon(new ImageIcon(getClass().getResource(resource)));
    }

    private void tanam(String frame) {
        dialogAsset.getLabel_jmlPohonKaret().setText(Integer.toString(bibit[0]));
        dialogAsset.getLabel_jmlPohonPilang().setText(Integer.toString(bibit[1]));
        dialogAsset.getLabel_jmlPohonCemara().setText(Integer.toString(bibit[2]));
        dialogAsset.getLabel_jmlPohonKapur().setText(Integer.toString(bibit[3]));
        dialogAsset.getLabel_jmlPohonPinus().setText(Integer.toString(bibit[4]));
        dialogAsset.getLabel_jmlPohonKayuHitam().setText(Integer.toString(bibit[5]));
        dialogAsset.getLabel_jmlPohonKayuBesi().setText(Integer.toString(bibit[6]));
        dialogAsset.getLabel_jmlPohonJati().setText(Integer.toString(bibit[7]));
        if (frame.equalsIgnoreCase("bermain1")) {
            if (!bermain1.getLabel_tanah1().isVisible()) {
                bermain1.getLabel_tanah1().setVisible(true);
                timer("bermain1", 1);
            } else if (!bermain1.getLabel_tanah2().isVisible()) {
                bermain1.getLabel_tanah2().setVisible(true);
                timer("bermain1", 2);
            } else if (!bermain1.getLabel_tanah3().isVisible()) {
                bermain1.getLabel_tanah3().setVisible(true);
                timer("bermain1", 3);
            } else if (!bermain1.getLabel_tanah4().isVisible()) {
                bermain1.getLabel_tanah4().setVisible(true);
                timer("bermain1", 4);
            }
        }
    }

    private void timer(String frame, int lahan) {
        ActionListener gameTimer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (lahan == 1) {
                    System.out.println("sekon 1 :" + sekonTumbuh[0]);
                    sekonTumbuh[0]--;
                    if (frame.equalsIgnoreCase("bermain1")) {
                        if (sekonTumbuh[0] == 20) {
                            if (bermain1.getLabel_tanah1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2().setVisible(true);
                            }

                            if (bermain1.getLabel_tanah3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4().setVisible(true);
                            }

                        }
                        if (sekonTumbuh[0] == 0) {
                            if (bermain1.getLabel_pohon1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1_2().setVisible(true);
                                bermain1.getLabel_pohon1().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2_2().setVisible(true);
                                bermain1.getLabel_pohon2().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3_2().setVisible(true);
                                bermain1.getLabel_pohon3().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4_2().setVisible(true);
                                bermain1.getLabel_pohon4().setVisible(false);

                            }

                        }
                    }

                } else if (lahan == 2) {
                    System.out.println("sekon 2 :" + sekonTumbuh[1]);
                    sekonTumbuh[1]--;
                    if (frame.equalsIgnoreCase("bermain1")) {
                        if (sekonTumbuh[1] <= 20) {
                            if (bermain1.getLabel_tanah1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2().setVisible(true);
                            }

                            if (bermain1.getLabel_tanah3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4().setVisible(true);
                            }

                        }
                        if (sekonTumbuh[1] <= 0) {
                            if (bermain1.getLabel_pohon1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1_2().setVisible(true);
                                bermain1.getLabel_pohon1().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2_2().setVisible(true);
                                bermain1.getLabel_pohon2().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3_2().setVisible(true);
                                bermain1.getLabel_pohon3().setVisible(false);
//                           
                            }
                            if (bermain1.getLabel_pohon4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4_2().setVisible(true);
                                bermain1.getLabel_pohon4().setVisible(false);

                            }

                        }
                    }
                } else if (lahan == 3) {
                    System.out.println("sekon 3 :" + sekonTumbuh[2]);
                    sekonTumbuh[2]--;
                    if (frame.equalsIgnoreCase("bermain1")) {
                        if (sekonTumbuh[2] <= 20) {
                            if (bermain1.getLabel_tanah1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2().setVisible(true);
                            }

                            if (bermain1.getLabel_tanah3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4().setVisible(true);
                            }
//                       
                        }
                        if (sekonTumbuh[2] <= 0) {
                            if (bermain1.getLabel_pohon1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1_2().setVisible(true);
                                bermain1.getLabel_pohon1().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2_2().setVisible(true);
                                bermain1.getLabel_pohon2().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3_2().setVisible(true);
                                bermain1.getLabel_pohon3().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4_2().setVisible(true);
                                bermain1.getLabel_pohon4().setVisible(false);

                            }

                        }
                    }
                } else if (lahan == 4) {
                    System.out.println("sekon 4 :" + sekonTumbuh[3]);
                    sekonTumbuh[3]--;
                    if (frame.equalsIgnoreCase("bermain1")) {
                        if (sekonTumbuh[3] <= 20) {
                            if (bermain1.getLabel_tanah1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2().setVisible(true);
                            }

                            if (bermain1.getLabel_tanah3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3().setVisible(true);
                            }
                            if (bermain1.getLabel_tanah4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4().setVisible(true);
                            }

                        }
                        if (sekonTumbuh[3] <= 0) {
                            if (bermain1.getLabel_pohon1().isVisible() && lahan == 1) {
                                bermain1.getLabel_pohon1_2().setVisible(true);
                                bermain1.getLabel_pohon1().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon2().isVisible() && lahan == 2) {
                                bermain1.getLabel_pohon2_2().setVisible(true);
                                bermain1.getLabel_pohon2().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon3().isVisible() && lahan == 3) {
                                bermain1.getLabel_pohon3_2().setVisible(true);
                                bermain1.getLabel_pohon3().setVisible(false);

                            }
                            if (bermain1.getLabel_pohon4().isVisible() && lahan == 4) {
                                bermain1.getLabel_pohon4_2().setVisible(true);
                                bermain1.getLabel_pohon4().setVisible(false);

                            }

                        }
                    }
                }
            }

        };
        time = new Timer(1000, gameTimer);
        time.start();

    }

    public void stopTimer() {

        time.stop();

    }

    private class PinusTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(4);
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

    private class PilangTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(1);
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

    private class KayuHitamTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(5);
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

    private class KayuBesiTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(6);
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

    private class KaretTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(0);
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

    private class KapurTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(4);
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

    private class CemaraTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(3);
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

    private class JatiTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliBibit(7);
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

    private class TambahJmlPupukListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            pupuke[1] += 1;
            tokoPupuk.getLabel_jmlBeliPupuk().setText(Integer.toString(pupuke[1]));

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(tokoPupuk.getButton_tambah(), "/View/Toko/plus2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoPupuk.getButton_tambah(), "/View/Toko/plus1.png");
        }

    }

    private class KurangJmlPupukListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (pupuke[1] >= 1) {
                pupuke[1] -= 1;
                tokoPupuk.getLabel_jmlBeliPupuk().setText(Integer.toString(pupuke[1]));
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
            setIcon(tokoPupuk.getButton_kurang(), "/View/Toko/min2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoPupuk.getButton_kurang(), "/View/Toko/min1.png");
        }

    }

    private class BeliPupukListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliPupuk();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(tokoPupuk.getButton_beli(), "/View/Toko/beli_but2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoPupuk.getButton_beli(), "/View/Toko/bel_but1.png");
        }
    }

    private class TambahJmlAirListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            air[1] += 1;
            tokoAir.getLabel_jmlBeliAir().setText(Integer.toString(air[1]));
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(tokoAir.getButton_tambah(), "/View/Toko/plus2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoAir.getButton_tambah(), "/View/Toko/plus1.png");
        }
    }

    private class KurangJmlAirListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (air[1] >= 1) {
                air[1] -= 1;
                tokoAir.getLabel_jmlBeliAir().setText(Integer.toString(air[1]));
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
            setIcon(tokoAir.getButton_kurang(), "/View/Toko/min2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoAir.getButton_kurang(), "/View/Toko/min1.png");
        }
    }

    private class BeliAirListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            beliAir();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(tokoAir.getButton_beli(), "/View/Toko/beli_but2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(tokoAir.getButton_beli(), "/View/Toko/bel_but1.png");
        }
    }

    private class TutupUangKurang implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogUangKurang.dispose();
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

    private class BibitTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(dialogToko.getButton_Air(), "/View/Toko/air_unselect.png");
            setIcon(dialogToko.getButton_Pupuk(), "/View/Toko/pupuk_unselect.png");
            setIcon(dialogToko.getButton_Bibit(), "/View/Toko/bibit_select.png");
            dialogToko.getDynamicPanel().setVisible(true);
            tokoAir.setVisible(false);
            tokoPupuk.setVisible(false);
            tokoBibit.setVisible(true);
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

    private class PupukTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(dialogToko.getButton_Air(), "/View/Toko/air_unselect.png");
            setIcon(dialogToko.getButton_Pupuk(), "/View/Toko/pupuk_select.png");
            setIcon(dialogToko.getButton_Bibit(), "/View/Toko/bibit_unselect.png");
            tokoPupuk.getLabel_jmlBeliPupuk().setText(Integer.toString(pupuke[1]));
            dialogToko.getDynamicPanel().setVisible(true);
            tokoAir.setVisible(false);
            tokoPupuk.setVisible(true);
            tokoBibit.setVisible(false);
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

    private class CloseTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            dialogToko.dispose();
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

    private class AirTokoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(dialogToko.getButton_Air(), "/View/Toko/air_select.png");
            setIcon(dialogToko.getButton_Pupuk(), "/View/Toko/pupuk_unselect.png");
            setIcon(dialogToko.getButton_Bibit(), "/View/Toko/bibit_unselect.png");
            dialogToko.getDynamicPanel().setVisible(true);
            tokoAir.setVisible(true);
            tokoPupuk.setVisible(false);
            tokoBibit.setVisible(false);
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

    private class Tanah4Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(4);
            pupuk(4);
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

    private class Tanah3Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(3);
            pupuk(3);
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

    private class Tanah2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(2);
            pupuk(2);
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

    private class Tanah1Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(1);
            pupuk(2);
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

    private class Pohon4Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(4);
            pupuk(4);
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

    private class Pohon3Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(3);
            pupuk(3);
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

    private class Pohon2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(2);
            pupuk(2);
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

    private class Pohon1Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram(1);
            pupuk(1);
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

    private class Pohon4_2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tebang(4);
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

    private class Pohon3_2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tebang(3);
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

    private class Pohon2_2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tebang(2);
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

    private class Pohon1_2Lvl1Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            tebang(1);
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

    private class ShopListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setIcon(dialogToko.getButton_Air(), "/View/Toko/air_select.png");
            tokoAir.getLabel_jmlBeliAir().setText(Integer.toString(air[1]));
            dialogToko.getDynamicPanel().setVisible(true);
            tokoAir.setVisible(true);
            tokoBibit.setVisible(false);
            tokoPupuk.setVisible(false);
            dialogToko.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(bermain1.getButton_Shop(), "/View/Lahan/shop2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain1.getButton_Shop(), "/View/Lahan/shop1.png");
        }
    }

    private class pohonKaretListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[0] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[0] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_karet1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_karet3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[0] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_karet1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_karet3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[1] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_karet1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_karet3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 40;
                        System.out.println("lama");
                    } else {
                        sekonTumbuh[2] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_karet1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_karet3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[3] = 40;
                    } else {
                        sekonTumbuh[3] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonPinusListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[4] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[4] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_pinus1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_pinus3.png");
                    if (hutan == 1) {
                        sekonTumbuh[0] = 120;
                        System.out.println("lama");
                    } else {

                        System.out.println("bentar");
                        sekonTumbuh[0] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_pinus1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_pinus3.png");
                    if (hutan == 1) {
                        sekonTumbuh[1] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_pinus1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_pinus3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[2] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_pinus1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_pinus3.png");
                    if (hutan == 1) {
                        sekonTumbuh[3] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[3] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }

                dialogAsset.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e
        ) {
        }

        @Override
        public void mouseReleased(MouseEvent e
        ) {
        }

        @Override
        public void mouseEntered(MouseEvent e
        ) {
        }

        @Override
        public void mouseExited(MouseEvent e
        ) {
        }
    }

    private class pohonPilangListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[1] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[1] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_pilang1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_pilang3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[0] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_pilang1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_pilang3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[1] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_pilang1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_pilang3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 40;
                        System.out.println("lama");
                    } else {
                        sekonTumbuh[2] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_pilang1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_pilang3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[3] = 40;
                    } else {
                        sekonTumbuh[3] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonKayuHitamListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[5] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[5] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_kayu_hitam1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_kayu_hitam3.png");
                    if (hutan == 1) {
                        sekonTumbuh[0] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_kayu_hitam1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_kayu_hitam3.png");
                    if (hutan == 1) {
                        sekonTumbuh[1] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_kayu_hitam1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_kayu_hitam3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[2] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_kayu_hitam1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_kayu_hitam3.png");
                    if (hutan == 1) {
                        sekonTumbuh[3] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[3] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e
        ) {
        }

        @Override
        public void mouseReleased(MouseEvent e
        ) {
        }

        @Override
        public void mouseEntered(MouseEvent e
        ) {
        }

        @Override
        public void mouseExited(MouseEvent e
        ) {
        }
    }

    private class pohonKayuBesiListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[6] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[6] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_kayu_besi1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_kayu_besi3.png");
                    if (hutan == 1) {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 40;
                    } else {
                        System.out.println("lama");
                        sekonTumbuh[0] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_kayu_besi1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_kayu_besi3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[1] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_kayu_besi1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_kayu_besi3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 40;
                        System.out.println("lama");
                    } else {
                        sekonTumbuh[2] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_kayu_besi1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_kayu_besi3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[3] = 40;
                    } else {
                        sekonTumbuh[3] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonKapurListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[3] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[3] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_kapur1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        sekonTumbuh[0] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_kapur1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        sekonTumbuh[1] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_kapur1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[2] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_kapur1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        sekonTumbuh[3] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[3] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonCemaraListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[2] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[2] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_cemara1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[0] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_cemara1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[1] = 40;
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 120;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_cemara1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 40;
                        System.out.println("lama");
                    } else {
                        sekonTumbuh[2] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_cemara1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_kapur3.png");
                    if (hutan == 1) {
                        System.out.println("lama");
                        sekonTumbuh[3] = 40;
                    } else {
                        sekonTumbuh[3] = 120;
                        System.out.println("bentar");
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }
                dialogAsset.dispose();
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
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class pohonjatiListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (bibit[7] < 1) {
                JOptionPane.showMessageDialog(dialogAsset, "Bibit Tidak Cukup!!");
            } else {
                bibit[7] -= 1;
                if (kotakAktif[0] == 0) {
                    setIconLabel(bermain1.getLabel_pohon1(), "/View/Pertumbuhan/pohon_jati1.png");
                    setIconLabel(bermain1.getLabel_pohon1_2(), "/View/Pertumbuhan/pohon_jati3.png");
                    if (hutan == 1) {
                        sekonTumbuh[0] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[0] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[0] = 1;
                } else if (kotakAktif[1] == 0) {
                    setIconLabel(bermain1.getLabel_pohon2(), "/View/Pertumbuhan/pohon_jati1.png");
                    setIconLabel(bermain1.getLabel_pohon2_2(), "/View/Pertumbuhan/pohon_jati3.png");
                    if (hutan == 1) {
                        sekonTumbuh[1] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[1] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[1] = 1;
                } else if (kotakAktif[2] == 0) {
                    setIconLabel(bermain1.getLabel_pohon3(), "/View/Pertumbuhan/pohon_jati1.png");
                    setIconLabel(bermain1.getLabel_pohon3_2(), "/View/Pertumbuhan/pohon_jati3.png");
                    if (hutan == 1) {
                        sekonTumbuh[2] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[2] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[2] = 1;
                } else if (kotakAktif[3] == 0) {
                    setIconLabel(bermain1.getLabel_pohon4(), "/View/Pertumbuhan/pohon_jati1.png");
                    setIconLabel(bermain1.getLabel_pohon4_2(), "/View/Pertumbuhan/pohon_jati3.png");
                    if (hutan == 1) {
                        sekonTumbuh[3] = 120;
                        System.out.println("lama");
                    } else {
                        System.out.println("bentar");
                        sekonTumbuh[3] = 40;
                    }
                    tanam("bermain1");
                    kotakAktif[3] = 1;
                } else {
                    JOptionPane.showMessageDialog(dialogAsset, "Lahan Penuh");
                }

                dialogAsset.dispose();
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
            dialogAsset.getLabel_jmlPohonKaret().setText(Integer.toString(bibit[0]));
            dialogAsset.getLabel_jmlPohonPilang().setText(Integer.toString(bibit[1]));
            dialogAsset.getLabel_jmlPohonCemara().setText(Integer.toString(bibit[2]));
            dialogAsset.getLabel_jmlPohonKapur().setText(Integer.toString(bibit[3]));
            dialogAsset.getLabel_jmlPohonPinus().setText(Integer.toString(bibit[4]));
            dialogAsset.getLabel_jmlPohonKayuHitam().setText(Integer.toString(bibit[5]));
            dialogAsset.getLabel_jmlPohonKayuBesi().setText(Integer.toString(bibit[6]));
            dialogAsset.getLabel_jmlPohonJati().setText(Integer.toString(bibit[7]));
            setIcon(bermain1.getButton_tas(), "/View/Lahan/tas2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain1.getButton_tas(), "/View/Lahan/tas.png");
        }
    }

    private class airListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            siram = true;
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setIcon(bermain1.getButton_air(), "/View/Lahan/alat_siram2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain1.getButton_air(), "/View/Lahan/alat_siram1.png");
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
            setIcon(dialogAsset.getButton_close(), "/View/Lahan/back-02.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(dialogAsset.getButton_close(), "/View/Lahan/back-01.png");
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
            setIcon(bermain1.getButton_pupuk(), "/View/Lahan/pupuk2.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain1.getButton_pupuk(), "/View/Lahan/pupuk1.png");
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
                stopTimer();
                bermain1.dispose();
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
            setIcon(bermain1.getButton_kembali(), "/View/Lahan/back-02.png");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setIcon(bermain1.getButton_kembali(), "/View/Lahan/back-01.png");
        }
    }

    private class YaMulaiMouseListenner implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            try {
                new UserController(bermain1, userM);
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
            if (hutan == 0) {
                JOptionPane.showMessageDialog(mulai, "Silahkan Pilih hutan!!");
            } else {
                System.out.println("hutan= :" + hutan);
                dialogPilihHutan.setVisible(true);
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
            hutan = 1;

            System.out.println("hutan hujan :" + hutan);
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
            hutan = 2;

            System.out.println("hutan hujan :" + hutan);
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
