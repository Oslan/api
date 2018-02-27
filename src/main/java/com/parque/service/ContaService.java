package com.parque.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parque.dao.AssociacaoCartaoDAO;
import com.parque.dao.CartaoDAO;
import com.parque.dao.ClienteDAO;
import com.parque.dao.ContaDAO;
import com.parque.domain.AssociacaoCartao;
import com.parque.domain.Cartao;
import com.parque.domain.Cliente;
import com.parque.domain.Conta;
import com.parque.dto.ClienteDTO;
import com.parque.dto.ContaDTO;
import com.parque.dto.Error;


@Service
public class ContaService {
	
	
	private ClienteDAO clienteDAO;
	private CartaoDAO cartaoDAO;
	private ContaDAO contaDAO;
	
	@Autowired
	private AssociacaoCartaoService associacaoCartaoService;
	
	public ResponseEntity<?> loadContaByCartao(String codigo){
		Conta conta= null;
		Error error = new Error();
		
		conta = contaDAO.getInstance().getContaByCartao(codigo);
		if(conta != null) {
			error.setCod(200); error.setMsg("success"); error.setObj(conta);
		}
		else {
			error.setCod(401); error.setMsg("Nenhum cartão encontrado!"); error.setObj(conta);
		}
		
		return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(error);
	}
	
	public ResponseEntity<?> associarConta(Long id) {
		AssociacaoCartao associacaoCartao=null;
		Error error = new Error();
		Conta conta = contaDAO.getInstance().getById(id);
		Cartao cartao = new Cartao();
		cartao.setCodigo("123456789000098009448");
		
		conta.setCartao(cartao);
		
		associacaoCartao= this.associacaoCartaoService.saveAssociacaoCartao(conta);
		
		error.setMsg("success");
		error.setCod(200);
		error.setObj(associacaoCartao);
		
		return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(error);
    			
	}
	
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
		  Error error = new Error();
		
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
