package core.dto.request;

import lombok.Data;

@Data
public class UserResquestDTO {


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
