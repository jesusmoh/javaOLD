package core.dto.request;
import lombok.Data;

@Data
public class SignUpUserRequestDTO {

  private String userName;

  private String email;

  private String firstName;

  private String lastName;
  
  private String password;
  
  private String phone;
  
  private String pin;

}
