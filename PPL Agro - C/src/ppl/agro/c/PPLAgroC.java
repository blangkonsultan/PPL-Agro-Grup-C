package ppl.agro.c;

import Controller.UserController;
import Model.UserModel;
import View.AwalView;
import View.MulaiView;
import View.PopUpKeluarView;

public class PPLAgroC {

    public static void main(String[] args) {
        AwalView awal = new AwalView();
        MulaiView mulai = new MulaiView();
        UserModel userM = new UserModel();
        new UserController(awal, userM);


    }

}
