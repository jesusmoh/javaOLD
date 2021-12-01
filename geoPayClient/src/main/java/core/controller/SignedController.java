
package core.controller;

import core.common.Actions;
import core.common.ApiResponse;
import core.common.util.CodeApiResponseCollection;
import core.dto.SignedDTO;
import core.service.GeoPayJsonSignedService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 *
 * @author JOrtiz
 */
@RestController
public class SignedController {
    
    static final Logger log = Logger.getLogger(SignedController.class.getName());
    
    @Value("${m.signed.controller.ok}")
    private String mSignedControllerOk;	
    
    @Value("${m.signed.controller.fail}")
    private String mSignedControllerFail;	
    
    @Autowired
    GeoPayJsonSignedService jsonSignedService;
   
    @PostMapping
    @RequestMapping("/signed")
    public ResponseEntity<ApiResponse> post(@RequestBody String jsonInput) {
        
        log.info(Actions.ACTION_REST_IN);
        SignedDTO appResponseHeaderDTO =jsonSignedService.createDigitalSignForAJson(jsonInput);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true,mSignedControllerOk,appResponseHeaderDTO,CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity <ApiResponse> handleError() {
          return new ResponseEntity<>(new ApiResponse(false,mSignedControllerFail,"",CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.OK);
    }
    
}
