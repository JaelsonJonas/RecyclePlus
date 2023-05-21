package br.com.recycleplus.exceptions;

public class RestNotFoundException extends RuntimeException{
    
    public RestNotFoundException(String message) {
        super(message);
    }
}
