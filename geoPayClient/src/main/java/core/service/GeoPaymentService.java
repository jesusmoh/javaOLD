/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.dto.AppResponseHeaderDTO;
import core.dto.geopay.request.PaymentDTO;
import core.dto.geopay.request.PaymentQueryDTO;
import core.dto.geopay.request.VoidPaymentDTO;
import core.dto.geopay.response.PaymentTokenDTO;
import core.dto.geopay.response.VoidPaymentResultDTO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
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

    static Logger log = Logger.getLogger(GeoPaymentService.class.getName());

    @Value("${geo.url.payment}")
    private String geoUrlPayment;

    @Value("${geo.netid}")
    private String netId;

    @Value("${geo.netdescription}")
    private String netDescription;

    @Value("${geo.version}")
    private String version;

    @Value("${geo.url.request.payment}")
    private String geoUrlRequestPayment;
    
    @Value("${geo.url.void.payment}")
    private String geoUrlVoidPayment;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    GeoPayJsonSignedService jsonSignedService;

    public PaymentDTO signedAndBuildPaymentFromJson(String inputJson) {
        PaymentDTO paymentDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) {
            AppResponseHeaderDTO responseHeaderDTO = jsonSignedService.singAnyJson(inputJson);
            if (responseHeaderDTO.getState().equalsIgnoreCase("ok")) {
                try {
                    paymentDTO = mapper.readValue(inputJson, PaymentDTO.class);
                    paymentDTO.getRequestHeader().setDigitalSign(responseHeaderDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.severe(" " + e.getMessage());
                }
            }
        }
        return paymentDTO;
    }

    public PaymentQueryDTO signedAndBuildPaymentQueryFromJson(String inputJson) {
        PaymentQueryDTO paymentQueryDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) {
            AppResponseHeaderDTO responseHeaderDTO = jsonSignedService.singAnyJson(inputJson);
            if (responseHeaderDTO.getState().equalsIgnoreCase("ok")) {
                try {
                    paymentQueryDTO = mapper.readValue(inputJson, PaymentQueryDTO.class);
                    paymentQueryDTO.getRequestHeader().setDigitalSign(responseHeaderDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.severe(" " + e.getMessage());
                }
            }
        }
        return paymentQueryDTO;
    }
    
    public VoidPaymentDTO signedAndBuildVoidPaymentFromJson(String inputJson) {
        VoidPaymentDTO voidPaymentDTO = null;
        if (Optional.ofNullable(inputJson).isPresent()) {
            AppResponseHeaderDTO responseHeaderDTO = jsonSignedService.singAnyJson(inputJson);
            if (responseHeaderDTO.getState().equalsIgnoreCase("ok")) {
                try {
                	voidPaymentDTO = mapper.readValue(inputJson, VoidPaymentDTO.class);
                	voidPaymentDTO.getRequestHeader().setDigitalSign(responseHeaderDTO.getDigitalSignt());
                } catch (IOException e) {
                    log.severe(" " + e.getMessage());
                }
            }
        }
        return voidPaymentDTO;
    }

    public PaymentTokenDTO getTokenByJsonSignedPayment(String jsonPaymentDTO) {

        PaymentTokenDTO responsePaymentTokenDTO = null;

        if (Optional.ofNullable(jsonPaymentDTO).isPresent()) {

            final OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();
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
            }

            if (response != null) {
                try {
                    jsonData = response.body().string();
                } catch (IOException e1) {
                    log.severe(e1.getMessage());
                }finally {
                	if (response!=null && !response.isSuccessful())
                	{
                		response.body().close();
                		response.close();
                	}
                	
                }
            }

            try {
                responsePaymentTokenDTO = mapper.readValue(jsonData, PaymentTokenDTO.class);
            } catch (IOException e) {
                log.severe(e.getMessage());
            }

        }
        return responsePaymentTokenDTO;
    }

    public URL getTokenUrlByJsonSignedPayment(String jsonPaymentDTO) {
        URL url = null;
        PaymentTokenDTO paymentTokenDTO;
        paymentTokenDTO = getTokenByJsonSignedPayment(jsonPaymentDTO);
        try {
            url = new URL(geoUrlRequestPayment.concat("?token=" + paymentTokenDTO.getToken()));
        } catch (MalformedURLException e) {
            log.severe(" " + e.getMessage());
        }
        return url;
    }

	public VoidPaymentResultDTO getVoidPaymentResult(String jsonVoidPayment) {
		
		VoidPaymentResultDTO voidPaymentResultDTO = null;
		Response response = null;
		String jsonData = null;
		VoidPaymentDTO voidPaymentDTO = signedAndBuildVoidPaymentFromJson(jsonVoidPayment);
	
		if (Optional.ofNullable(voidPaymentDTO).isPresent()) {

			try {
				final String voidPaymentJSON = mapper.writeValueAsString(voidPaymentDTO);
				final OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();
				final MediaType mediaType = MediaType.parse("application/json");
				final RequestBody body = RequestBody.create(mediaType, voidPaymentJSON);
				final Request request = new Request.Builder().url(geoUrlVoidPayment).method("POST", body).addHeader("Content-Type", "application/json").build();
				
				response = client.newCall(request).execute();
				
			} catch (JsonProcessingException e2) {
				log.severe(e2.getMessage());
			} catch (IOException e) {
				log.severe(e.getMessage());
			}
			
			if (response != null) {
				try {
					jsonData = response.body().string();
					voidPaymentResultDTO = mapper.readValue(jsonData, VoidPaymentResultDTO.class);
				} catch (IOException e1) {
					log.severe(e1.getMessage());
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
