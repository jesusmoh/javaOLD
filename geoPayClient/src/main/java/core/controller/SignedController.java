
package core.controller;

import core.dto.AppResponseHeaderDTO;
import core.service.GeoPayJsonSignedService;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author JOrtiz
 */
@RestController
public class SignedController {
    
	static Logger log = Logger.getLogger(SignedController.class.getName());
	
    @Autowired
    GeoPayJsonSignedService jsonSignedService;
   
    @PostMapping
    @RequestMapping("/signed")
    public AppResponseHeaderDTO post(@RequestBody String jsonInput) {
        
    	 log.info("Client Signed Request");
         return jsonSignedService.singAnyJson(jsonInput);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Can't signed the JSON")
    public void handleError() {
    	 log.severe("Can't signed the JSON");
    }
    
}
