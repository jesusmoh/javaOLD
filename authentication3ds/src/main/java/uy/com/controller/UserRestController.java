/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uy.com.exceptions.ApiUnprocessableEntity;
import uy.com.dto.request.RequestUserDTO;
import uy.com.dto.response.ResponseUserDTO;
import uy.com.exceptions.ApiNotFoundEntity;
import uy.com.exceptions.ApiUnprocessableUrlParameter;
import uy.com.service.IUserService;
import uy.com.validation.validators.IUserServiceValidator;

/**
 *
 * @author jesus
 */
@RestController
@RequestMapping("/v1/users")
@Validated
public class UserRestController {
    
    static final Logger log = Logger.getLogger(UserRestController.class.getName());
    
    @Autowired
    IUserService userServiceImp;
    
    @Autowired
    IUserServiceValidator userServiceValidator;
        
    @GetMapping("/{id}")
    @PostMapping(produces =MediaType.APPLICATION_JSON_VALUE )
    @Transactional(timeout = 10)
    public ResponseEntity<ResponseUserDTO> get(@PathVariable String id) throws ApiNotFoundEntity, ApiUnprocessableUrlParameter,ApiUnprocessableEntity {
        
       log.info("RequestIN ->> GET/id ");
        
        this.userServiceValidator.idValidator(id);
        
        ResponseUserDTO responseUserDTO =userServiceImp.findById(id);
         
        return ResponseEntity.ok(responseUserDTO);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    @Transactional(timeout = 10)
    public ResponseEntity<ResponseUserDTO> post(@Valid @RequestBody RequestUserDTO requestUserDTO) throws ApiUnprocessableEntity, ApiNotFoundEntity {
      
       log.info("RequestIN ->> POST ");
        
       this.userServiceValidator.validator(requestUserDTO);
        
       ResponseUserDTO responseUserDTO =userServiceImp.save(requestUserDTO);
       
       return ResponseEntity.ok(responseUserDTO);    
    }

}
