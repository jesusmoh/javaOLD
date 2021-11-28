/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controller;

import core.common.ApiResponse;
import core.common.ApiResponseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jesus
 */
@RestController
@RequestMapping("/callBackController")
public class CallBackController {

    @Value("${m.call.back.controller.ok}")
    private String mCallBackControllerOk;	
    
    @Value("${m.call.back.controller.fail}")
    private String mCallBackControllerFail;
    
    @PostMapping("/geoPayPayment")
    public ResponseEntity<?> post(@RequestBody String input) {
        return new ResponseEntity<>(new ApiResponse(true, mCallBackControllerOk, input, ApiResponseCode.API_RESPONSE_OK), HttpStatus.OK);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity <ApiResponse> handleError() {
          return new ResponseEntity<>(new ApiResponse(false,mCallBackControllerFail,"",ApiResponseCode.API_RESPONSE_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
