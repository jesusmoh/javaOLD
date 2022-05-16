/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.validation.validators.impl;

import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.ValidApiObjetcDTO;
import core.validation.validators.IUserValidator;
import org.springframework.beans.factory.annotation.Value;
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
    public ValidApiObjetcDTO validator(SignInUserRequestDTO dto) {

        ValidApiObjetcDTO r = new ValidApiObjetcDTO();
        if (!isUserNameValid(dto.getUsername())) {
            r.setMessages(validatorUserNameMessages);
            r.setValid(false);
        }
        return r;
    }

    @Override
    public ValidApiObjetcDTO validator(SignUpUserRequestDTO dto) {
        ValidApiObjetcDTO r = new ValidApiObjetcDTO();

        if (!isUserNameValid(dto.getUsername())) {
            r.setMessages(validatorUserNameMessages);
            r.setValid(false);
        }
        if (!isFirstNameValid(dto.getFirstname())) {
            r.setMessages(validatorFirstNameMessages);
            r.setValid(false);
        }
        if (!isLastNameValid(dto.getLastname())) {
            r.setMessages(validatorLastNameMessages);
            r.setValid(false);
        }
        if (!isPinValid(dto.getPin())) {
            r.setMessages(validatorApiPinMessages);
            r.setValid(false);
        }
        if (!isEmailValid(dto.getEmail())) {
            r.setMessages(validatorApiEmailMessages);
            r.setValid(false);
        }

        return r;
    }

    @Override
    public ValidApiObjetcDTO validator(UserResquestDTO dto) {

        ValidApiObjetcDTO r = new ValidApiObjetcDTO();

        if (!isUserNameValid(dto.getUsername())) {
            r.setMessages(validatorUserNameMessages);
            r.setValid(false);
        }
        if (!isFirstNameValid(dto.getFirstname())) {
            r.setMessages(validatorFirstNameMessages);
            r.setValid(false);
        }
        if (!isLastNameValid(dto.getLastname())) {
            r.setMessages(validatorLastNameMessages);
            r.setValid(false);
        }
        if (!isPinValid(dto.getPin())) {
            r.setMessages(validatorApiPinMessages);
            r.setValid(false);
        }
        if (!isEmailValid(dto.getEmail())) {
            r.setMessages(validatorApiEmailMessages);
            r.setValid(false);
        }
        return r;
    }

    @Override
    public ValidApiObjetcDTO fieldValidator(String fieldName, String fieldValue) {

        ValidApiObjetcDTO dto = new ValidApiObjetcDTO();

        switch (fieldName) {
            case "username":
                dto.setMessages(fieldName);
                dto.setValid(isUserNameValid(fieldValue));
                break;
            case "email":
                dto.setMessages(fieldName);
                dto.setValid(isEmailValid(fieldValue));
                break;
            default:
                dto.setMessages("?");
                dto.setValid(false);
                break;
        }
        return dto;
    }

}
