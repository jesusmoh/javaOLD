/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.validation.validators.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import uy.com.exceptions.ApiUnauthorizazed;
import uy.com.validation.validators.IAuthServiceValidator;

/**
 *
 * @author jesus
 */
@Component
public class AuthServiceValidatorImpl implements IAuthServiceValidator{

    @Value("${validator.auth.messages.en}")
    private String validatorAuthMessagesEn;
    
    private static final String CLIENT_CREDENTIALS="client_credentials";
        
    @Override
    public void validator(MultiValueMap<String, String> paramMap, String granType)throws ApiUnauthorizazed{
        
        if(granType.isEmpty()||!granType.equals(CLIENT_CREDENTIALS)){
                message(validatorAuthMessagesEn);   
        }
    }
    
    private void message(String message) throws ApiUnauthorizazed {
        throw new ApiUnauthorizazed(message);
    }
    
}
