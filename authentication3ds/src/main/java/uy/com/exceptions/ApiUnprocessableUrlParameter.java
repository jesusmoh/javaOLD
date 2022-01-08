/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jesus
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiUnprocessableUrlParameter extends Exception{
    
    public ApiUnprocessableUrlParameter(String message)
    {
     super(message);
    }  
}
