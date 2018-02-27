package com.parque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.parque.domain.AssociacaoCartao;


public class AssociacaoCartaoDAO {

	 protected EntityManager entityManager;
	
	 private static AssociacaoCartaoDAO instance;
	 
	 public static AssociacaoCartaoDAO getInstance(){
        if (instance == null){
                 instance = new AssociacaoCartaoDAO();
        }
        
        return instance;
	 }
	 
	 private AssociacaoCartaoDAO() {
		
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
	
	 public void persist(AssociacaoCartao associacaoCartao) {
         try 
         {
                  entityManager.getTransaction().begin();
                  entityManager.persist(associacaoCartao);
                  entityManager.getTransaction().commit();
                  
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
	 }
	 
	 public AssociacaoCartao  getById(final Long id) {
         return entityManager.find(AssociacaoCartao.class, id);
	 }
	 
	  @SuppressWarnings("unchecked")
      public List<AssociacaoCartao> findAll() {
                return entityManager.createQuery("FROM " + AssociacaoCartao.class.getName()).getResultList();
      }
	
}
