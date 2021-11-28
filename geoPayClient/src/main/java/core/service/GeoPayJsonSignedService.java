/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import core.dto.SignedDTO;
import core.dto.geopay.response.ResponseHeaderDTO;
import core.model.geopay.ResponseHeader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author JOrtiz
 */
@Service
public class GeoPayJsonSignedService {

    static final Logger log = Logger.getLogger(GeoPayJsonSignedService.class.getName());

    @Value("${keystore.directory}")
    private String keyStoreDirectory;

    @Value("${keystore.pass}")
    private String keystorePass;

    @Value("${private.key.alias}")
    private String privateKeyAlias;

    @Value("${public.key.alias}")
    private String publicKeyAlias;

    @Value("${private.key.pass}")
    private String privateKeyPass;

    @Value("${json.regex}")
    private String jsonRegex;

    @Value("${json.regex.geopay}")
    private String jsonRegexGeopay;

    private ObjectMapper mapper;

    private KeyStore keyStore;

    private PrivateKey privateKey;

    private PublicKey publicKey;

    private Signature signature;

    @PostConstruct
    public void init() {

        mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        try {
            signature = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            log.severe(e.getMessage());
        }

        try {
            keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(keyStoreDirectory), keystorePass.toCharArray());

            privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPass.toCharArray());
            publicKey = keyStore.getCertificate(publicKeyAlias).getPublicKey();

        } catch (FileNotFoundException | KeyStoreException ex) {
            log.severe(ex.getMessage());
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException | IOException ex) {
            log.severe(ex.getMessage());
        }

        log.log(Level.INFO, "keyStoreDirectory ok on {0}", keyStoreDirectory);

    }

    public SignedDTO createDigitalSignForAJson(String json) {

        SignedDTO signedJResponseDTO = new SignedDTO();
        String jsonStringResult = null;
        String digitalSign = null;

        try {

            //Validate json and Sort by key 
            JsonNode actualObj = mapper.readTree(json);
            final String jsonData = mapper.writeValueAsString(actualObj);
            log.log(Level.INFO, "JSON  TO  PROCESS : {0}", jsonData);

            Map<String, Object> map = mapper.readValue(jsonData, HashMap.class);
            jsonStringResult = mapper.writeValueAsString(map);
            List<String> sortedKeys = new ArrayList<>(map.keySet());
            Collections.sort(sortedKeys);

            //Append sorted josn
            Map<String, Object> map2 = mapper.readValue(jsonStringResult, HashMap.class);

            String v = "";
            Iterator<String> ite = sortedKeys.iterator();
            while (ite.hasNext()) {
                String k = (String) ite.next();
                for (Map.Entry<String, Object> pair : map2.entrySet()) {
                    if (pair.getKey().equalsIgnoreCase(k)) {
                        v = v + pair.getKey() + "" + pair.getValue().toString();
                    }
                }
            }

            //Replace characters          
            jsonStringResult = v.replaceAll(jsonRegex, "");
            jsonStringResult = jsonStringResult.replaceAll(" ", "");
            jsonStringResult = jsonStringResult.replaceAll(jsonRegexGeopay, "");

            //UpperCase
            jsonStringResult = jsonStringResult.toUpperCase();

            //sign SHA1withRSA and Base64
            signature.initSign(privateKey);
            signature.update(jsonStringResult.getBytes());
            digitalSign = Base64.encodeBase64String((signature.sign()));

            log.log(Level.INFO, "JSON STRING RESULT : {0}", jsonStringResult);
            log.log(Level.INFO, "JSON  DIGITAL SIGN : {0}", digitalSign);

            signedJResponseDTO.setSignedState("ok");
            signedJResponseDTO.setDigitalSign(digitalSign);
            signedJResponseDTO.setDetail(jsonStringResult);

        } catch (JsonProcessingException ex) {
            log.severe(ex.getMessage());
            signedJResponseDTO.setDetail(ex.getMessage());
            signedJResponseDTO.setDigitalSign("nosigned");
            signedJResponseDTO.setSignedState("error");
        } catch (InvalidKeyException | SignatureException ex) {
            log.severe(ex.getMessage());
            signedJResponseDTO.setDetail(ex.getMessage());
            signedJResponseDTO.setDigitalSign("nosigned");
            signedJResponseDTO.setSignedState("error");
        }

        return signedJResponseDTO;
    }

    public boolean checkDigitalSignForAJson(String inputJson) {
        try {
            ResponseHeaderDTO responseHeaderDTO = mapper.readValue(inputJson, ResponseHeaderDTO.class);
            signature.initVerify(publicKey);
            signature.verify(Base64.decodeBase64(responseHeaderDTO.getResponseHeader().getDigitalSign()));
        } catch (InvalidKeyException | SignatureException | JsonProcessingException ex) {
            log.severe(ex.getMessage());
            return false;
        }
        return true;
    }

}
