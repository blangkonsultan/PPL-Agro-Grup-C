package ppl.agro.c;

import Controller.UserController;
import Model.UserModel;
import View.AwalView;
import View.Bermain1View;
import View.MulaiView;
import View.PopUpKeluarView;
import java.sql.SQLException;

public class PPLAgroC {

    public static void main(String[] args) throws SQLException {
        AwalView awal = new AwalView();
        Bermain1View bermain = new Bermain1View();
        MulaiView mulai = new MulaiView();
        UserModel userM = new UserModel();
        new UserController(mulai, userM);

    }

}
