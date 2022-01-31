package core.persistence;

import core.entities.AppUser;
import java.util.List;

public interface IUserRepository  {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);

  AppUser deleteByUsername(String username);
  
  AppUser save(AppUser appUser);

  List<AppUser> allUser();

}
