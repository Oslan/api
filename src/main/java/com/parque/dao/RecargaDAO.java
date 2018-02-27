package com.parque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.parque.domain.Cliente;
import com.parque.domain.Recarga;


public class RecargaDAO {

	protected EntityManager entityManager;
	
	 private static RecargaDAO instance;
	 
	 public static RecargaDAO getInstance(){
        if (instance == null){
                 instance = new RecargaDAO();
        }
        
        return instance;
	 }
	 
	 private RecargaDAO() {
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
	
	 public void persist(Recarga recarga) {
         try 
         {
                  entityManager.getTransaction().begin();
                  entityManager.persist(recarga);
                  entityManager.getTransaction().commit();
                  
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
	 }
	 
	 public Recarga getById(final Long id) {
         return entityManager.find(Recarga.class, id);
	 }
	 
	  @SuppressWarnings("unchecked")
      public List<Recarga> findAll() {
                return entityManager.createQuery("FROM " + Recarga.class.getName()).getResultList();
      }
	  
}
