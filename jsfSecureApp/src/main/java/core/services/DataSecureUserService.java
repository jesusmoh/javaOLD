/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.model.entities.Quality;
import core.model.entities.User;
import java.util.List;

/**
 *
 * @author JOrtiz
 */
public interface DataSecureUserService {
    
    public User createUser(String name, String username,String password,String group);
    
    public Quality createQuality(String desString,User user);
    
    public List<User> getAllUser();
    
    public User findUser(String username);
    
    public List<Quality> getQualities(String userId);
    
}
