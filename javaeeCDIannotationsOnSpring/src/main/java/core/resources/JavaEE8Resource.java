package core.resources;


import core.ServiceSMS;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    

    @GET
    public Response ping()
    {
        ApplicationContext contexto = new ClassPathXmlApplicationContext("classpath*:ApplicationContext.xml");
        
        ServiceSMS serviceSMS = (ServiceSMS) contexto.getBean("serviceSMS");
           System.out.println(serviceSMS.sms());

        return Response.ok("ping"+serviceSMS.sms() ).build();
    }
}
