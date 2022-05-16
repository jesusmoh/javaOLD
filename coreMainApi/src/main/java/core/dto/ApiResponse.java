
package core.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class ApiResponse extends ResponseEntity{
    
    public ApiResponse(Object dto, MultiValueMap headers, HttpStatus status) {         
        super(dto, headers, status);
    }
    
     public ApiResponse(HttpStatus status) {         
        super(status);
    }
    
     
}
