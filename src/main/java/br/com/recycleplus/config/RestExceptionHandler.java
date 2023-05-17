package br.com.recycleplus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.recycleplus.DTO.ReturnAPI;
import br.com.recycleplus.exceptions.RestNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {
    
    Logger log = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(RestNotFoundException.class)

    public ResponseEntity<ReturnAPI> RestNotFoundHandler(RestNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ReturnAPI(e.getMessage()));

    }
}
