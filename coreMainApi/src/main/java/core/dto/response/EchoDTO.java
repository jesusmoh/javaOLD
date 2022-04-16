/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dto.response;

import lombok.Data;

@Data
public class EchoDTO {
    private final String version = "V2";
    private final String echo = "OK";
}
