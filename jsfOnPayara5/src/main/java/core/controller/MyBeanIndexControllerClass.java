/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JOrtiz
 */

@SessionScoped
@Named("myBeanIndexControllerClass")
public class MyBeanIndexControllerClass implements Serializable {

    
    private String sms="  Hello from JSF/Payara5  ";

    public MyBeanIndexControllerClass() {
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
    

    
}
