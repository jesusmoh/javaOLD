package core.persistence.imp.dao;

import core.commons.AppBDMessagess;
import core.entities.AppUser;
import core.exception.CustomException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PostgresUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public AppUser findById(Long id) {
        return entityManager.find(AppUser.class, id);
    }

    public AppUser findByUserName(String userName) {
        Query query = entityManager.createQuery("SELECT a FROM AppUser a WHERE a.userName = :userName", AppUser.class);
        query.setParameter("userName", userName);
        List<AppUser> results = query.getResultList();
        if (results.size() >= 1) {
            return results.get(0);
        }
        return null;
    }

    public List<AppUser> allUser() {
        try {
            Query query = entityManager.createQuery("SELECT a FROM AppUser a", AppUser.class);
            List<AppUser> results = query.getResultList();
            if (results.size() >= 1) {
                return results;
            }
            return null;
        } catch (Exception e) {
            throw new CustomException(AppBDMessagess.DATABASE_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public AppUser isUserDeleted(String userName) {
        Query query = entityManager.createQuery("SELECT a FROM AppUser a WHERE a.username = :userName AND a.status= :status", AppUser.class);
        query.setParameter("status", 0);
        query.setParameter("userName", userName);
        List<AppUser> results = query.getResultList();
        if (results.size() >= 1) {
            return results.get(0);
        }
        return null;
    }

    public AppUser save(AppUser appUser) {
         entityManager.persist(appUser);
         AppUser r= findByUserName(appUser.getUserName());
         if(r==null)
           return null;
         return r;
    }
    
    public AppUser update(AppUser appUser) {
        AppUser r= findByUserName(appUser.getUserName());
        if(r==null)
           return null;
        appUser.setId(r.getId());
        appUser.setCreateAt(r.getCreateAt());
        return entityManager.merge(appUser);
    }

    public AppUser deleteByUsername(String userName) {
        AppUser appUser = isUserDeleted(userName);
        if (appUser == null) {
            return appUser;
        }
        appUser.setStatus(-1);
        return entityManager.merge(appUser);
    }

}
