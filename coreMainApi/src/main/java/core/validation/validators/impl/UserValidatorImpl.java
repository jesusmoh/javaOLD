/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.validation.validators.impl;

import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.exception.CustomException;
import core.validation.validators.IUserValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 *
 * @author jesus
 */
@Component
public class UserValidatorImpl implements IUserValidator {

    @Value("${validator.user.name.regex}")
    private String validatorUserNameRegex;

    @Value("${validator.user.name.messages}")
    private String validatorUserNameMessages;
    

    @Override
    public void validator(SignInUserRequestDTO dto ) {
        if (!dto.getUserName().matches(validatorUserNameRegex) && !dto.getUserName().equalsIgnoreCase("admin") ) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
     @Override
    public void validator(SignUpUserRequestDTO dto ) {

        if (!dto.getUserName().matches(validatorUserNameRegex)) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void validator(UserResquestDTO dto) {
       if (!dto.getUserName().matches(validatorUserNameRegex) && !dto.getUserName().equalsIgnoreCase("admin") ) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
