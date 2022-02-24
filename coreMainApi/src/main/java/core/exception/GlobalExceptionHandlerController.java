package core.exception;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Value;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @Value("${exception.api.general.messages}")
    private String exceptionApiGeneralMessages;
    
    static final Logger log = Logger.getLogger(GlobalExceptionHandlerController.class.getName());
    
    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
        UUID uuid = UUID.randomUUID();
        String temp= String.valueOf(" >> "+uuid +" >> " +exceptionApiGeneralMessages.concat(ex.getMessage()));
        log.log(Level.SEVERE, temp);
        res.sendError(ex.getHttpStatus().value(), temp );
    }

    @ExceptionHandler(value = {AccessDeniedException.class,org.springframework.security.access.AccessDeniedException.class})
    public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
        UUID uuid = UUID.randomUUID();
        String temp= String.valueOf(" >> "+uuid +" >> ");
        log.log(Level.SEVERE, temp);
        res.sendError(HttpStatus.FORBIDDEN.value(), temp+" Access denied");
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleExceptionConstraintViolationException(HttpServletResponse res, ConstraintViolationException ex) throws IOException {
        String temp = "";
        for (ConstraintViolation cv : ex.getConstraintViolations()) {
            temp = cv.getMessage() + " Error in value " + (cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString() + " and field " + cv.getPropertyPath().toString());
        }
        UUID uuid = UUID.randomUUID();
        temp= temp+" "+String.valueOf(" >> "+uuid +" >> " +exceptionApiGeneralMessages.concat(ex.getMessage()));
        log.log(Level.SEVERE, temp);
        res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), temp);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res) throws IOException {
         UUID uuid = UUID.randomUUID();
        String temp= String.valueOf(" >> "+uuid +" >> ");
        log.log(Level.SEVERE, temp);
        res.sendError(HttpStatus.BAD_REQUEST.value(), temp+" Something went wrong");
    }



}
