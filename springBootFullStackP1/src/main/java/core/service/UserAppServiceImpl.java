/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import core.model.entity.UserApp;
import core.respository.UserAppRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JOrtiz
 */
@Service
public class UserAppServiceImpl implements UserAppService {
    
    @Autowired
    private UserAppRepository userAppRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<UserApp> findAll() {
        return userAppRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserApp> findAll(Pageable pageable) {
        return userAppRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserApp> findById(Long id) {
       return userAppRepository.findById(id);
    }

    @Override 
    @Transactional
    public UserApp save(UserApp userApp) {
      return userAppRepository.save(userApp);
    }

    @Override 
    @Transactional
    public void deleteById(Long id) {
         userAppRepository.deleteById(id);
    }
    
    
}
