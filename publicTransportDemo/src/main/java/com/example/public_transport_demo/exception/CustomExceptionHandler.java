package com.example.public_transport_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handle(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(getExceptionMessagesMap(exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handle(ResourceNotFoundException exception) {
        return new ResponseEntity<>(getExceptionMessagesMap(Collections.singletonList(exception.getMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, List<String>>> handle(RuntimeException exception) {
        return new ResponseEntity<>(getExceptionMessagesMap(Collections.singletonList(exception.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, List<String>>> handle(Exception exception) {
        return new ResponseEntity<>(getExceptionMessagesMap(Collections.singletonList(exception.getMessage())), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getExceptionMessagesMap(List<String> exceptionMessages) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("messages", exceptionMessages);
        return errorResponse;
    }

}
