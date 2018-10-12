package ppl.agro.c;

import Controller.UserController;
import Model.UserModel;
import View.AwalView;
import View.MulaiView;
import View.PopUpKeluarView;
import java.sql.SQLException;

public class PPLAgroC {

    public static void main(String[] args) throws SQLException {
        AwalView awal = new AwalView();
        UserModel userM = new UserModel();
        new UserController(awal,userM);


    }

}
