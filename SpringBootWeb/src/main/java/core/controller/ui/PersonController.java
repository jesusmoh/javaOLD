/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller.ui;

import core.model.entities.Person;
import core.persistence.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author JOrtiz
 */
@Controller
public class PersonController {
    
    @Autowired
    private IPersonRepo iPersonRepo;
    
    
    @RequestMapping("/person")
    public String page(Model model) 
    {
        iPersonRepo.save(new Person());
        model.addAttribute("name", "Upps");
        return "index";
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
