package com.projetoloja.repository;

import com.projetoloja.models.AparelhoModel;
import com.projetoloja.models.ClienteModel;
import com.projetoloja.models.OrdemServicoModel;
import org.springframework.data.repository.CrudRepository;

public interface AparelhoRepository extends CrudRepository<AparelhoModel, String> {
    AparelhoModel findById(Long id);

    Iterable<AparelhoModel> findByCliente(ClienteModel cliente);

    Iterable<AparelhoModel> findByOrdemServico(OrdemServicoModel ordemServico);
}
