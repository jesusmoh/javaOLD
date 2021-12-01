/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dto.geopay.response;

import java.net.URL;

/**
 *
 * @author jesus
 */
public class ResponsePaymentAndUrlDTO {
    private URL url ;
    private ResponsePaymentTokenDTO paymentTokenDTO;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public ResponsePaymentTokenDTO getPaymentTokenDTO() {
        return paymentTokenDTO;
    }

    public void setPaymentTokenDTO(ResponsePaymentTokenDTO paymentTokenDTO) {
        this.paymentTokenDTO = paymentTokenDTO;
    }

    
}
