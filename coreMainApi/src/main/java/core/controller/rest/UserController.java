package core.controller.rest;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.dto.request.SignInUserRequestDTO;
import core.dto.request.SignUpUserRequestDTO;
import core.dto.request.UserResquestDTO;
import core.dto.response.TokenDTO;
import core.dto.response.UserResponseDTO;
import core.service.IUserService;
import core.validation.validators.IUserValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final IUserService userService;
  
  @Autowired
  private IUserValidator userValidator;

//SECURITY
  
    @PostMapping("/signin")
    public TokenDTO login(@RequestBody SignInUserRequestDTO dto) {
        return userService.signin(dto);
    }

    @PostMapping("/signup")
    public TokenDTO signup(@RequestBody SignUpUserRequestDTO dto) {
        userValidator.validator(dto);
        return userService.signup(dto);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }
  
//CRUD
  
  @PostMapping("")
  public UserResponseDTO create(@RequestBody UserResquestDTO dto) {  
    userValidator.validator(dto);
    return userService.save(dto);
  }
  
  @PutMapping("")
  public UserResponseDTO update(@RequestBody UserResquestDTO dto) {  
    userValidator.validator(dto);
    return userService.save(dto);
  }

  @DeleteMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public UserResponseDTO delete(@PathVariable String username) {
    return userService.delete(username);
  }

  @GetMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public UserResponseDTO search(@PathVariable String username) {
     return  userService.search(username);
  }
  
  @GetMapping()
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<UserResponseDTO> allUsers() {
     return  userService.allUsers();
  }

  @GetMapping(value = "/me")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
  public UserResponseDTO whoami(HttpServletRequest req) {  
     return  userService.whoami(req);
  }


  

}
