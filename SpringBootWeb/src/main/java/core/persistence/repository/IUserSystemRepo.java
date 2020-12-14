/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence.repository;

import core.model.entities.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JOrtiz
 */

public interface IUserSystemRepo extends JpaRepository<UserSystem, Integer>{
    
    UserSystem findByName(String name);
}
