/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Bermain2View;

/**
 *
 * @author Wahib
 */
public class LevelDua {
    
    Bermain2View bv;
    
    public LevelDua(Bermain2View b2v, int point){
        this.bv = new Bermain2View();
        this.bv = b2v;
        
        bv.setVisible(true);
        System.out.println(point);
    }
    
}
