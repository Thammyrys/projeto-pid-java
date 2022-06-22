package com.projetoloja.services;

import com.projetoloja.models.ClienteModel;

import java.util.List;

public interface ClienteService {

    void cadastrarCliente(ClienteModel cliente);
    void excluirCliente(Long idCliente);
    List<ClienteModel> listarClientes();

    ClienteModel buscarCliente(Long idCliente);

}
