package com.mingi.controller.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.mingi.controller.valid")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
    	
    	StringBuilder errorMessage = new StringBuilder("Validation failed: ");
    	ex.getBindingResult().getFieldErrors().forEach(error -> { 
    		errorMessage.append(error.getField())
    		.append(" - ")
    		.append(error.getDefaultMessage())
    		.append(";");
    	});
    	
        return new ResponseEntity<>("Validation failed: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
