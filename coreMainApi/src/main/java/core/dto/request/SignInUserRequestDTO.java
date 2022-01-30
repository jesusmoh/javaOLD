/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dto.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class SignInUserRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String password;
}
