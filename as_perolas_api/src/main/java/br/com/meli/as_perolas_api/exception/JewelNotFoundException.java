package br.com.meli.as_perolas_api.exception;

public class JewelNotFoundException extends RuntimeException {
    public JewelNotFoundException(String message) {
        super("Não há nenhuma jóia com o número de identificação informado.\n".concat(message));
    }
}
