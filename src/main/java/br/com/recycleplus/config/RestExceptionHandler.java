package br.com.recycleplus.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.recycleplus.DTO.RestValidationError;
import br.com.recycleplus.DTO.ReturnAPI;
import br.com.recycleplus.exceptions.RestNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(RestNotFoundException.class)

    public ResponseEntity<ReturnAPI> RestNotFoundHandler(RestNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReturnAPI(e.getMessage()));

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ReturnAPI> HttpRequestMethodNotSupportedHandler(HttpRequestMethodNotSupportedException e){
      
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new ReturnAPI(e.getMessage()));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationError>> MethodArgumentNotValidHandler(MethodArgumentNotValidException e) {// escre

        log.error("Erro de validação");
        List<RestValidationError> fieldErrors = new ArrayList<>();

        e.getFieldErrors().forEach(r -> fieldErrors.add(new RestValidationError(r.getField(), r.getDefaultMessage())));

        return ResponseEntity.badRequest().body(fieldErrors);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RestValidationError> HttpMessageNotReadabledHandler(HttpMessageNotReadableException e) {// escre

        log.error("Erro de validação");
        String field = "";
        String message = "";

        if (e instanceof HttpMessageNotReadableException ||
                e.getCause() instanceof HttpMessageNotReadableException) {
            InvalidFormatException causa = (InvalidFormatException) e.getCause();
            field = causa.getPath().get(0).getFieldName();
            message = "";
            if (field.equals("data")) {
                message = "O formato deve ser yyyy-MM-dd";
            } else {
                message = "O formato deve ser HH:mm:ss";
            }
        }
        return ResponseEntity.badRequest().body(new RestValidationError(field, message));
    }

}
