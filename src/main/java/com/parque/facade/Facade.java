package com.parque.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.parque.service.ClienteService;
import com.parque.service.ContaService;

public class Facade {

	@Autowired
	private ContaService contaService;

	@Autowired
	private ClienteService clienteService;

	public ResponseEntity<?> getContas() {

		return this.contaService.getContas();
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

	public ResponseEntity<?> saveCliente() {

		return this.clienteService.saveCliente(null);

	}

	public ResponseEntity<?> getClienteById(Long id) {

		return this.clienteService.getClienteById(id);
	}

	public ResponseEntity<?> getContaById(Long id) {

		return this.contaService.getContaById(id);
	}
    
}
