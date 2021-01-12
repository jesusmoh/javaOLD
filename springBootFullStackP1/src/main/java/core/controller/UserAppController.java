/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller;

import core.model.entity.UserApp;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import core.service.UserAppService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author JOrtiz
 */
@RestController
@RequestMapping("api/appUsers")
public class UserAppController {
    
    @Autowired
    private UserAppService userAppService;
    
    @GetMapping()
    public Iterable<UserApp> list() {
        return userAppService.findAll();
    }
    
    @GetMapping("{id}")
    public Object get(@PathVariable String id) {
        Optional<UserApp> oUserApp= userAppService.findById(Long.parseLong(id));
        if(!oUserApp.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUserApp);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        Optional<UserApp> oUserApp= userAppService.findById(Long.parseLong(id));
        if(!oUserApp.isPresent())
        {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ((UserApp) input).setId(Long.parseLong(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(userAppService.save((UserApp) input));
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) 
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userAppService.save((UserApp) input));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<UserApp> oUserApp= userAppService.findById(Long.parseLong(id));
        if(!oUserApp.isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        userAppService.deleteById(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/stremaAll")
    public List<UserApp> readAll() {
        List<UserApp> users = StreamSupport
                .stream(userAppService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
