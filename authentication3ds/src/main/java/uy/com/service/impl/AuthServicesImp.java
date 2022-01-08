/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.dto.response.JWTResponseDTO;
import uy.com.dto.response.ResponseUserDTO;
import uy.com.exceptions.ApiNotFoundEntity;
import uy.com.exceptions.ApiUnprocessableEntity;
import uy.com.security.JwtIO;
import uy.com.service.IAuthService;
import uy.com.service.IUserService;
import uy.com.util.DateUtil;

/**
 *
 * @author jesus
 */
@Service
public class AuthServicesImp implements IAuthService{

    @Autowired
    private JwtIO jwtIO;
    
    @Autowired
    private DateUtil dateUtil;
    
    @Autowired
    IUserService userService;
     
    @Override
    public JWTResponseDTO login(String clientId,String clientSecret) {
       
        ResponseUserDTO responseUserDTO=null;
        try {
            responseUserDTO = userService.login(Long.valueOf(clientId),clientSecret);
        } catch (ApiUnprocessableEntity ex) {
           //throw new ApiUnprocessableEntity(ex.getMessage());
            System.out.println("yy");
        } catch (ApiNotFoundEntity ex) {
           System.out.println("yy");
        }
        
        JWTResponseDTO jWTResponseDTO;
        jWTResponseDTO = JWTResponseDTO.builder()
        .tokenType("bearer")
        .accessToken(jwtIO.generateToken(responseUserDTO))    
        .issuedAt(String.valueOf(dateUtil.getDateMillis()))
        .clientId(clientId)
        .expiresIn(jwtIO.getEXPIRES_IN())
        .build();
        
        return jWTResponseDTO;
    }
    
}
