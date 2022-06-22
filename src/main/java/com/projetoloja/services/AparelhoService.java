package com.projetoloja.services;

import com.projetoloja.models.AparelhoModel;

import java.util.List;

public interface AparelhoService {

    void cadastrarAparelho(AparelhoModel aparelho);
    List<AparelhoModel> listarAparelhos();

}
