package com.gestao.GestaoFuncionario.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FuncionarioDto {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String funcao;
    @NotBlank
    private String fone;
    @NotBlank
    private String endereco;
    private BigDecimal salario;
}
