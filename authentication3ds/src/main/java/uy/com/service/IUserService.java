/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.service;
import uy.com.dto.request.RequestUserDTO;
import uy.com.dto.response.ResponseUserDTO;
import uy.com.exceptions.ApiNotFoundEntity;
import uy.com.exceptions.ApiUnprocessableEntity;

/**
 *
 * @author jesus
 */
public interface IUserService {
    
    ResponseUserDTO findById(String id) throws ApiNotFoundEntity,ApiUnprocessableEntity;
    
    ResponseUserDTO save(RequestUserDTO requestUserDTO)throws ApiUnprocessableEntity,ApiNotFoundEntity;
    
    ResponseUserDTO login(Long id , String pass) throws ApiUnprocessableEntity,ApiNotFoundEntity;
}
