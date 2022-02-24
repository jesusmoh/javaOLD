package core.controller.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jesus
 */
@RestController
@RequestMapping("/echo")
@CrossOrigin(origins = "http://localhost:4200")
public class EchoController {
    
    @GetMapping()
    public String list() {
        return "echoAPP";
    }   
}
