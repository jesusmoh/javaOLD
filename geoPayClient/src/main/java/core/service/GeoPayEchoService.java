/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.dto.geopay.request.EchoDTO;
import core.model.geopay.RequestHeader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @author JOrtiz
 */
@Service
@EnableAsync
public class GeoPayEchoService {

    static final Logger log = Logger.getLogger(GeoPayEchoService.class.getName());
    private final DateTimeFormatter p = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${url.echotest}")
    private String echoTest;

    @Value("${geo.netid}")
    private String netId;

    @Value("${geo.netdescription}")
    private String netDescription;

    @Value("${geo.version}")
    private String version;

    private int echoCounter = 0;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    GeoPayJsonSignedService jsonSignedService;

    @Async
    public void executeGeoPayEchoTask() {
        String echoJson = buildGeoPayEchoJson();
        if (Optional.ofNullable(echoJson).isPresent()) {
            echoCounter++;
            OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, echoJson);
            Request request = new Request.Builder().url(echoTest).method("POST", body).addHeader("Content-Type", "application/json").build();

            Response response = null;

            try {
                log.log(Level.INFO, "ECHO REQUEST  # {0} {1}", new Object[]{echoCounter, Optional.ofNullable(request).get().toString()});
                response = client.newCall(request).execute();
                if (!response.isSuccessful()) {
                    log.log(Level.SEVERE, "ECHO ERROR CALL # {0} {1}", new Object[]{echoCounter, Optional.ofNullable(response).get().toString()});
                }
                log.log(Level.INFO, "ECHO RESPONSE # {0} {1}", new Object[]{echoCounter, Optional.ofNullable(response).get().toString()});

            } catch (IOException e) {
                log.log(Level.SEVERE, "{0} {1}", new Object[]{echoCounter, e.getMessage()});
            } finally {
                if (response != null && !response.isSuccessful()) {
                    response.body().close();
                    response.close();
                }
            }
        }
    }

    private String buildGeoPayEchoJson() {

        EchoDTO echoDTO = new EchoDTO();
        RequestHeader requestHeader = new RequestHeader();
        String jsonEchoDTO = "";
        String signedtJsonFromEchoDTO = "";

        requestHeader.setAuditNumber(String.valueOf(System.currentTimeMillis()));
        requestHeader.setNetId(netId);
        requestHeader.setNetDescription(netDescription);
        requestHeader.setVersion(version);
        requestHeader.setDigitalSign(null);
        requestHeader.setDateTime(LocalDateTime.now().format(p));

        try {

            echoDTO.setRequestHeader(requestHeader);
            jsonEchoDTO = mapper.writeValueAsString(echoDTO);
            String ds = jsonSignedService.singAnyJson(jsonEchoDTO).getDigitalSignt();
            echoDTO.getRequestHeader().setDigitalSign(ds);
            signedtJsonFromEchoDTO = mapper.writeValueAsString(echoDTO);

        } catch (JsonProcessingException e) {
            log.severe(e.getMessage());
            return null;
        }

        return signedtJsonFromEchoDTO;
    }

}
