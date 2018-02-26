package com.parque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parque.domain.Cliente;
import com.parque.domain.Conta;

public class ContaDAO {
	
	protected EntityManager entityManager;
	
	private static ContaDAO instance;
	 
	 public static ContaDAO getInstance(){
        if (instance == null){
                 instance = new ContaDAO();
        }
        
        return instance;
	 }
	 
	 private ContaDAO() {
        entityManager = getEntityManager();
	 }
	 

	private EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud");
       if (entityManager == null) {
                entityManager = factory.createEntityManager();
       }

       return entityManager;
	
	}
	
	 public void persist(Conta conta) {
        try {
        	System.out.println(conta.getCliente().getId());
                 entityManager.getTransaction().begin();
                 entityManager.persist(conta);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
	 }
	 
	 public Conta getById(final Long id) {
         return entityManager.find(Conta.class, id);
	 }
	 
	  @SuppressWarnings("unchecked")
      public List<Conta> findAll() {
                return entityManager.createQuery("FROM " + Conta.class.getName()).getResultList();
      }
	  
	  
	  public List<Conta> getContasByNameCliente(String name){
		  List <Conta> list = null;
		  entityManager.getTransaction().begin();
		 	  
		  	Query query= entityManager.createQuery("SELECT c FROM Conta c WHERE c.cliente.nome LIKE :name");
		  	query.setParameter("name", "%" + name + "%");
		 
		  	list = query.getResultList();
		  		entityManager.getTransaction().commit();
		  	
		  
		  return list;
	  }
	  
}
