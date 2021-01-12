/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import core.model.entity.UserApp;

/**
 *
 * @author JOrtiz
 */

@Repository
public interface UserAppRepository extends JpaRepository<UserApp , Long>{
    
    
}
