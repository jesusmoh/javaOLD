/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.dto.request;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author jesus
 */
@Data

public class RequestUserDTO implements Serializable{
    
    static final long serialVersionUID = 1L;
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
 
}
