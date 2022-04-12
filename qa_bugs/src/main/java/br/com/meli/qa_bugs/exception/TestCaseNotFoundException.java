package br.com.meli.qa_bugs.exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(String message) {
        super("Não foi encontrado caso de teste com os parâmetros informados.".concat(message));
    }
}
