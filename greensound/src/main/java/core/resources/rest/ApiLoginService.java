package core.resources.rest;

import core.domain.entities.WebMaUsuario;
import core.persistence.WebMaUsuarioFacadeDAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
@Stateless
public class ApiLoginService {

    @EJB
    private WebMaUsuarioFacadeDAO webMaUsuarioFacade;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response userCheck( WebMaUsuario maUsuario){
    
        WebMaUsuario user=  webMaUsuarioFacade.find(maUsuario.getCodigo());
        if(user!=null)
        {
            String key="mi_clave";
            long tiempo = System.currentTimeMillis();
            String jwt =  Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, key)
                    .setSubject("jesus ortiz")
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo+900000))
                    .claim("email","jesusmoh89@gmail.com")
                    .compact();

            JsonObject jsonObject= Json.createObjectBuilder().add("token",jwt).build();
            return Response.status(Response.Status.CREATED).entity(jsonObject).build();
        }else
        {
            JsonObject jsonObject= Json.createObjectBuilder().add("mesaje","login error").build();
            return Response.status(Response.Status.UNAUTHORIZED).entity(jsonObject).build();
        }

    }
    
}
