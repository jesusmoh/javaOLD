/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence.repository.dao;

import core.SpringBootWebApplication;
import core.persistence.repository.IPersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JOrtiz
 */
@Repository
@Qualifier("personA")
public class PersonRepoImplSqlPostgres implements IPersonRepo {

    private static Logger LOG =LoggerFactory.getLogger(SpringBootWebApplication.class);
    
    @Override
    public void addPerson(String p) {
        LOG.info("new personA");
    }
    
}
