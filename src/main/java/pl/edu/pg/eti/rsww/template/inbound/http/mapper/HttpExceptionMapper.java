package pl.edu.pg.eti.rsww.template.inbound.http.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.Error;
import pl.edu.pg.eti.rsww.template.logic.exception.ValidationException;

@Slf4j
@ControllerAdvice
public class HttpExceptionMapper {

    @ExceptionHandler
    public ResponseEntity<Error> handleException(Exception exception) {
        final ResponseEntity<Error> errorEntity;
        if (exception instanceof ValidationException) {
            errorEntity = createResponse(exception, HttpStatus.BAD_REQUEST);
        } else {
            log.error("Unhandled exception: ", exception);
            errorEntity = createResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return errorEntity;
    }

    private ResponseEntity<Error> createResponse(Exception exception, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new Error(status.value(), exception.getMessage()));
    }
}
