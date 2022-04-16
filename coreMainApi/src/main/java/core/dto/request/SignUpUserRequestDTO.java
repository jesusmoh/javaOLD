package core.dto.request;
import java.io.Serializable;
import lombok.Data;

@Data
public class SignUpUserRequestDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String username;

  private String email;

  private String firstname;

  private String lastname;
  
  private String password;
  
  private String phone;
  
  private String pin;

}
