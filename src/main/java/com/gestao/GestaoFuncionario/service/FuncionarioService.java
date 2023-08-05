package com.gestao.GestaoFuncionario.service;

import com.gestao.GestaoFuncionario.entity.Funcionario;
import com.gestao.GestaoFuncionario.entity.dto.FuncionarioDto;
import com.gestao.GestaoFuncionario.exception.FuncionarioException;
import com.gestao.GestaoFuncionario.repository.IFuncionarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FuncionarioService implements IFuncionarioService {

    @Autowired
    private IFuncionarioRepository iFuncionarioRepository;

    private Logger logger = Logger.getLogger(Funcionario.class.getName());

    @Override
    public Boolean cadastrarFuncionario(FuncionarioDto funcionarioDto) {
        try{
            ModelMapper mapper = new ModelMapper();
            Funcionario funcionario = mapper.map(funcionarioDto, Funcionario.class);
            this.iFuncionarioRepository.save(funcionario);
            logger.info("Criado Funcionário!");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Funcionario> listarFuncionario() {
        try{
            logger.info("Listado todos funcionários!");
            return this.iFuncionarioRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Funcionario consultarFuncionario(Long id) {
        try {
            Optional<Funcionario> funcionarioOptional = this.iFuncionarioRepository.findById(id);
            if(funcionarioOptional.isPresent()) {
                logger.info("Encontrado funcionário: " + funcionarioOptional.get().getNome());
                return funcionarioOptional.get();
            }
            throw new FuncionarioException("Funcionário não encontrado.", HttpStatus.NOT_FOUND);
        } catch (FuncionarioException m) {
            throw m;
        } catch (Exception e) {
            throw new FuncionarioException("Erro interno identificado. Contate o suporte", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean atualizarFuncionario(FuncionarioDto funcionarioDto) {
        try {
            ModelMapper mapper = new ModelMapper();
            this.consultarFuncionario(funcionarioDto.getId());

            Funcionario funcionarioAtualizado = mapper.map(funcionarioDto, Funcionario.class);

            this.iFuncionarioRepository.save(funcionarioAtualizado);

            logger.info("Funcionário Atualizado!");
            return Boolean.TRUE;
        } catch (FuncionarioException m) {
            throw m;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean excluirFuncionario(Long id) {
        try {
            this.consultarFuncionario(id);
            this.iFuncionarioRepository.deleteById(id);
            logger.info("Funcionário excluído!");
            return true;
        } catch (FuncionarioException m) {
            throw m;
        } catch (Exception e) {
            throw e;
        }
    }
}
