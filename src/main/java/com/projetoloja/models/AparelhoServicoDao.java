package com.projetoloja.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AparelhoServicoDao {
    @NotEmpty
    private String nomeAparelho;
    @NotEmpty
    private String marcaAparelho;
    @NotEmpty
    private String modeloAparelho;
    @NotEmpty
    private String numeroSerie;
    @NotEmpty
    private String descricaoDefeito;
    @NotEmpty
    private String atendente;
    @NotNull
    private Long numOrdemServico;
    @NotEmpty
    private String cliente;

    public String getNomeAparelho() {
        return nomeAparelho;
    }

    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }

    public String getMarcaAparelho() {
        return marcaAparelho;
    }

    public void setMarcaAparelho(String marcaAparelho) {
        this.marcaAparelho = marcaAparelho;
    }

    public String getModeloAparelho() {
        return modeloAparelho;
    }

    public void setModeloAparelho(String modeloAparelho) {
        this.modeloAparelho = modeloAparelho;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescricaoDefeito() {
        return descricaoDefeito;
    }

    public void setDescricaoDefeito(String descricaoDefeito) {
        this.descricaoDefeito = descricaoDefeito;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public Long getNumOrdemServico() {
        return numOrdemServico;
    }

    public void setNumOrdemServico(Long numOrdemServico) {
        this.numOrdemServico = numOrdemServico;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
