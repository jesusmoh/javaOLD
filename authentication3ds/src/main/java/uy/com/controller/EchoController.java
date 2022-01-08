/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.controller;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jesus
 */
@RestController
public class EchoController {

   final static Logger log = Logger.getLogger(EchoController.class.getName());    

    @RequestMapping(value = "/echo", method = RequestMethod.GET,produces = "application/json")
    public String get() {
        log.info("doing echo");
        return "ok";
    }

}
