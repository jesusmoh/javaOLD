/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.persistence;

import org.springframework.transaction.annotation.Transactional;
import uy.com.entities.User;

/**
 *
 * @author jesus
 */

public interface IUsersRepository  {
    
    @Transactional(readOnly=true)
    User findById(Long id);
    
    @Transactional
    User save(User user);
}
