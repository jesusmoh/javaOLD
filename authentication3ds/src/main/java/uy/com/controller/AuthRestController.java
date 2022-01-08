/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import uy.com.exceptions.ApiUnauthorizazed;
import uy.com.service.IAuthService;
import uy.com.validation.validators.IAuthServiceValidator;

/**
 *
 * @author jesus
 */
@RestController
@RequestMapping("/v1/authentication/")
public class AuthRestController {
    
    @Autowired
    private IAuthService authService;
    
    @Autowired
    IAuthServiceValidator authServiceValidator;
    
    @PostMapping(path = "oauth/client_credencial/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody MultiValueMap<String,String> paramMap,@RequestParam("grant_type")String grantType) throws ApiUnauthorizazed {
       
        authServiceValidator.validator(paramMap, grantType);
        
        return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));
    }
    
}
