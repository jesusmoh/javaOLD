package core.controller.rest.resources;

import core.service.CalculatorBasicServiceProvider;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 *
 * @author
 */
@Path("calculator")
@ApplicationScoped
public class CalculatorRestService {

    @Inject 
    CalculatorBasicServiceProvider cb;
   
    @GET
    public Response calculatorRestService() {
        return Response
                .ok("ping"+cb.sum(1, 0))
                .build();
    }
}
