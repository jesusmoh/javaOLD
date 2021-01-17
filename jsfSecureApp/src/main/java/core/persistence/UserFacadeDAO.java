/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.persistence;

import core.model.entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JOrtiz
 */
@Stateless
public class UserFacadeDAO extends AbstractFacade<User> {

    @PersistenceContext(unitName = "webAppSecureJSF_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacadeDAO() {
        super(User.class);
    }
    
    public User findUserByName(String name) {
        User user = new User();
        try {
            Query query = em.createNativeQuery("SELECT * FROM app_users WHERE username='"+name+"';",User.class);
            user =  (User) query.getSingleResult();

        } catch (Exception ex) {
            return  user;
        }
        return  user;
    }
    
}
