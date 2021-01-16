/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence;

import core.model.entities.Quality;
import core.model.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JOrtiz
 */
@Stateless
public class QualityFacadeDAO extends AbstractFacade<Quality> {

    @PersistenceContext(unitName = "webAppSecureJSF_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QualityFacadeDAO() {
        super(Quality.class);
    }
    
    
     public List<Quality> getQualitiesByUserName(String name) {
        List<Quality> list = null;
        try {
            Query query = em.createNativeQuery("SELECT * FROM app_users INNER JOIN app_qualities ON app_qualities.user_id=app_users.id WHERE app_users.name='"+name+"';",Quality.class);
            list = query.getResultList();

        } catch (Exception ex) {
            return  null;
        }
        return  list;
    }
}
