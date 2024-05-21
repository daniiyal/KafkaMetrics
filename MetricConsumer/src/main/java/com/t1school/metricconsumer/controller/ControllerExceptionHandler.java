package com.t1school.metricconsumer.controller;

import com.t1school.metricconsumer.model.ResultMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResultMessage> argumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResultMessage(ex.getMessage()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ResultMessage> notFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResultMessage("Не найдена конечная точка для запроса"));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResultMessage> notFoundException(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ResultMessage(String.format("Неправильно указан HTTP метод для запроса. %s", ex.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultMessage> otherException() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResultMessage("Произошла непредвиденная ошибка"));
    }
}
