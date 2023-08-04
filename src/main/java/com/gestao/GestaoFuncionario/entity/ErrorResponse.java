package com.gestao.GestaoFuncionario.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    private String mensagem;
    private Integer httpStatus;
    private Long timeStamp;
}
