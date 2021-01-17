/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers.ui;

import core.model.entities.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import core.services.DataSecureUserService;

/**
 *
 * @author JOrtiz
 */
@Named(value = "usersController")
@RequestScoped
public class UsersController {

    @Inject
    DataSecureUserService dataService;

    private List<User> allUsers;

    @PostConstruct
    public void ini() {
        allUsers = dataService.getAllUser();
    }

    public UsersController() {
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    
}
