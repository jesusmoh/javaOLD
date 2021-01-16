/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.model.entities.Quality;
import core.model.entities.User;
import core.persistence.QualityFacadeDAO;
import core.persistence.UserFacadeDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author JOrtiz
 */
@Named(value = "dataService")
@ApplicationScoped
public class DataServiceImpl implements DataService {

    @EJB
    private QualityFacadeDAO qualityFacadeDAO;
    @EJB
    private UserFacadeDAO userFacadeDAO;

    public DataServiceImpl() {
    }

    @Override
    @Transactional
    public User createUser(String name, String username, String password, String group) {
        User u = new User();
        u.setName(name);
        u.setPassword(password);
        u.setUsergroup(group);
        u.setUsername(username);
        userFacadeDAO.create(u);
        return userFacadeDAO.find(u.getId());
    }

    @Override
    @Transactional
    public Quality createQuality(String desString, User user) {

        Quality q = new Quality();
        q.setUser(user);
        q.setDescription(desString);
        qualityFacadeDAO.create(q);
        return qualityFacadeDAO.find(q.getId());

    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userFacadeDAO.findAll();
    }

    @Transactional
    @Override
    public User findUser(String username) {
        return userFacadeDAO.findUserByName(username);
    }
    
    @Transactional

    @Override
    public List<Quality> getQualities(String username) {
        return qualityFacadeDAO.getQualitiesByUserName(username);
    }
    
}
