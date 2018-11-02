/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    public Koneksi koneksi;
    private int result = 0;
    private static String idPemain;

    public UserModel() throws SQLException {
        koneksi = new Koneksi("hutanku", "root", "");
    }

    public void tambahUser(String username) throws SQLException {
        try {
            String query = "INSERT INTO `pemain`(`idPemain`, `namaPemain`, `nilai`) "
                    + "VALUES (default,'" + username + "',0)";
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
        if (rs.getRow() == 1) {
            if (username.equals(rs.getString("username"))) {
                String query2 = "SELECT * FROM pemain WHERE idPemain="
                        + rs.getString("idPemain");
                ResultSet rs2 = koneksi.getResult(query2);
                rs2.next();
                idPemain = rs2.getString("idPemain");
                System.out.println(idPemain);
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    protected static String getUser() {
        return idPemain;
    }
}
