/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.sisnet.fenicioClient.controllers;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jesus
 */
@RestController
public class EchoController {

   final static Logger log = Logger.getLogger(ProductsController.class.getName());    

    @RequestMapping(value = "/echo", method = RequestMethod.GET,produces = "application/json")
    public String get() {
        log.info("doing echo");
        return "ok";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server error")
    public Object handleError(HttpServletRequest req, Exception ex) {
        log.severe(ex.getMessage());
        Object errorObject = new Object();
        return errorObject;
    }
    
}
