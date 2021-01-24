/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.security;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Collections;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

/**
 *
 * @author JOrtiz
 */
@ApplicationScoped
public class InMemoryIdentityStore implements IdentityStore {

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential user = UsernamePasswordCredential.class.cast(credential);
            if (user.getPassword().compareTo("1278202") && user.getCaller().equalsIgnoreCase("99999")) {
                return new CredentialValidationResult("99999", Collections.singleton("99999"));
            } else {
                return INVALID_RESULT;
            }
        }
         return INVALID_RESULT;

    }
}
