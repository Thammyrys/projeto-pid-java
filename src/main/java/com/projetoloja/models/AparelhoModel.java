package com.projetoloja.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "APARELHO")
public class AparelhoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String nomeAparelho;

	@NotBlank
	private String marcaAparelho;

	@NotBlank
	private String modeloAparelho;

	@NotBlank
	private String numeroSerie;

	@NotBlank
	private String descricaoDefeito;

	@ManyToOne
	@JoinColumn(name="ordem_servico_id", nullable=false)
	private OrdemServicoModel ordemServico;

	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false)
	private ClienteModel cliente;

	@ManyToOne
	@JoinColumn(name="funcionario_id", nullable=false)
	private FuncionarioModel funcionario;

	public OrdemServicoModel getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServicoModel ordemServico) {
		this.ordemServico = ordemServico;
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public FuncionarioModel getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
}
