package com.parque.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.parque.domain.Cartao;


public class CartaoDAO {

	protected EntityManager entityManager;
	
	 private static CartaoDAO instance;
	 
	 public static CartaoDAO getInstance(){
        if (instance == null){
                 instance = new CartaoDAO();
        }
        
        return instance;
	 }
	 
	 private CartaoDAO() {
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
	
	 public void persist(Cartao cartao) {
         try 
         {
                  entityManager.getTransaction().begin();
                  entityManager.persist(cartao);
                  entityManager.getTransaction().commit();
                  
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
	 }
}
