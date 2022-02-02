/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import javax.servlet.http.HttpServletRequest;
import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.TokenDTO;
import core.dto.response.UserResponseDTO;
import java.util.List;

public interface IUserService {

    TokenDTO signin(SignInUserRequestDTO dto);

    TokenDTO signup(SignUpUserRequestDTO dto);

    UserResponseDTO delete(String username);

    UserResponseDTO save(UserResquestDTO dto);
    
    UserResponseDTO update(UserResquestDTO dto);

    UserResponseDTO search(String username);

    UserResponseDTO whoami(HttpServletRequest req);

    String refresh(String username);
    
    List<UserResponseDTO> allUsers();
}
