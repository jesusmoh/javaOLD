/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.inject.Named;

/**
 *
 * @author JOrtiz
 */

@Named
public class ServiceChild {

    private String sms;

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public ServiceChild() {
         this.sms = "Hellos people";
    }

    
}
