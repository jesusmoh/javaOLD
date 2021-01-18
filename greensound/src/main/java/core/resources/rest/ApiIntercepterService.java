/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.resources.rest;

import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author JOrtiz
 */
@Provider
@PreMatching
public class ApiIntercepterService implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        String url = request.getUriInfo().getAbsolutePath().toString();
        if (url.contains("resources/auth")) {
            return;
        }
        String token = request.getHeaderString("Authorization").replace("Bearer ", "");
        if (token == null) {
            JsonObject jsonObject = Json.createObjectBuilder().add("mensaje", "credenciales incorrectas").build();
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(jsonObject).build());
        } else {
            if (!token.equalsIgnoreCase("AHGC-12BD-1328-75HF-HD64")) {
                JsonObject jsonObject = Json.createObjectBuilder().add("mensaje", "credenciales incorrectas").build();
                request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(jsonObject).build());
            }
        }

    }
    
}
