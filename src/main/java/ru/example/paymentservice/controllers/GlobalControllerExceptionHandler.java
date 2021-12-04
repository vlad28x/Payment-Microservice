package ru.example.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.example.paymentservice.exceptions.BadRequestException;
import ru.example.paymentservice.exceptions.InvalidUserDataException;
import ru.example.paymentservice.exceptions.JwtAuthenticationException;
import ru.example.paymentservice.exceptions.NotFoundException;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleNotFound(NotFoundException e) {
        Response response = new Response();
        response.time = LocalDateTime.now();
        response.message = e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleBadRequest(BadRequestException e) {
        Response response = new Response();
        response.time = LocalDateTime.now();
        response.message = e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<Response> handleJwtAuthenticationException(JwtAuthenticationException e) {
        Response response = new Response();
        response.time = LocalDateTime.now();
        response.message = e.getMessage();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(InvalidUserDataException.class)
    public ResponseEntity<Response> handleInvalidUserData(InvalidUserDataException e) {
        Response response = new Response();
        response.time = LocalDateTime.now();
        response.message = e.getMessage();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    private class Response {
        private LocalDateTime time;
        private String message;

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
