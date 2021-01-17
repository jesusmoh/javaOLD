/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers.ui;

import core.model.entities.Quality;
import core.model.entities.User;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import core.services.DataSecureUserService;
import javax.faces.context.FacesContext;
import javax.security.enterprise.SecurityContext;

/**
 *
 * @author JOrtiz
 */
@Named(value = "homeController")
@RequestScoped
public class HomeController {

    @Inject
    DataSecureUserService dataService;
    
    @Inject
    SecurityContext securityContext;
    
    @Inject
    FacesContext facesContext;
    
 
    public HomeController() {
    }
    
    private User currentUser;
    private List<Quality> currentQualities;
    
    @PostConstruct
    public void initialize(){
       String username=securityContext.getCallerPrincipal().getName();
       this.currentUser= dataService.findUser(username);
       if(this.currentUser!=null)
       {
        this.currentQualities=dataService.getQualities( this.currentUser.getId().toString());
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
