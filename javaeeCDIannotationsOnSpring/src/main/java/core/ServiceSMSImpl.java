/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JOrtiz
 */
@Named(value="serviceSMS")
public class ServiceSMSImpl implements ServiceSMS{
    @Inject
    ServiceChild serviceChild;

    @Override
    public String sms() {
       return serviceChild.getSms();
    }
}
