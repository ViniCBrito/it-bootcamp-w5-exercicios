package br.com.meli.qa_bugs.controller;

import br.com.meli.qa_bugs.dto.ErrorDTO;
import br.com.meli.qa_bugs.exception.TestCaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TestCaseExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ErrorDTO>> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<ObjectError> erros = e.getBindingResult().getAllErrors();
        List<ErrorDTO> results = new ArrayList<ErrorDTO>();
        erros.forEach(x -> {
            ErrorDTO error = new ErrorDTO("Campo inválido.", x.getDefaultMessage());
            results.add(error);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(results);
    }

    @ExceptionHandler(TestCaseNotFoundException.class)
    protected ResponseEntity<Object> handleTestCaseNotFoundException(TestCaseNotFoundException e) {
        ErrorDTO errorDTO = new ErrorDTO("Recurso não encontrado.", e.getMessage());
//        return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
