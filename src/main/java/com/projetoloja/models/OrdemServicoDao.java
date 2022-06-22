package com.projetoloja.models;

import javax.validation.constraints.NotNull;

public class OrdemServicoDao {
    @NotNull
    private Long cliente;
    @NotNull
    private Long funcionario;

    public Long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Long funcionario) {
        this.funcionario = funcionario;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long nomeCliente) {
        this.cliente = nomeCliente;
    }
}
