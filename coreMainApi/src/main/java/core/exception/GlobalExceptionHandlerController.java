package core.exception;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Value;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @Value("${exception.api.general.messages}")
    private String exceptionApiGeneralMessages;
    
    @ExceptionHandler(CustomException.class)
    public void handleCustomException(HttpServletResponse res, CustomException ex) throws IOException {
        res.sendError(ex.getHttpStatus().value(), exceptionApiGeneralMessages.concat(ex.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(HttpServletResponse res) throws IOException {
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
    }

    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletResponse res) throws IOException {
        res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleExceptionConstraintViolationException(HttpServletResponse res, ConstraintViolationException ex) throws IOException {
        String m = "";
        for (ConstraintViolation cv : ex.getConstraintViolations()) {
            m = cv.getMessage() + " Error in value " + (cv.getInvalidValue() == null ? "null" : cv.getInvalidValue().toString() + " and field " + cv.getPropertyPath().toString());
        }
        res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), exceptionApiGeneralMessages.concat(m));
    }

}
