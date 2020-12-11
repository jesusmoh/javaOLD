/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.model.service;

import core.persistence.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author JOrtiz
 */
@Service
public class PersonServiceImpl implements IPersonService{
    
    @Autowired
    @Qualifier("personA") // OR @Qualifier("personA")
    private IPersonRepo repo;
    
    @Override
    public void addPerson(String p) {
        repo.addPerson(p);
    }
    
}
