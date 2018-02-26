package com.parque.dto;

import java.io.Serializable;
import java.math.BigDecimal;



public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private BigDecimal limite;
	private EnderecoDTO enderecoDTO;
	
	
	
	public ClienteDTO(Long id, String nome, String email, EnderecoDTO enderecoDTO) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.enderecoDTO = enderecoDTO;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}
	
	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	
	
}
