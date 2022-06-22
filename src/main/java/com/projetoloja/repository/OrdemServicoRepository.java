package com.projetoloja.repository;

import com.projetoloja.models.ClienteModel;
import com.projetoloja.models.OrdemServicoModel;
import org.springframework.data.repository.CrudRepository;

public interface OrdemServicoRepository extends CrudRepository<OrdemServicoModel, String> {
    OrdemServicoModel findById(Long id);

    Iterable<OrdemServicoModel> findBycliente(ClienteModel cliente);
}
