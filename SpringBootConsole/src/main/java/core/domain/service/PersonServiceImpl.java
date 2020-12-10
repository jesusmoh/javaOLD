/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import core.persistence.repositoy.IPersonRepo;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author JOrtiz
 */
@Service
public class PersonServiceImpl implements IPersonService{
    
    @Autowired
    @Qualifier("person2")
    private IPersonRepo repo;
    
    @Override
    public void addPerson(String p) {
        repo.addPerson(p);
    }
    
}
