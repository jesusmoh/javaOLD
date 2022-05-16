package core.controller.rest.user;

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
import core.dto.response.ValidApiObjetcDTO;
import core.exception.CustomException;
import core.service.IUserService;
import core.validation.validators.IUserValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UserController {

    private final IUserService userService;

    @Autowired
    private IUserValidator userValidator;

//LOGIN 
    @PostMapping("/signin")
    public TokenDTO login(@RequestBody SignInUserRequestDTO dto) {
        return userService.signin(dto);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpUserRequestDTO dto) {
        ResponseEntity responseEntity = null;
        ValidApiObjetcDTO v = userValidator.validator(dto);
        if (v.isValid()) {
            TokenDTO tokenDTO = userService.signup(dto);
            responseEntity = new ResponseEntity(tokenDTO, HttpStatus.CREATED);
        } else {
            throw new CustomException(v.getMessages(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return responseEntity;
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

//CRUD
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO create(@RequestBody UserResquestDTO dto) {
        userValidator.validator(dto);
        return userService.save(dto);
    }

    @PutMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO update(@RequestBody UserResquestDTO dto) {
        userValidator.validator(dto);
        return userService.update(dto);
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO delete(@PathVariable String username) {
        return userService.delete(username);
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDTO search(@PathVariable String username) {
        return userService.search(username);
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public UserResponseDTO whoami(HttpServletRequest req) {
        return userService.whoami(req);
    }

//REMOTE VALIDATION
    @PostMapping(value = "/validate/{field}")
    public ValidApiObjetcDTO validateUsername(@PathVariable String field, @RequestBody String fieldValue) {

        ValidApiObjetcDTO dto = userValidator.fieldValidator(field, fieldValue);
        return dto;
    }

//PAGINATION 
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserResponseDTO> allUsers() {
        return userService.allUsers();
    }

}
