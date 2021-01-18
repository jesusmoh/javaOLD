/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redcloud.model.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import redcloud.model.persistence.entities.WebMaCiudades;

/**
 *
 * @author jesus
 */
@Stateless
public class WebMaCiudadesFacadeDAO extends AbstractFacade<WebMaCiudades> {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebMaCiudadesFacadeDAO() {
        super(WebMaCiudades.class);
    }
    
}
