package com.parque.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ContaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String numero;
	private BigDecimal saldo;
	private BigDecimal limite;
	private ClienteDTO cliente;
	
	public ContaDTO(Long id, String numero, BigDecimal saldo, BigDecimal limite,ClienteDTO clienteDTO) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
		this.cliente = clienteDTO;
	}
	
	public ContaDTO(Long id, String numero, ClienteDTO clienteDTO) {
		super();
		this.id = id;
		this.numero = numero;
		this.cliente = clienteDTO;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public BigDecimal getLimite() {
		return limite;
	}
	
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO clienteDTO) {
		this.cliente = clienteDTO;
	}
	
	
}
