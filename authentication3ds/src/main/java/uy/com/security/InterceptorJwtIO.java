/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.security;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import uy.com.exceptions.ApiUnauthorizazed;

/**
 *
 * @author jesus
 */
@Component
public class InterceptorJwtIO implements HandlerInterceptor {

    @Value("${jms.jwt.token.auth.path}")
    private String AUTH_PATH;
    
    @Value("#{'${jms.jwt.token.excluded.path}'.split(',')}") 
    private List<String> excluded;

    @Autowired
    private JwtIO jwtIO;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ApiUnauthorizazed   {

        boolean validate = false;
        String uri = request.getRequestURI();

        if (uri.equals(AUTH_PATH) || excluded.stream().anyMatch(x -> x.equals(uri))) {
            validate = true;
        }

        if (!validate && request.getHeader("Authorization") != null && !request.getHeader("Authorization").isEmpty()) {
            String token = request.getHeader("Authorization").replace("Bearer", "");
            validate = !jwtIO.validateToken(token.trim());
        }
        
        if(!validate)
        { 
           message("Unauthorizazed");
        }
        return true;
        
    }

    private void message(String message) throws ApiUnauthorizazed {
        throw  new ApiUnauthorizazed(message);
    }
   
}
