package core.dto.request;
import java.io.Serializable;
import lombok.Data;

@Data
public class SignUpUserRequestDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String userName;

  private String email;

  private String firstName;

  private String lastName;
  
  private String password;
  
  private String phone;
  
  private String pin;

}
