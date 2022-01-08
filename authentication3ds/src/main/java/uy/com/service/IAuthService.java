/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.service;

import uy.com.dto.response.JWTResponseDTO;

/**
 *
 * @author jesus
 */
public interface IAuthService {
    
    public JWTResponseDTO login(String clientId,String clientSecret);
}
