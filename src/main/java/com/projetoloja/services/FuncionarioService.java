package com.projetoloja.services;

import com.projetoloja.models.FuncionarioModel;

import java.util.List;

public interface FuncionarioService {

    void cadastrarFuncionario(FuncionarioModel cliente);
    void excluirFuncionario(Long idFuncionario);
    List<FuncionarioModel> listarFuncionarios();

    FuncionarioModel buscarFuncionario(Long idFuncionario);
}
