/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;
import core.model.entity.UserApp;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author JOrtiz
 */
public interface UserAppService {
    
    public Iterable<UserApp> findAll();
    
    public Page<UserApp> findAll(Pageable pageable);
    
    public Optional<UserApp> findById(Long id);
    
    public UserApp save(UserApp userApp);
    
    public void deleteById(Long id);
    
}
