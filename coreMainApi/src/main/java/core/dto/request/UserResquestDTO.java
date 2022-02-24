package core.dto.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserResquestDTO implements Serializable{

  private static final long serialVersionUID = 1L;   
    
  private Integer id;

  private String userName;

  private String email;

  private String roles;
  
  private String firstName;

  private String lastName;
  
  private int status;
  
  private String password;
  
  private String phone;
  
  private String pin;

}
