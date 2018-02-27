package com.parque.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parque.dao.ContaDAO;
import com.parque.dao.RecargaDAO;
import com.parque.domain.Cliente;
import com.parque.domain.Conta;
import com.parque.domain.Recarga;
import com.parque.dto.Error;

@Service
public class RecargaService {

	private RecargaDAO recargaDAO;
	private ContaDAO contaDAO;
	
	public ResponseEntity<?> recarregarCartao(Long idConta,double valor){
		
			Conta conta = contaDAO.getInstance().getById(idConta);
			conta.setSaldo(conta.getSaldo().add(new BigDecimal(valor)));
			
		 	Error error = new Error();
		 	
		 	ContaDAO.getInstance().merge(conta);
		 	
		 	Recarga recarga = new Recarga();
		 	recarga.setCalendar(Calendar.getInstance());
		 	recarga.setCodigo("1234567890-0");
		 	recarga.setValor(new BigDecimal(valor));
		 	recarga.setConta(conta);
		 	
		
		 	
		 	recargaDAO.getInstance().persist(recarga);
		 	error.setCod(200);
		 	error.setMsg("success");
		    error.setObj(recarga);
		    
		    
			 return ResponseEntity
		    			.status(HttpStatus.OK)
		    			.body(error);
			
		 } 
	
	
	public ResponseEntity<?> getRecargaById(Long id){
		Error error = new Error();
		
		Recarga recarga= recargaDAO.getInstance().getById(id);
		if(recarga != null) {
			
		error.setCod(200);
	 	error.setMsg("success");
	    error.setObj(recarga);
	    
		}else {
			error.setCod(401);
		 	error.setMsg("Nenhum dado encontrado");
		    error.setObj(recarga);
		}
		
		 return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(error);
	}
	
	public ResponseEntity<?> getAll(){
		Error error = new Error();
		List<Recarga> recargas =null;
		
		recargas= recargaDAO.getInstance().findAll();
		if(recargas.size() >0) {
			
		error.setCod(200);
	 	error.setMsg("success");
	    error.setObj(recargas);
	    
		}else {
			error.setCod(401);
		 	error.setMsg("Nenhum dado encontrado");
		    error.setObj(recargas);
		}
		
		 return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(error);
	}
	
}
