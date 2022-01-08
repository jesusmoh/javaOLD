/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author jesus
 */
@Component
public class InterceptorJwtIOConfig implements WebMvcConfigurer{
    
    @Value("${jms.jwt.security.enabled}")
    private boolean securityEnabled;
    
    @Autowired
    private InterceptorJwtIO interceptorJwtIO;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        if(securityEnabled){
          registry.addInterceptor(interceptorJwtIO);
        }
    }
    
    
}
