/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.persistence.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uy.com.entities.User;
import uy.com.persistence.IUsersRepository;
import uy.com.persistence.imp.dao.PostgresUserDAO;

/**
 *
 * @author jesus
 */

@Repository
public class UserRepositoryImp implements IUsersRepository {

    @Autowired
    PostgresUserDAO postgresUserDAO;
       
    @Override
    @Transactional
    public User findById(Long id) {
        return postgresUserDAO.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return postgresUserDAO.save(user);
    }


}
