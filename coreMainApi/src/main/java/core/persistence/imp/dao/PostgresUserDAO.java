package core.persistence.imp.dao;

import core.entities.AppUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class PostgresUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public AppUser findById(Long id) {
        return  entityManager.find(AppUser.class, id);
    }
    
    public AppUser findByUserName(String userName) {
        Query query = entityManager.createQuery("SELECT a FROM AppUser a WHERE a.username = :userName", AppUser.class);
        query.setParameter("userName", userName);
        List<AppUser> results = query.getResultList();
        if (results.size() >= 1) 
            return results.get(0);
        return null;
    }
    
    public AppUser isUserDeleted(String userName) {
        Query query = entityManager.createQuery("SELECT a FROM AppUser a WHERE a.username = :userName AND a.status= :status", AppUser.class);
        query.setParameter("status", 0);
        query.setParameter("userName", userName);
        List<AppUser> results = query.getResultList();
        if (results.size() >= 1) 
            return results.get(0);
        return null;
    }
    
    public AppUser save(AppUser appUser) {
        return entityManager.merge(appUser);
    }
    
    public AppUser deleteByUsername(String userName) {
        AppUser appUser=isUserDeleted(userName);
        if(appUser==null)
            return appUser;
        appUser.setStatus(-1);
        return entityManager.merge(appUser);
    }

}
