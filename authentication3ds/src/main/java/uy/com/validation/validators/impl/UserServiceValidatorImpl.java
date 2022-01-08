/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.validation.validators.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uy.com.exceptions.ApiUnprocessableEntity;
import uy.com.dto.request.RequestUserDTO;
import uy.com.exceptions.ApiUnprocessableUrlParameter;
import uy.com.validation.validators.IUserServiceValidator;

/**
 *
 * @author jesus
 */
@Service
public class UserServiceValidatorImpl implements IUserServiceValidator {

    @Value("${validator.user.name.regex}")
    private String validatorUserNameRegex;

    @Value("${validator.user.name.messages.en}")
    private String validatorUserNameMssagesEn;
    
    @Value("${validator.user.id.regex}")
    private String validatorUserIdRegex;

    @Value("${validator.user.id.messages.en}")
    private String validatorUserIdMssagesEn;


    @Override
    public void validator(RequestUserDTO requestUserDTO) throws ApiUnprocessableEntity {

        if (!requestUserDTO.getFirstName().matches(validatorUserNameRegex)) {
            messageApiUnprocessableEntity(validatorUserNameMssagesEn);
        }
    }
    
    @Override
    public void idValidator(String id) throws ApiUnprocessableUrlParameter {

        if (!id.matches(validatorUserIdRegex)) {
            messageApiUnprocessableUrlParameter(validatorUserIdMssagesEn);
        }
    }

    private void messageApiUnprocessableEntity(String message) throws ApiUnprocessableEntity {
        throw new ApiUnprocessableEntity(message);
    }
        
    private void messageApiUnprocessableUrlParameter(String message) throws ApiUnprocessableUrlParameter {
        throw new ApiUnprocessableUrlParameter(message);
    }

}
