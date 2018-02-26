package com.parque.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parque.dao.ClienteDAO;
import com.parque.dao.ContaDAO;
import com.parque.domain.Cliente;
import com.parque.domain.Conta;
import com.parque.dto.ClienteDTO;
import com.parque.dto.ContaDTO;
import com.parque.dto.ErrorList;

@Service
public class ContaService {
	
	
	private ClienteDAO clienteDAO;
	private ContaDAO contaDAO;
	
	 public ResponseEntity<?>saveConta(Conta conta){
		 
		 Cliente cliente=null;
		
		 cliente = clienteDAO.getInstance().getById(1L);

		conta = new Conta();
		
		 conta.setLimite(new BigDecimal(0.0d));
		 conta.setNumero("123456789-02");
		 conta.setSaldo(new BigDecimal(0.0d));
			 
	     conta.setCliente(cliente);
	     System.out.println(conta.getCliente().getNome());
		 
		contaDAO.getInstance().persist(conta);
	    	return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body("OK");
	  }
	 
	
	  public ResponseEntity<?>getContas(){
	    	return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(this.contaDAO.getInstance().findAll());
	  }
	  
	
	  public ResponseEntity<?>getContasByNameCliente(String name){
		  ErrorList error = new ErrorList();
		
		List contas= this.contaDAO.getInstance().getContasByNameCliente(name);
		 System.out.println("TAM " + contas.size());

		 error.setObj(contas);
		 
		 
		 if(contas.size()>0) {
			 error.setCod(200);
			 error.setMsg("success");
			
		 }
		 else {
			 error.setCod(404);
			 error.setMsg("Nenhum dado encontrado!");
			
		 }
	    	return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(error);
	  }
	  
	  public ResponseEntity<?>getContaById(Long id){
			 
			Conta  conta = contaDAO.getInstance().getById(id);

		    	return ResponseEntity
		    			.status(HttpStatus.OK)
		    			.body(conta);
		    	
		  }
	 
	
}
