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
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

/**
 *
 * @author JOrtiz
 */
@Named(value = "dataSecureUserService")
@ApplicationScoped
public class DataSecureUserServiceImpl implements DataSecureUserService {

    @EJB
    private QualityFacadeDAO qualityFacadeDAO;
    @EJB
    private UserFacadeDAO userFacadeDAO;
    @Inject
    Pbkdf2PasswordHash passwordHash;
    
    
    public DataSecureUserServiceImpl() {
    }

    @Override
    @Transactional
    public User createUser(String name,  String username,String password, String group) {
        User u = new User();
        u.setName(name);
        u.setPassword(passwordHash.generate(password.toCharArray()));
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
    public List<Quality> getQualities(String userId) {
        return qualityFacadeDAO.getQualitiesByUserName(userId);
    }
    
}
