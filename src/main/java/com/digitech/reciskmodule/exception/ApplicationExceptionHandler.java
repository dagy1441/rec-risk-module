package com.digitech.reciskmodule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errorMessage = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.put(error.getField(), error.getDefaultMessage());
        });
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorHandler> handleException(EntityNotFoundException exception, WebRequest request){
        final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
        final ErrorHandler ERROR_HANDLER = ErrorHandler.builder()
                .errorCode(exception.getErrorCode())
                .httpStatus(NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(ERROR_HANDLER, NOT_FOUND);
    }

}
