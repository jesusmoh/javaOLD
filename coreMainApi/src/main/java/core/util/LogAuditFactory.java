
package core.util;

import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class LogAuditFactory {
     static final Logger log = Logger.getLogger(LogAuditFactory.class.getName());
     
     public static String getKey(){
         final UUID uuid = UUID.randomUUID();
         return uuid.toString(); 
     }
     
     public static MultiValueMap<String, String> buildLogAudit(String uuid) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("uuid", uuid);
        return  multiValueMap;
    }
 
      
}
