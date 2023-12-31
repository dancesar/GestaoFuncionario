package com.gestao.GestaoFuncionario.repository;


import com.gestao.GestaoFuncionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
