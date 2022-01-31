package core.dto.response;

import java.util.Date;
import lombok.Data;

@Data
public class UserResponseDTO {


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
