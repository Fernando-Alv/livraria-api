package com.meusprojetos.livraria.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LivroJaDevolvidoException extends RuntimeException {
    public LivroJaDevolvidoException(String message) {
        super(message);
    }
}
