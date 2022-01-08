/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.security;

import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uy.com.util.JsonParser;



/**
 *
 * @author jesus
 */
@Component
@Data
public class JwtIO {
    
    @Value("${jms.jwt.token.secret}")
    private String SECRET;
    
    @Value("${jms.jwt.timezone}")
    private String TIMEZONE;
    
    @Value("${jms.jwt.expire-in}")
    private int EXPIRES_IN;
    
    @Value("${jms.jwt.token.issuer}")
    private String ISSUER;
    
    @Value("${json.regex}")
    private String jsonRegex;

    @Value("${json.regex.v2}")
    private String jsonRegexV2;

    public String generateToken(Object src) {
        
         //SERIALIZATE
        String  subject = "";
        try {
            subject = JsonParser.toJson(src);
        } catch (IOException ex) {
            Logger.getLogger(JwtIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         //CHRAGE A SECRET PASS TO SIGN
        Signer signer = HMACSigner.newSHA256Signer(SECRET);
        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);
        ZonedDateTime zdt= ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRES_IN);
            
        String h = subject.replaceFirst(jsonRegex, "").replaceFirst(jsonRegexV2, "");
        
        JWT jwt= new JWT()
                .setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(tz.toZoneId()))
                .setSubject(h)
                .setExpiration(zdt);
        return JWT.getEncoder().encode(jwt, signer);
        
  
    }
    
    public boolean validateToken(String encodeJWT) {
        var isValid = false;
        try {
            JWT jwt = jwt(encodeJWT);
            isValid = jwt.isExpired();
        } catch (Exception e) {
            isValid = true;
        }
        return isValid;
    }
    
    public String getPayLoad(String encodeJWT) {
        JWT jwt = jwt(encodeJWT);
        return jwt.subject;
    }
    
    private JWT jwt(String encodedJWT) {
        Verifier verifier = HMACVerifier.newVerifier(SECRET);
        return JWT.getDecoder().decode(encodedJWT, verifier);
    }
    
}
