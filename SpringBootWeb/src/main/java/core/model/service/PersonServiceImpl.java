/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.service;

import core.model.entities.Person;
import core.persistence.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author JOrtiz
 */
@Service
public class PersonServiceImpl {

    @Autowired
    private IPersonRepo repo;

    public void save(Person p) {
        repo.save(p);
    }

}
