/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.dto.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author jesus
 */
@Data
public class ResponseUserDTO implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createAt;
    private Date updateAt;
    
}
