/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.validation.validators;

import org.springframework.util.MultiValueMap;
import uy.com.exceptions.ApiUnauthorizazed;

/**
 *
 * @author jesus
 */
public interface IAuthServiceValidator {
 
    void validator(MultiValueMap<String,String> paramMap,String granType) throws ApiUnauthorizazed;
}
