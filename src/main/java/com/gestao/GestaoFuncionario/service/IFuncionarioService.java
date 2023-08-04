package com.gestao.GestaoFuncionario.service;

import com.gestao.GestaoFuncionario.entity.Funcionario;
import com.gestao.GestaoFuncionario.entity.dto.FuncionarioDto;

import java.util.List;

public interface IFuncionarioService {

    public Boolean cadastrarFuncionario(final FuncionarioDto funcionarioDto);
    public List<Funcionario> listarFuncionario();
    public Funcionario consultarFuncionario(final Long id);
    public Boolean atualizarFuncionario(final FuncionarioDto funcionarioDto);
    public Boolean excluirFuncionario(final Long id);
}
