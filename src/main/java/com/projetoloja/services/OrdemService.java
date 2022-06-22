package com.projetoloja.services;

import com.projetoloja.models.OrdemServicoModel;

public interface OrdemService {
    Integer inserirOrdem(OrdemServicoModel ordem) throws Exception;
}
