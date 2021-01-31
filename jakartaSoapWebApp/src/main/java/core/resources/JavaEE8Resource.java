package core.resources;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author 
 */
@WebService(serviceName = "sincroService")
public class JavaEE8Resource {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation1")
    public String operation1(@WebParam(name = "p1") String p1, @WebParam(name = "p2") float p2) {
        //TODO write your implementation code here:
        return "concat p1 and p2 "+p1+p2;
    }
    
   
}
