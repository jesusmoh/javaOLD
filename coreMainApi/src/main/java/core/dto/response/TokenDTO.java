
package core.dto.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class TokenDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
}
