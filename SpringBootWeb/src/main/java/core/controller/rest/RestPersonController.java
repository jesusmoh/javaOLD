/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller.rest;

import core.model.entities.Person;
import core.model.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JOrtiz
 */
@RestController
@RequestMapping("/wspersons")
public class RestPersonController {
    
    @Autowired
    private IPersonService ipersonService;
    
    @GetMapping
    public List<Person> listAll(){
      return ipersonService.listAll();
    }
}
