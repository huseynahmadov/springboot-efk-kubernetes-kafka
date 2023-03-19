package microserviceapplication.exception;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleStudentNotFoundException(StudentNotFoundException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleValidationException(MethodArgumentNotValidException exception) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(CallNotPermittedException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExceptionResponse handleCallNotPermittedException(CallNotPermittedException exception) {
        return new ExceptionResponse(
                HttpStatus.SERVICE_UNAVAILABLE.value(), exception.getMessage());
    }

}
