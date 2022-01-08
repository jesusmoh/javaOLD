/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.validation.validators;

import uy.com.exceptions.ApiUnprocessableEntity;
import uy.com.dto.request.RequestUserDTO;
import uy.com.exceptions.ApiUnprocessableUrlParameter;

/**
 *
 * @author jesus
 */
public interface IUserServiceValidator {
    
    void validator(RequestUserDTO requestUserDTO) throws ApiUnprocessableEntity;
    
    void idValidator(String id) throws ApiUnprocessableUrlParameter;
}
