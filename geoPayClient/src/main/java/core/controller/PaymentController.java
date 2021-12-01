package core.controller;

import core.common.Actions;
import core.common.ApiResponse;
import core.common.util.CodeApiResponseCollection;
import core.dto.geopay.request.RequestPaymentDTO;
import core.dto.geopay.request.RequestPaymentQueryDTO;
import core.dto.geopay.request.RequestVoidPaymentDTO;
import core.dto.geopay.response.ResponsePaymentAndUrlDTO;
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
    GeoPaymentService geoPaymentService;

    //VALIDATE
    
    @PostMapping
    @RequestMapping("/signedAndBuildPayment")
    public ResponseEntity<ApiResponse> signedAndBuildPaymentWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        RequestPaymentDTO paymentDTO = geoPaymentService.signedAndBuildPaymentFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/signedAndBuildPaymentQuery")
    public ResponseEntity<ApiResponse> signedAndBuildPaymentQueryWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        RequestPaymentQueryDTO paymentQueryDTO = geoPaymentService.signedAndBuildPaymentQueryFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentQueryDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/signedAndBuildVoidPayment")
    public ResponseEntity<ApiResponse> signedAndBuildVoidPaymentWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        RequestVoidPaymentDTO voidPaymentDTO = geoPaymentService.signedAndBuildVoidPaymentFromJson(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, voidPaymentDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
    }

    //TEST
    
    @PostMapping
    @RequestMapping("/getUrlTokenPayment")
    public ResponseEntity<ApiResponse> getUrlTokenPaymentWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        ResponsePaymentAndUrlDTO paymentAndUrlDTO = geoPaymentService.getTokenUrlByJsonSignedPayment(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        if (paymentAndUrlDTO == null) {
            return new ResponseEntity<>(new ApiResponse(false, mPaymentControllerFail, "", CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentAndUrlDTO.getUrl(), CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
        }
    }

    //PAYMENT
    
    @PostMapping
    @RequestMapping("/getUrlTokenPaymentv2")
    public ResponseEntity<ApiResponse> getUrlTokenPaymentv2WS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        ResponsePaymentAndUrlDTO paymentAndUrlDTO = geoPaymentService.getTokenUrlByJsonSignedPaymentv2(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        if (paymentAndUrlDTO == null) {
            return new ResponseEntity<>(new ApiResponse(false, mPaymentControllerFail, "", CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentAndUrlDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
        }
    }
    
   
    @PostMapping
    @RequestMapping("/getPaymentQuery")
    public ResponseEntity<ApiResponse> getVoidPaymentWS(@RequestBody String jsonInputPayment) {
        log.info(Actions.ACTION_REST_IN);
        VoidPaymentResponseDTO paymentResultDTO = geoPaymentService.getVoidPaymentResult(jsonInputPayment);
        log.info(Actions.ACTION_REST_OUT);
        if (paymentResultDTO == null) {
            return new ResponseEntity<>(new ApiResponse(false, mPaymentControllerFail, "", CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(new ApiResponse(true, mPaymentControllerOk, paymentResultDTO, CodeApiResponseCollection.API_RESPONSE_OK), HttpStatus.OK);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleError() {
        return new ResponseEntity<>(new ApiResponse(false, mPaymentControllerFail, "", CodeApiResponseCollection.API_RESPONSE_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
