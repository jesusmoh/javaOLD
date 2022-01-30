package core.persistence;

import core.entities.AppUser;

public interface IUserRepository  {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);

  AppUser deleteByUsername(String username);
  
  AppUser save(AppUser appUser);

}
