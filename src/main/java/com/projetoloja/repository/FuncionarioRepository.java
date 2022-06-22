package com.projetoloja.repository;

import com.projetoloja.models.FuncionarioModel;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<FuncionarioModel, String> {
    FuncionarioModel findById(Long id);
    FuncionarioModel findByNomeFunc(String nomeFunc);
}
