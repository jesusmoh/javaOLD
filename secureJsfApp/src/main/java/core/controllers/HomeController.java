/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers;

import core.model.entities.Quality;
import core.model.entities.User;
import core.services.DataService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author JOrtiz
 */
@Named(value = "homeController")
@RequestScoped
public class HomeController {

    @Inject
    DataService dataService;
 
    public HomeController() {
    }
    
    private User currentUser;
    private List<Quality> currentQualities;
    
    @PostConstruct
    public void initialize(){
       String username="";
       this.currentUser= dataService.findUser(username);
       if(this.currentUser!=null)
       {
        this.currentQualities=dataService.getQualities(username);
       }
    }
    
    public User getCurrentUser()
    {
      return this.currentUser;
    }

    public List<Quality> getCurrentQualities() {
        return currentQualities;
    }
    
    
}
