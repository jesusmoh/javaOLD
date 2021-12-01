/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.common.util.CodeSignedResponseCollection;

import core.dto.SignedDTO;
import core.dto.geopay.request.RequestPaymentDTO;
import core.dto.geopay.request.RequestPaymentQueryDTO;
import core.dto.geopay.request.RequestVoidPaymentDTO;
import core.dto.geopay.response.ResponsePaymentAndUrlDTO;
import core.dto.geopay.response.ResponsePaymentTokenDTO;
import core.dto.geopay.response.VoidPaymentResponseDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @author JOrtiz
 */
@Service
@EnableAsync
public class GeoPaymentService {

    static final Logger log = Logger.getLogger(GeoPaymentService.class.getName());

    @Value("${rest.timeout.second}")
    private Long restTimeoutSecond;
    
    @Value("${rest.timeout.read.second}")
    private Long restTimeoutReadSecond;
    
    @Value("${rest.timeout.write.second}")
    private Long restTimeoutWriteSecond;
    
    @Value("${geo.url.payment}")
    private String geoUrlPayment;

    @Value("${geo.url.request.payment}")
    private String geoUrlRequestPayment;

    @Value("${geo.url.void.payment}")
    private String geoUrlVoidPayment;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    GeoPayJsonSignedService jsonSignedService;

    public RequestPaymentDTO signedAndBuildPaymentFromJson(String inputJson) {
        RequestPaymentDTO paymentDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) 
        {
            SignedDTO signedDTO = jsonSignedService.createDigitalSignForAJson(inputJson);
            if (signedDTO.getSignedState().equalsIgnoreCase(CodeSignedResponseCollection.API_RESPONSE_SIGNED_OK)) {
                try {
                    paymentDTO = mapper.readValue(inputJson, RequestPaymentDTO.class);
                    paymentDTO.getRequestHeader().setDigitalSign(signedDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.log(Level.SEVERE, " {0}", e.getMessage());
                    return paymentDTO;
                }
            }
        }
        return paymentDTO;
    }

    public RequestPaymentQueryDTO signedAndBuildPaymentQueryFromJson(String inputJson) {
        RequestPaymentQueryDTO paymentQueryDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) {
            SignedDTO responseHeaderDTO = jsonSignedService.createDigitalSignForAJson(inputJson);
            if (responseHeaderDTO.getSignedState().equalsIgnoreCase(CodeSignedResponseCollection.API_RESPONSE_SIGNED_OK)) {
                try {
                    paymentQueryDTO = mapper.readValue(inputJson, RequestPaymentQueryDTO.class);
                    paymentQueryDTO.getRequestHeader().setDigitalSign(responseHeaderDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.log(Level.SEVERE, " {0}", e.getMessage());
                }
            }
        }
        return paymentQueryDTO;
    }

    public RequestVoidPaymentDTO signedAndBuildVoidPaymentFromJson(String inputJson) {
        RequestVoidPaymentDTO voidPaymentDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) {
            SignedDTO responseHeaderDTO = jsonSignedService.createDigitalSignForAJson(inputJson);
            if (responseHeaderDTO.getSignedState().equalsIgnoreCase(CodeSignedResponseCollection.API_RESPONSE_SIGNED_OK)) {
                try {
                    voidPaymentDTO = mapper.readValue(inputJson, RequestVoidPaymentDTO.class);
                    voidPaymentDTO.getRequestHeader().setDigitalSign(responseHeaderDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.log(Level.SEVERE, " {0}", e.getMessage());
                }
            }
        }
        return voidPaymentDTO;
    }

    public ResponsePaymentTokenDTO getTokenByJsonSignedPayment(String jsonPaymentDTO) {
        ResponsePaymentTokenDTO responsePaymentTokenDTO = null;
        if (Optional.ofNullable(jsonPaymentDTO).isPresent()) {

            final OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(restTimeoutSecond, TimeUnit.SECONDS).writeTimeout(restTimeoutWriteSecond, TimeUnit.SECONDS).readTimeout(restTimeoutReadSecond, TimeUnit.SECONDS).build();
            final MediaType mediaType = MediaType.parse("application/json");
            final RequestBody body = RequestBody.create(mediaType, jsonPaymentDTO);
            final Request request = new Request.Builder().url(geoUrlPayment).method("POST", body).addHeader("Content-Type", "application/json").build();

            Response response = null;
            String jsonData = null;

            try {
                response = client.newCall(request).execute();
                log.info(Optional.ofNullable(response).get().toString());
            } catch (IOException e) {
                log.severe(e.getMessage());
                return responsePaymentTokenDTO;
            }

            if (response != null) {
                try {
                    jsonData = response.body().string();
                } catch (IOException e1) {
                    log.severe(e1.getMessage());
                } finally {
                    if (response != null && !response.isSuccessful()) {
                        response.body().close();
                        response.close();
                    }
                }
            }

            try {
                responsePaymentTokenDTO = mapper.readValue(jsonData, ResponsePaymentTokenDTO.class);
            } catch (IOException e) {
                log.severe(e.getMessage());
                return responsePaymentTokenDTO;
            }
        }
        return responsePaymentTokenDTO;
    }

