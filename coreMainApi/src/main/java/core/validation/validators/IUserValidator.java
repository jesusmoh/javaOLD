/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.validation.validators;

import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;

/**
 *
 * @author jesus
 */
public interface IUserValidator {
    
    public void validator(SignInUserRequestDTO dto);
    
    public void validator(SignUpUserRequestDTO dto);

    public void validator(UserResquestDTO dto);
}
