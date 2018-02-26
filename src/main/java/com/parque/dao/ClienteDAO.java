package com.parque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.parque.domain.Cliente;

public class ClienteDAO {
	
	protected EntityManager entityManager;
	
	 private static ClienteDAO instance;
	 
	 public static ClienteDAO getInstance(){
         if (instance == null){
                  instance = new ClienteDAO();
         }
         
         return instance;
	 }
	 
	 private ClienteDAO() {
			System.out.println("CONSTRUCTOR");
         entityManager = getEntityManager();
	 }
	 
	 

	private EntityManager getEntityManager() {
		EntityManagerFactory factory=null;
		System.out.println("FACTORY");
		
		try {
			
		factory = Persistence.createEntityManagerFactory("crud");
		
		 if (entityManager == null) {
             entityManager = factory.createEntityManager();         
		 }
		 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return entityManager;

	}
	
	 public void persist(Cliente cliente) {
         try 
         {
                  entityManager.getTransaction().begin();
                  entityManager.persist(cliente);
                  entityManager.getTransaction().commit();
                  
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
	 }
	 
	 public Cliente getById(final Long id) {
         return entityManager.find(Cliente.class, id);
	 }
	 
	  @SuppressWarnings("unchecked")
      public List<Cliente> findAll() {
                return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
      }
	  
	  @SuppressWarnings("unchecked")
      public List getClientesWidhConta() {
		  List  list = null;
		  entityManager.getTransaction().begin();
		 	  
		  	Query query= entityManager.createQuery("SELECT c FROM Cliente c "
		  										  +"INNER JOIN Conta co ON "
		  										  +" c.id = co.id");
		  
		 
		  	list = query.getResultList();
		  		entityManager.getTransaction().commit();
		  		
		  		
		  	
		  
		  return list;
	  }
	  

}
