/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence.repositoy.dao;


import core.SpringBootConsoleApplication;
import core.persistence.repositoy.IPersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JOrtiz
 */

@Repository
@Qualifier("person1")
public class PersonRepoImpl1MySQL implements IPersonRepo{

    private static Logger LOG =LoggerFactory.getLogger(SpringBootConsoleApplication.class);
    
    @Override
    public void addPerson(String p) {
        LOG.info("NEW PERSON P1");
    }
    
}
