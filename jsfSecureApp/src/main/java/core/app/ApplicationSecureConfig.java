/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.app;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;


@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/MySqlApp",
        callerQuery = "select password from app_users where username = ?",
        groupsQuery = "select user_group from app_users where username = ?"
)

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)

@FacesConfig
@ApplicationScoped
public class ApplicationSecureConfig {
    
}
