package core.validator;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomErrorMessage {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public CustomError customErrorMessage(MethodArgumentNotValidException ex) {
		
		CustomError customError = new CustomError();
		BindingResult errResult = ex.getBindingResult();
		Map<String,String> errMap = new HashMap<String,String>();
		errResult.getFieldErrors().forEach( err -> {
			System.out.println("ERROR ->"+ err.getDefaultMessage());
			String code = err.getDefaultMessage().split("~~")[0];
			String message = err.getDefaultMessage().split("~~")[1];
			errMap.put(code, message);
		});

		customError.setErrorMsg(errMap);
		return customError;
	}

}
