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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFoundEntity extends Exception{
    
    public ApiNotFoundEntity(String message)
    {
     super(message);
    }  
    
     public ApiNotFoundEntity()
    {
     super("Not found");
    } 
}
