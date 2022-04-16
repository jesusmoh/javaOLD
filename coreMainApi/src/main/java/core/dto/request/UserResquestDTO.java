package core.dto.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserResquestDTO implements Serializable{

  private static final long serialVersionUID = 1L;   
    
  private Integer id;

  private String username;

  private String email;

  private String roles;
  
  private String firstname;

  private String lastname;
  
  private int status;
  
  private String password;
  
  private String phone;
  
  private String pin;

}
