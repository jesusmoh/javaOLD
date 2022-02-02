package core.persistence.imp;

import core.entities.AppUser;
import core.persistence.IUserRepository;
import core.persistence.imp.dao.PostgresUserDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImp implements IUserRepository {

    @Autowired
    PostgresUserDAO postgresUserDAO;

    @Override
    @Transactional
    public boolean existsByUsername(String username) {
        return postgresUserDAO.findByUserName(username) != null;
    }

    @Override
    @Transactional
    public AppUser findByUsername(String username) {
        return postgresUserDAO.findByUserName(username);
    }

    @Override
    @Transactional
    public AppUser deleteByUsername(String username) {
         return postgresUserDAO.deleteByUsername(username);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appUser) {
        return postgresUserDAO.save(appUser);
    }
    
     @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return postgresUserDAO.update(appUser);
    }

    @Override
    @Transactional
    public List<AppUser> allUser() {
         return postgresUserDAO.allUser();
    }


}
