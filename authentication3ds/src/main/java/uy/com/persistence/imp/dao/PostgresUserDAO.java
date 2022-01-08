/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.persistence.imp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import uy.com.entities.User;

/**
 *
 * @author jesus
 */
@Component
public class PostgresUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long id) {
        User r = null;
        r = entityManager.find(User.class, id);
        return r;
    }
    
    public User save(User user) {
        User r = null;
        r = entityManager.merge(user);
        return r;
    }


}
