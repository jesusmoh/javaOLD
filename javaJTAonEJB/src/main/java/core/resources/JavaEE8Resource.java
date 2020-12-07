package core.resources;

import core.Person;
import core.PersonService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("javaee8")
@Stateless
public class JavaEE8Resource {

    @EJB
    private PersonService personService;

    @GET
    public Response ping() {
        Person personA;
        Person personB;
        Person personC;

        personA = new Person();
        personA.setName("A");
        personB = new Person();
        personB.setName("B");
        personC = new Person();
        personC.setName("C");

        personService.insert(personA, personB, personC);
        return Response.ok("ping").build();
    }
}
