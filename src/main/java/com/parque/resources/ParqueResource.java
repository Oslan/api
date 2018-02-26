package com.parque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.parque.facade.Facade;

@Controller
public class ParqueResource {
	
	@Autowired
	private Facade facade;
	
	
	@RequestMapping(value="/contas/cliente",method=RequestMethod.GET)
	public  ResponseEntity<?> getContaByNameCliente(@RequestParam String name) {
		
		return facade.getContasByNameCliente(name);
		
	}
	
	@RequestMapping(value="/contas/clientes",method=RequestMethod.GET)
	public  ResponseEntity<?> getContasClientes() {
		
		return facade.getContasClientes();
		
	}
	
	
	@RequestMapping(value="/dependentes/cliente/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getDependentesById(@PathVariable("id") Long id) {
		
		return facade.getDependentesByIdCliente(id);
	}
	
	@RequestMapping(value="/contas",method=RequestMethod.GET)
	public ResponseEntity<?> getContas() {
		
		return facade.getContas(); 	
	}
	
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public ResponseEntity<?> getClientes() {
		
		return facade.getClientes();
	}
	
	@RequestMapping(value="/conta/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getContaById(@PathVariable("id") Long id) {
		
		return facade.getContaById(id);
	}
	
	@RequestMapping(value="/cliente/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
		
		return facade.getClienteById(id);
	}
	
	
	
	@RequestMapping(value="/conta/save",method=RequestMethod.GET)
	public ResponseEntity<?> save() {
	
		
		return facade.saveConta();
	}
	
	@RequestMapping(value="/cliente/save",method=RequestMethod.GET)
	public ResponseEntity<?> saveC() {
		
		
		return facade.saveCliente();
	}



}
