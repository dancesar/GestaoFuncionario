package com.gestao.GestaoFuncionario.controller;

import com.gestao.GestaoFuncionario.entity.Funcionario;
import com.gestao.GestaoFuncionario.entity.dto.FuncionarioDto;
import com.gestao.GestaoFuncionario.service.IFuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private IFuncionarioService iFuncionarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> cadastrarFuncionario(@Valid @RequestBody FuncionarioDto funcionarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.iFuncionarioService.cadastrarFuncionario(funcionarioDto));
    }

    @PutMapping(value = "{id}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> atualizarFuncionario(@Valid @RequestBody FuncionarioDto funcionarioDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.iFuncionarioService.atualizarFuncionario(funcionarioDto));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listaFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(this.iFuncionarioService.listarFuncionario());
    }

    @GetMapping(value ="{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> consultarFuncionarios(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.iFuncionarioService.consultarFuncionario(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteFuncionario(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.iFuncionarioService.excluirFuncionario(id));
    }
}
