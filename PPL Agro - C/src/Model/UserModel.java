/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controller.UserController;

public class UserModel {

    public Koneksi koneksi;
    private int result = 0;
    UserController uc;

    public UserModel() throws SQLException {
        koneksi = new Koneksi("hutanku", "root", "");
    }

    public void tambahUser(String username) throws SQLException {
        try {
            String query = "INSERT INTO `pemain` (`idPemain`, `namaPemain`, "
                    + "`level1`, `level2`, `level3`, `level4`, `level5`, "
                    + "`pupuk`, `siram`, `karet`, `pilang`, `cemara`, `kapur`, "
                    + "`pinus`, `kayuhitam`, `jati`, `kayubesi`, `uang`) VALUES "
                    + "(NULL, '" + username + "', 'true', 'false', 'false', 'false', 'false', "
                    + "'2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '0');";
            System.out.println(query);
            koneksi.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void reset(String username) {
        try {
            String query = "UPDATE `pemain` SET `level1`='true',`level2`='false',"
                    + "`level3`='false',`level4`='false',`level5`='false',"
                    + "`pupuk`=2, `siram`=2, `karet`=1,"
                    + "`pilang`=1, `cemara`=1,`kapur`=1,"
                    + "`pinus`=1,`kayuhitam`=1,`jati`=1,"
                    + "`kayubesi`=1,`uang`=0 WHERE namaPemain = '" + username + "'";
            System.out.println(query);
            koneksi.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int cocokan(String username) throws SQLException {
        String query = "SELECT * FROM pemain WHERE namaPemain='"
                + username + "'";
        ResultSet rs = koneksi.getResult(query);
        rs.last();
        result = rs.getRow();
        System.out.println(result);
        if (rs.getRow() == 1) {
            if (username.equals(rs.getString("namapemain"))) {
                String query2 = "SELECT * FROM pemain WHERE idPemain="
                        + rs.getString("idPemain");
                ResultSet rs2 = koneksi.getResult(query2);
                rs2.next();
                uc.bibit[0] = rs2.getInt("karet");
                uc.bibit[1] = rs2.getInt("pilang");
                uc.bibit[2] = rs2.getInt("cemara");
                uc.bibit[3] = rs2.getInt("kapur");
                uc.bibit[4] = rs2.getInt("pinus");
                uc.bibit[5] = rs2.getInt("kayuhitam");
                uc.bibit[6] = rs2.getInt("jati");
                uc.bibit[7] = rs2.getInt("kayubesi");
                uc.level[0] = rs2.getBoolean("level1");
                uc.level[1] = rs2.getBoolean("level2");
                uc.level[2] = rs2.getBoolean("level3");
                uc.level[3] = rs2.getBoolean("level4");
                uc.level[4] = rs2.getBoolean("level5");
                uc.pupuke[0] = rs2.getInt("pupuk");
                uc.air[0] = rs2.getInt("siram");
                uc.uang = rs2.getInt("uang");
                return 1;
            } else {
                return 0;
            }
        } else {
            tambahUser(username);
            return 0;
        }
    }

    public void updatebibit(String username) {
        try {
            String query = "UPDATE `pemain` SET `karet`=" + uc.bibit[0] + ",`pilang`=" + uc.bibit[1] + ","
                    + "`cemara`=" + uc.bibit[2] + ",`kapur`=" + uc.bibit[3] + ","
                    + "`pinus`=" + uc.bibit[4] + ",`kayuhitam`=" + uc.bibit[5] + ",`jati`=" + uc.bibit[6] + ","
                    + "`kayubesi`=" + uc.bibit[7] + " = WHERE namapemain = '" + username + "'";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateuang(String username) {
        try {
            String query = "UPDATE `pemain` SET `uang`=" + uc.uang + " WHERE namaPemain = '" + username + "'";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatelevel(String username) {
        try {
            String query = "UPDATE `pemain` SET `level1`='" + uc.level[0] + "',`level2`='" + uc.level[1] + "',"
                    + "`level3`='" + uc.level[2] + "',`level4`='" + uc.level[3] + "',`level5`='" + uc.level[4] + "' "
                    + "WHERE namaPemain = ''";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatepupukair(String username) {
        try {
            String query = "UPDATE `pemain` SET `pupuk`= " + uc.pupuke[0] + ",`"
                    + "siram`=" + uc.air[0] + " WHERE namaPemain = ''";
            System.out.println(query);
            koneksi.execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getResult() {
        return result;
    }
}
