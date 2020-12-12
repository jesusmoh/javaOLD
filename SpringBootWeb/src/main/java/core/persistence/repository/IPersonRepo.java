/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence.repository;

import core.model.entities.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JOrtiz
 */
@Qualifier("mailService")
public interface IPersonRepo extends JpaRepository<Person, Integer>{
    
    
}
