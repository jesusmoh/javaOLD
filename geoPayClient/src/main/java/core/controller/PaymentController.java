
package core.controller;
import core.common.Actions;
import core.common.ApiResponse;
import core.common.util.CodeApiResponseCollection;
import core.dto.geopay.request.PaymentRequestDTO;
import core.dto.geopay.request.PaymentQueryRequestDTO;
import core.dto.geopay.request.VoidPaymentRequestDTO;
import core.dto.geopay.response.PaymentAndUrlResponseDTO;
import core.dto.geopay.response.PaymentTokenResponseDTO;
import core.dto.geopay.response.VoidPaymentResponseDTO;
import core.service.GeoPaymentService;

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
public class PaymentController {
    
    static final Logger log = Logger.getLogger(PaymentController.class.getName());
   
    @Value("${m.payment.controller.ok}")
    private String mPaymentControllerOk;	
    
    @Value("${m.payment.controller.fail}")
    private String mPaymentControllerFail;
    
    @Autowired
    GeoPaymentService geoPaymentService ;
    
    @PostMapping
    @RequestMapping("/signedAndBuildPayment")
    public ResponseEntity<ApiResponse> signedAndBuildPaymentWS (@RequestBody String jsonInputPayment) {
    	log.info(Actions.ACTION_REST_IN);
        PaymentRequestDTO paymentDTO=geoPaymentService.signedAndBuildPaymentFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
         return new ResponseEntity<>(new ApiResponse(true,mPaymentControllerOk,paymentDTO,CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/getTokenPayment")
    public ResponseEntity<ApiResponse> getTokenPaymentWS (@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        PaymentTokenResponseDTO paymentTokenDTO = geoPaymentService.getTokenByJsonSignedPayment(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
    	return new ResponseEntity<>(new ApiResponse(true,mPaymentControllerOk,paymentTokenDTO,CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/getUrlTokenPayment")
    public ResponseEntity<ApiResponse> getUrlTokenPaymentWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        PaymentAndUrlResponseDTO paymentAndUrlDTO = geoPaymentService.getTokenUrlByJsonSignedPayment(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentAndUrlDTO.getUrl(), CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/getUrlTokenPaymentv2")
    public ResponseEntity<ApiResponse> getUrlTokenPaymentv2WS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        PaymentAndUrlResponseDTO paymentAndUrlDTO = geoPaymentService.getTokenUrlByJsonSignedPaymentv2(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentAndUrlDTO.getUrl(), CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/signedAndBuildPaymentQuery")
    public ResponseEntity<ApiResponse> signedAndBuildPaymentQueryWS (@RequestBody String jsonInputPayment) {
    	log.info(Actions.ACTION_REST_IN);
        PaymentQueryRequestDTO paymentQueryDTO =geoPaymentService.signedAndBuildPaymentQueryFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentQueryDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/signedAndBuildVoidPayment")
    public ResponseEntity<ApiResponse> signedAndBuildVoidPaymentWS (@RequestBody String jsonInputPayment) {
    	log.info(Actions.ACTION_REST_IN); 
        VoidPaymentRequestDTO voidPaymentDTO =geoPaymentService.signedAndBuildVoidPaymentFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
         return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, voidPaymentDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @PostMapping
    @RequestMapping("/getVoidPayment")
    public ResponseEntity<ApiResponse> getVoidPaymentWS (@RequestBody String jsonInputPayment) {
    	log.info(Actions.ACTION_REST_IN);
        VoidPaymentResponseDTO paymentResultDTO =geoPaymentService.getVoidPaymentResult(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentResultDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity <ApiResponse> handleError() {
          return new ResponseEntity<>(new ApiResponse(false,mPaymentControllerFail,"",CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.OK);
    }
    
}
