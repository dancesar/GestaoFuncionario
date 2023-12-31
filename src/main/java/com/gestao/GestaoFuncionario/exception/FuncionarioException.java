package com.gestao.GestaoFuncionario.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FuncionarioException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public FuncionarioException(final String mensagem, final HttpStatus httpStatus){
        super(mensagem);
        this.httpStatus = httpStatus;
    }
}
