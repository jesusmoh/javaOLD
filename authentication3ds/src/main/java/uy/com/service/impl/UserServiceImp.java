/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.dto.request.RequestUserDTO;
import uy.com.dto.response.ResponseUserDTO;
import uy.com.entities.User;
import uy.com.exceptions.ApiNotFoundEntity;
import uy.com.exceptions.ApiUnprocessableEntity;
import uy.com.persistence.IUsersRepository;
import uy.com.service.IUserService;
import uy.com.util.BCrypt;
import uy.com.util.MHelpers;

/**
 *
 * @author jesus
 */
@Service
public class UserServiceImp  implements IUserService{

    @Autowired
    IUsersRepository iUserRepositoryImp;
    
    @Override
    public ResponseUserDTO findById(String id) throws ApiNotFoundEntity,ApiUnprocessableEntity {
        User user=null;
        user=iUserRepositoryImp.findById(Long.decode(id));
        return this.convertToResposeUserDTO(user);
    }  
    
    @Override
    public ResponseUserDTO save(RequestUserDTO requestUserDTO) throws ApiUnprocessableEntity,ApiNotFoundEntity {
        requestUserDTO.setPassword(BCrypt.hashpw(requestUserDTO.getPassword(), BCrypt.gensalt()));
        User user=iUserRepositoryImp.save(convertToUser(requestUserDTO));
        return this.convertToResposeUserDTO(user);
    }
    
    private ResponseUserDTO convertToResposeUserDTO(User user) throws ApiUnprocessableEntity, ApiNotFoundEntity {

        if (user == null) {
            throw new ApiNotFoundEntity();
        }

        try {
            ResponseUserDTO userDTO = new ResponseUserDTO();
            MHelpers.modelMapper().map(user, userDTO);
            return userDTO;
        } catch (Exception e) {
            throw new ApiUnprocessableEntity("?");
        }

    }
        
    private User convertToUser(RequestUserDTO requestUserDTO)
    {
        User user = new User();
        MHelpers.modelMapper().map(requestUserDTO, user);
        return user;
    }

    @Override
    public ResponseUserDTO login(Long id , String pass) throws ApiUnprocessableEntity,ApiNotFoundEntity {
        User user=iUserRepositoryImp.findById(id);
        
        if(BCrypt.checkpw(pass, user.getPassword()))
        {
            try {
                return this.convertToResposeUserDTO(user);
            } catch (ApiUnprocessableEntity ex) {
                throw new ApiUnprocessableEntity(ex.getMessage());
            }
        }
        return null;
        
    }
      
}
