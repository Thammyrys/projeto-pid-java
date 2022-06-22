package com.projetoloja.repository;

import com.projetoloja.models.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, String> {
    ClienteModel findById(Long id);

    ClienteModel findByNomeCliente(String nomeCliente);
}
