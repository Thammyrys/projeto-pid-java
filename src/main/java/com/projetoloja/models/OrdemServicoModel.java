package com.projetoloja.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServicoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataEntrada;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataSaida;

//	private boolean garantia;
//
	@OneToMany(mappedBy="ordemServico")
	private List<AparelhoModel> aparelho;

	@OneToOne
	@JoinColumn(name = "funcionario_id")
	private FuncionarioModel funcionario;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private ClienteModel cliente;

	public FuncionarioModel getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
//	public boolean isGarantia() {
//		return garantia;
//	}
//	public void setGarantia(boolean garantia) {
//		this.garantia = garantia;
//	}
	
}
