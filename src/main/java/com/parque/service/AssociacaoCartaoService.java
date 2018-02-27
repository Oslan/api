package com.parque.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.parque.dao.AssociacaoCartaoDAO;
import com.parque.dao.ContaDAO;
import com.parque.domain.AssociacaoCartao;
import com.parque.domain.Conta;
import com.parque.dto.Error;

@Service
public class AssociacaoCartaoService {
	
	private AssociacaoCartaoDAO associacaoCartaoDAO;
	private ContaDAO contaDAO;
	
	 public AssociacaoCartao saveAssociacaoCartao(Conta conta){
		 
		 contaDAO.getInstance().persist(conta);
			AssociacaoCartao associacaoCartao= new AssociacaoCartao();
			associacaoCartao.setCodigo("1234567890");
			associacaoCartao.setData(Calendar.getInstance());
			associacaoCartao.setConta(conta);
			associacaoCartao.setRecarga(null);
				
			associacaoCartaoDAO.getInstance().persist(associacaoCartao);
			
			return associacaoCartao;
			 
			
		 } 
		
	 public ResponseEntity<?> getById(Long id){
		 
		 Error error = new Error();
		 
		 AssociacaoCartao associacaoCartao = associacaoCartaoDAO.getInstance().getById(id);
		 
		 if(associacaoCartao != null) {
			 error.setCod(200);
			 error.setMsg("success");
			 error.setObj(associacaoCartao);
		 }
		 else {
			 error.setCod(200);
			 error.setMsg("Nenhum dado encontrado!");
			 error.setObj(null);
		 }
		
		 
		 return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(error);
	 }
	 
	 public ResponseEntity<?> getAll(){
		 
		 Error error = new Error();
		 
		 List<AssociacaoCartao> list = associacaoCartaoDAO.getInstance().findAll();

		 if(list.size()>0) {
			 error.setCod(200);
			 error.setMsg("success");
			 error.setObj(list);
		 }else {
			 
			 error.setCod(200);
			 error.setMsg("Nenhum dado encontrado!");
			 error.setObj(list);
		 }
		 
		 return ResponseEntity
	    			.status(HttpStatus.OK)
	    			.body(error);
	 }

}
