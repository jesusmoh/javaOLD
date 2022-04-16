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

    @Value("${validator.first.name.regex}")
    private String validatorFirstNameRegex;

    @Value("${validator.first.name.messages}")
    private String validatorFirstNameMessages;

    @Value("${validator.last.name.regex}")
    private String validatorLastNameRegex;

    @Value("${validator.last.name.messages}")
    private String validatorLastNameMessages;
    
    @Value("${validator.api.pin.regex}")
    private String validatorApiPinRegex;
    
    @Value("${validator.api.pin.messages}")
    private String validatorApiPinMessages;
    
    @Value("${validator.api.email.regex}")
    private String validatorApiEmailRegex;
    
    @Value("${validator.api.email.messages}")
    private String validatorApiEmailMessages;

    private boolean isUserNameValid(String userName) {
        return userName.matches(validatorUserNameRegex);
    }

    private boolean isLastNameValid(String lastName) {
        return lastName.matches(validatorLastNameRegex);
    }

    private boolean isFirstNameValid(String firstName) {
        return firstName.matches(validatorFirstNameRegex);
    }
    
    private boolean isPinValid(String pin) {
        return pin.matches(validatorApiPinRegex);
    }
    
    private boolean isEmailValid(String email) {
        return email.matches(validatorApiEmailRegex);
    }

    @Override
    public void validator(SignInUserRequestDTO dto) {
        if (!isUserNameValid(dto.getUsername())) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void validator(SignUpUserRequestDTO dto) {

        if (!isUserNameValid(dto.getUsername())) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (!isFirstNameValid(dto.getFirstname())) {
            throw new CustomException(validatorFirstNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (!isLastNameValid(dto.getLastname())) {
            throw new CustomException(validatorLastNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
          if (!isPinValid(dto.getPin())) {
            throw new CustomException(validatorApiPinMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
          if (!isEmailValid(dto.getEmail())) {
            throw new CustomException(validatorApiEmailMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void validator(UserResquestDTO dto) {
        if (!isUserNameValid(dto.getUsername())) {
            throw new CustomException(validatorUserNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (!isFirstNameValid(dto.getFirstname())) {
            throw new CustomException(validatorFirstNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (!isLastNameValid(dto.getLastname())) {
            throw new CustomException(validatorLastNameMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
          if (!isPinValid(dto.getPin())) {
            throw new CustomException(validatorApiPinMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
           if (!isEmailValid(dto.getEmail())) {
            throw new CustomException(validatorApiEmailMessages, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
