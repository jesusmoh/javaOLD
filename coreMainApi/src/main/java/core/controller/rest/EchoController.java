package core.controller.rest;

import core.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/echo")
@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
public class EchoController {
    @PostMapping()
    public ApiResponse list(@RequestBody String json) {    
        return new ApiResponse(HttpStatus.OK);
    }   
}
