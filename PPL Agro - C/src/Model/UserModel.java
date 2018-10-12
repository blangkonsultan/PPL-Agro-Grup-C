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
}
