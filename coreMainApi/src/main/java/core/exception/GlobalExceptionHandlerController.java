package core.exception;

import core.util.LogAuditFactory;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @Value("${exception.api.general.messages}")
    private String exceptionApiGeneralMessages;
    
    static final Logger log = Logger.getLogger(GlobalExceptionHandlerController.class.getName());
    
    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
        String fullMessage= String.valueOf(" >> "+LogAuditFactory.getKey()+" >> " +exceptionApiGeneralMessages.concat(ex.getMessage()));
        log.log(Level.SEVERE, fullMessage);
        res.sendError(ex.getHttpStatus().value(),fullMessage );
    }

    @ExceptionHandler(value = {AccessDeniedException.class,org.springframework.security.access.AccessDeniedException.class})
    public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
        String fullMessage= String.valueOf(" >> "+LogAuditFactory.getKey() +" >> ");
        log.log(Level.SEVERE, fullMessage);
        res.sendError(HttpStatus.FORBIDDEN.value(), fullMessage+" Access-denied");
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleExceptionConstraintViolationException(HttpServletResponse res, ConstraintViolationException ex) throws IOException {
        String fullMessage = "";
        for (ConstraintViolation cv : ex.getConstraintViolations()) {
            fullMessage = cv.getMessage() + " Error in value " + (cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString() + " and field " + cv.getPropertyPath().toString());
        }
        fullMessage= fullMessage+" "+String.valueOf(" >> "+LogAuditFactory.getKey() +" >> " +exceptionApiGeneralMessages.concat(ex.getMessage()));
        log.log(Level.SEVERE, fullMessage);
        res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), fullMessage);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res ,Exception ex) throws IOException {
        String temp= String.valueOf(" >> "+LogAuditFactory.getKey() +" >> ");
        log.log(Level.SEVERE, temp +ex.getMessage().toString());
        res.sendError(HttpStatus.BAD_REQUEST.value(), temp+" Something went wrong");
    }



}
