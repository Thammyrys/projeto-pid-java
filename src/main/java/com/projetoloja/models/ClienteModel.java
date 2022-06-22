package com.projetoloja.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String nomeCliente;

	@NotBlank
	private String telefoneCliente;

	@NotBlank
	private String enderecoCliente;

	@NotBlank
	private String cepCliente;

	@NotBlank
	private String cpfCliente;

	@OneToMany(mappedBy="cliente")
	private List<AparelhoModel> aparelho;

	@OneToMany(mappedBy="cliente")
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
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getCepCliente() {
		return cepCliente;
	}
	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	
}
