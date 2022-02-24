package core.dto.response;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserResponseDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String userName;

  private String email;

  private String roles;
  
  private String firstName;

  private String lastName;
  
  private Date createAt;
  
  private Date updateAt;
  
  private int status;

}
