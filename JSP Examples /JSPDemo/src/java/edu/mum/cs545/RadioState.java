/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

/**
 *
 * @author dipesh
 */
public class RadioState {

    private String yesCheck;
    private String noCheck;

    public RadioState() {
        yesCheck = null;
        noCheck = null;
    }
    
    

    public void setNoCheck(String noCheck) {
        this.noCheck = noCheck;
    }

    public void setYesCheck(String yesCheck) {
        this.yesCheck = yesCheck;
    }

    public String getYesCheck() {
        return yesCheck;
    }

    public String getNoCheck() {
        return noCheck;
    }

}
