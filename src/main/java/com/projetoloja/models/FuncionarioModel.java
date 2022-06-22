package com.projetoloja.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "FUNCIONARIO")
public class FuncionarioModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotBlank
	String nomeFunc;
	@NotBlank
	String telefoneFunc;
	@NotBlank
	String enderecoFunc;
	@NotBlank
	String cepFunc;

	@OneToMany(mappedBy="funcionario")
	private List<AparelhoModel> aparelho;

	@OneToMany(mappedBy="funcionario")
	private List<OrdemServicoModel> ordemServico;

	public List<AparelhoModel> getAparelho() {
		return aparelho;
	}

	public void setAparelho(List<AparelhoModel> aparelho) {
		this.aparelho = aparelho;
	}

	public List<OrdemServicoModel> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServicoModel> ordemServico) {
		this.ordemServico = ordemServico;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeFunc() {
		return nomeFunc;
	}
	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	public String getTelefoneFunc() {
		return telefoneFunc;
	}
	public void setTelefoneFunc(String telefoneFunc) {
		this.telefoneFunc = telefoneFunc;
	}
	public String getEnderecoFunc() {
		return enderecoFunc;
	}
	public void setEnderecoFunc(String enderecoFunc) {
		this.enderecoFunc = enderecoFunc;
	}
	public String getCepFunc() {
		return cepFunc;
	}
	public void setCepFunc(String cepFunc) {
		this.cepFunc = cepFunc;
	}
	
	
}
