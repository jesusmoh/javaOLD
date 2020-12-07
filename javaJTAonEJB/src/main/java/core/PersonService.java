/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JOrtiz
 */
@Stateless
@LocalBean
public class PersonService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insert(Person personA, Person personB,Person personC) {

        em.persist(personA);
        em.persist(personB);
        em.persist(personC);
        
        //Persis all or nothing
    }

}
