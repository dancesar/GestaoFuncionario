package com.gestao.GestaoFuncionario.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String funcao;
    private String fone;
    private String endereco;
    private BigDecimal salario;
}
