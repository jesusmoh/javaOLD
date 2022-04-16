package core.dto.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserResponseDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String username;

  private String email;

  private String roles;
  
  private String firstname;

  private String lastname;
  
  private Date createAt;
  
  private Date updateAt;
  
  private int status;

}
