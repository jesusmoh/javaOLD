
package core.controller;


import core.dto.geopay.request.PaymentDTO;
import core.dto.geopay.request.PaymentQueryDTO;
import core.dto.geopay.request.VoidPaymentDTO;
import core.dto.geopay.response.PaymentTokenDTO;
import core.dto.geopay.response.VoidPaymentResultDTO;
import core.service.GeoPaymentService;

import java.net.URL;
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
public class PaymentController {
    
	static Logger log = Logger.getLogger(PaymentController.class.getName());
	
    @Autowired
    GeoPaymentService geoPaymentService ;
    
    @PostMapping
    @RequestMapping("/signedAndBuildPayment")
    public PaymentDTO signedAndBuildPaymentWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.signedAndBuildPaymentFromJson(jsonInputPayment);
    }
    
    @PostMapping
    @RequestMapping("/getTokenPayment")
    public PaymentTokenDTO getTokenPaymentWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.getTokenByJsonSignedPayment(jsonInputPayment);
    }
    
    @PostMapping
    @RequestMapping("/getUrlTokenPayment")
    public URL getUrlTokenPaymentWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.getTokenUrlByJsonSignedPayment(jsonInputPayment);
    }
    
    @PostMapping
    @RequestMapping("/signedAndBuildPaymentQuery")
    public PaymentQueryDTO signedAndBuildPaymentQueryWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.signedAndBuildPaymentQueryFromJson(jsonInputPayment);
    }
    
    @PostMapping
    @RequestMapping("/signedAndBuildVoidPayment")
    public VoidPaymentDTO signedAndBuildVoidPaymentWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.signedAndBuildVoidPaymentFromJson(jsonInputPayment);
    }
    
    @PostMapping
    @RequestMapping("/getVoidPayment")
    public VoidPaymentResultDTO getVoidPaymentWS (@RequestBody String jsonInputPayment) {
    	return geoPaymentService.getVoidPaymentResult(jsonInputPayment);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "geoPayClient general payment error")
    public void handleError() {
    	 log.severe("geoPayClient general payment error");
    }
    
}