    public ResponsePaymentAndUrlDTO getTokenUrlByJsonSignedPayment(String jsonPaymentDTO) {
        URL url = null;
        ResponsePaymentAndUrlDTO paymentAndUrlDTO = null;
        ResponsePaymentTokenDTO paymentTokenDTO = null;

        paymentTokenDTO = getTokenByJsonSignedPayment(jsonPaymentDTO);
        try {
            url = new URL(geoUrlRequestPayment.concat("?token=" + paymentTokenDTO.getToken()));
        } catch (MalformedURLException e) {
            log.log(Level.SEVERE, " {0}", e.getMessage());
            return paymentAndUrlDTO;
        }

        if (paymentTokenDTO == null || paymentTokenDTO.getToken() == null) {
            log.log(Level.SEVERE, " {0}", "TOKEN NULL");
            return paymentAndUrlDTO;
        }

        
        paymentAndUrlDTO = new ResponsePaymentAndUrlDTO();
        paymentAndUrlDTO.setUrl(url);
        paymentAndUrlDTO.setPaymentTokenDTO(paymentTokenDTO);
        return paymentAndUrlDTO;
    }

    public ResponsePaymentAndUrlDTO getTokenUrlByJsonSignedPaymentv2(String jsonPaymentDTO) {
        ResponsePaymentAndUrlDTO paymentAndUrlDTO = null;
        URL url = null;
        RequestPaymentDTO paymentDTO = null;
        String jsonPaymentSigned = null;
        ResponsePaymentTokenDTO paymentTokenDTO = null;

        paymentDTO = signedAndBuildPaymentFromJson(jsonPaymentDTO);
        
        try {
            jsonPaymentSigned = mapper.writeValueAsString(paymentDTO);
        } catch (JsonProcessingException ex) {
            log.log(Level.SEVERE, " {0}", ex.getMessage());
            return paymentAndUrlDTO;
        }

        paymentTokenDTO = getTokenByJsonSignedPayment(jsonPaymentSigned);
        try {
            url = new URL(geoUrlRequestPayment.concat("?token=" + paymentTokenDTO.getToken()));
        } catch (Exception e) {
            log.log(Level.SEVERE, " {0}", e.getMessage());
            return paymentAndUrlDTO;
        }

        if (paymentTokenDTO == null || paymentTokenDTO.getToken() == null || !paymentTokenDTO.getResponseHeader().getResponseCode().equalsIgnoreCase("00")) {
            log.log(Level.SEVERE, " {0}", "TOKEN ERROR");
            return paymentAndUrlDTO;
        }

        paymentAndUrlDTO = new ResponsePaymentAndUrlDTO();
        paymentAndUrlDTO.setPaymentTokenDTO(paymentTokenDTO);
        paymentAndUrlDTO.setUrl(url);

        return paymentAndUrlDTO;
    }

    public VoidPaymentResponseDTO getVoidPaymentResult(String jsonVoidPayment) {

        VoidPaymentResponseDTO voidPaymentResultDTO = null;
        Response response = null;
        String jsonData = null;
        RequestVoidPaymentDTO voidPaymentDTO = null;

        voidPaymentDTO = signedAndBuildVoidPaymentFromJson(jsonVoidPayment);

        if (Optional.ofNullable(voidPaymentDTO).isPresent()) {

            try {
                final String voidPaymentJSON = mapper.writeValueAsString(voidPaymentDTO);
                final OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(restTimeoutSecond, TimeUnit.SECONDS).writeTimeout(restTimeoutWriteSecond, TimeUnit.SECONDS).readTimeout(restTimeoutReadSecond, TimeUnit.SECONDS).build();
                final MediaType mediaType = MediaType.parse("application/json");
                final RequestBody body = RequestBody.create(mediaType, voidPaymentJSON);
                final Request request = new Request.Builder().url(geoUrlVoidPayment).method("POST", body).addHeader("Content-Type", "application/json").build();

                response = client.newCall(request).execute();

            } catch (IOException e) {
                log.severe(e.getMessage());
                return voidPaymentResultDTO;
            }

            if (response != null) {
                try {
                    jsonData = response.body().string();
                    if (jsonSignedService.checkDigitalSignForAJson(jsonData)) {
                        voidPaymentResultDTO = mapper.readValue(jsonData, VoidPaymentResponseDTO.class);
                    } else {
                        return voidPaymentResultDTO;
                    }
                } catch (IOException e1) {
                    log.severe(e1.getMessage());
                    return voidPaymentResultDTO;
                } finally {
                    if (!response.isSuccessful()) {
                        response.body().close();
                        response.close();
                    }
                }
            }
        }

        return voidPaymentResultDTO;
    }
    
   
}
