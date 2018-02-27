package com.parque.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.parque.service.AssociacaoCartaoService;
import com.parque.service.ClienteService;
import com.parque.service.ContaService;
import com.parque.service.RecargaService;

public class Facade {

	@Autowired
	private ContaService contaService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RecargaService recargaService;
	
	@Autowired
	private AssociacaoCartaoService associacaoCartaoService;
	

	public ResponseEntity<?> getRecargasAll() {
		return this.recargaService.getAll();
	}

	public ResponseEntity<?> getContas() {
		return this.contaService.getContas();
	}
	
	public ResponseEntity<?> getAssociacoesCartao() {
		return this.associacaoCartaoService.getAll();
	}

	public ResponseEntity<?> getClientes() {
		return this.clienteService.getClientes();
	}
	
	public ResponseEntity<?> getContasClientes() {
		return this.clienteService.getClientesWidhConta();
	}

	public ResponseEntity<?> getContasByNameCliente(String name) {
		return this.contaService.getContasByNameCliente(name);
	}
	
	public ResponseEntity<?> getDependentesByIdCliente(Long id) {
		return this.clienteService.getDependentesByIdCliente(id);
	}
	
	public ResponseEntity<?> saveConta() {
		return this.contaService.saveConta(null);
	}
	
	public ResponseEntity<?> associarConta(Long idConta) {
		return this.contaService.associarConta(idConta);
	}
	
	public ResponseEntity<?> loadContaByCartao(String cod) {
		return this.contaService.loadContaByCartao(cod);
	}
	
	public ResponseEntity<?> recarregarCartao(Long id, double valor) {
		return this.recargaService.recarregarCartao(id, valor);
	}

	public ResponseEntity<?> saveCliente() {
		return this.clienteService.saveCliente(null);
	}

	public ResponseEntity<?> getClienteById(Long id) {
		return this.clienteService.getClienteById(id);
	}
	
	public ResponseEntity<?> getAssociacaoContaById(Long id) {
		return this.associacaoCartaoService.getById(id);
	}

	public ResponseEntity<?> getContaById(Long id) {
		return this.contaService.getContaById(id);
	}
    
}
