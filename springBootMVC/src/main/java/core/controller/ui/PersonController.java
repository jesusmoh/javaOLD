/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller.ui;

import core.model.entities.Person;
import core.persistence.repository.IPersonRepo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JOrtiz
 */
@Controller
public class PersonController {
    
    @Autowired
    IPersonRepo iPersonRepo;
    
    @RequestMapping("/addPerson")
    public String addPerson(Person person)
    {
        iPersonRepo.save(person);
        return "home";
    }
    
     
    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        return "home";
    }
}
