/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author jesus
 */
@Data
@Builder
public class JWTResponseDTO implements Serializable{
    
    static final long serialVersionUID = 1L;
    
    @JsonProperty(value="token_type")
    private String tokenType;
    @JsonProperty(value="access_token")
    private String accessToken;
    @JsonProperty(value="expires_in")
    private int expiresIn;
    @JsonProperty(value="issued_at")
    private String issuedAt;
    @JsonProperty(value="client_id")
    private String clientId;

    
}
