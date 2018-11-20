package ppl.agro.c;

import Controller.UserController;
import Model.UserModel;
import View.AwalView;
import View.BermainView;
import View.MulaiView;
import View.PopUpKeluarView;
import java.sql.SQLException;

public class PPLAgroC {

    public static void main(String[] args) throws SQLException {
        AwalView awal = new AwalView();
        BermainView bermain = new BermainView();
        MulaiView mulai = new MulaiView();
        UserModel userM = new UserModel();
        UserController uc = UserController.getInstance();

    }

}
