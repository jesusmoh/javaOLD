/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JOrtiz
 */
@ManagedBean
@SessionScoped
@Named("myBeanIndexControllerClass")
public class MyBeanIndexControllerClass implements Serializable {

    
    private String sms="  Hello from JSF/TomEE  ";

    public MyBeanIndexControllerClass() {
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
    

    
}
