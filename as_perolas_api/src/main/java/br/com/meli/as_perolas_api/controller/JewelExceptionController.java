package br.com.meli.as_perolas_api.controller;

import br.com.meli.as_perolas_api.exception.JewelNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JewelExceptionController {

    @ExceptionHandler(JewelNotFoundException.class)
    public ResponseEntity JewelNotFoundHandler(JewelNotFoundException e) {
        String bodyOfResponse = e.getMessage();
        return ResponseEntity.badRequest().body(bodyOfResponse);
    }
}
