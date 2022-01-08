/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jesus
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jms.jwt")
public class JwtIOProperties {

    private Security security;
    private String timezone;
    private String issuer;
    private Token token;
    private Excluded excluded;

    @Data
    public static class Security {
        private boolean enable;
    }

    @Data
    public static class Token {
        private Auth auth;
        private String secret;
        private int expiresIn;
    }

    @Data
    public static class Excluded {
        private String path;
    }

    @Data
    public static class Auth {
        private String path;
    }

}
