/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mapper;

import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.UserResponseDTO;
import core.entities.AppUser;
import org.modelmapper.ModelMapper;

/**
 *
 * @author jesus
 */

public class UserMapper {
    
    private static final ModelMapper modelMapper= new ModelMapper();

    
    public static UserResponseDTO getUserResponseDTO( AppUser appUser)
    {
       return  modelMapper.map(appUser, UserResponseDTO.class);
    }
    
     public static AppUser getAppUser( SignUpUserRequestDTO dto)
    {
       return  modelMapper.map(dto, AppUser.class);
    }
     
       public static AppUser getAppUser( UserResquestDTO dto)
    {

       return  modelMapper.map(dto, AppUser.class);
    }
    
}
