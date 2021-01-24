/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author JOrtiz
 */
@ApplicationPath("/api/v1/")
@BasicAuthenticationMechanismDefinition(realmName = "userRealm")
@ApplicationScoped
@DeclareRoles({"99999"}) 
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(core.controllers.restservice.PCorporativoFacadeREST.class);
        resources.add(core.model.util.ConstraintViolationExceptionMapper.class);
    }
    
}
