package com.gestao.GestaoFuncionario.handler;

import com.gestao.GestaoFuncionario.entity.ErrorResponse;
import com.gestao.GestaoFuncionario.entity.ErrorResponse.ErrorResponseBuilder;
import com.gestao.GestaoFuncionario.exception.FuncionarioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(FuncionarioException.class)
    public ResponseEntity<ErrorResponse> hamdlerFuncionarioException(FuncionarioException m) {
        ErrorResponseBuilder erro = ErrorResponse.builder();
        erro.httpStatus(m.getHttpStatus().value());
        erro.mensagem(m.getMessage());
        erro.timeStamp(System.currentTimeMillis());
        return ResponseEntity.status(m.getHttpStatus()).body(erro.build());
    }
}
