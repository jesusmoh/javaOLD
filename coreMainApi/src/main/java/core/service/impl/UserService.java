package core.service.impl;

import core.commons.AppHttpMessagess;
import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.TokenDTO;
import core.dto.response.UserResponseDTO;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import core.exception.CustomException;
import core.entities.AppUser;
import core.mapper.UserMapper;
import core.security.jwt.JwtTokenProvider;
import core.persistence.IUserRepository;
import core.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public TokenDTO signin(SignInUserRequestDTO dto) {
        try {
            AppUser appUser = userRepository.findByUsername(dto.getUserName());
            if(appUser==null)
                throw new CustomException("Invalid username/password supplied", HttpStatus.UNAUTHORIZED);
            if (passwordEncoder.matches(dto.getPassword(), passwordEncoder.encode(dto.getPassword()))) 
            {
                TokenDTO tokenDTO = new TokenDTO();
                tokenDTO.setToken(jwtTokenProvider.createToken(dto.getUserName(), appUser));
                return tokenDTO;
            }
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNAUTHORIZED);
        }
        throw new CustomException("Invalid username/password supplied", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public TokenDTO signup(SignUpUserRequestDTO dto) {
        if (!userRepository.existsByUsername(dto.getUserName())) {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            AppUser appUser = userRepository.save(UserMapper.getAppUser(dto));
            String t=jwtTokenProvider.createToken(dto.getUserName(), appUser);
            TokenDTO tokenDTO=new TokenDTO();
            tokenDTO.setToken(t);
            return tokenDTO;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public UserResponseDTO delete(String username) {
        AppUser appUser = userRepository.deleteByUsername(username);
        if (appUser == null) {
            throw new CustomException(AppHttpMessagess.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return UserMapper.getUserResponseDTO(appUser);
    }

    @Override
    public UserResponseDTO save(UserResquestDTO dto) {
        if (search(dto.getUserName())!=null) {
            throw new CustomException(AppHttpMessagess.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        AppUser appUser = userRepository.save(UserMapper.getAppUser(dto));
        if (appUser == null ) {
            throw new CustomException(AppHttpMessagess.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY);
        }
       
        return UserMapper.getUserResponseDTO(appUser);
    }

    @Override
    public UserResponseDTO search(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new CustomException(AppHttpMessagess.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return UserMapper.getUserResponseDTO(appUser);
    }

    @Override
    public UserResponseDTO whoami(HttpServletRequest req) {
         AppUser appUser = userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
          if (appUser == null) {
            throw new CustomException(AppHttpMessagess.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return UserMapper.getUserResponseDTO(appUser);
    }

    @Override
    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username));
    }

    @Override
    public List<UserResponseDTO> allUsers() {
        List<UserResponseDTO> l = new ArrayList<>();
        userRepository.allUser().stream().forEach(x -> l.add(UserMapper.getUserResponseDTO(x)));
        return l;
    }

}
