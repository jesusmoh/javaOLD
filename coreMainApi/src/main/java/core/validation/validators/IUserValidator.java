/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.validation.validators;

import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.ValidApiObjetcDTO;

/**
 *
 * @author jesus
 */
public interface IUserValidator {
    
    public ValidApiObjetcDTO validator(SignInUserRequestDTO dto);
    
    public ValidApiObjetcDTO validator(SignUpUserRequestDTO dto);

    public ValidApiObjetcDTO validator(UserResquestDTO dto);
    
    public ValidApiObjetcDTO fieldValidator(String fieldName, String fieldValue);
}
