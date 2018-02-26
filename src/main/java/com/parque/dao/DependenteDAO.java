package com.parque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.parque.domain.Cliente;
import com.parque.domain.Conta;
import com.parque.domain.Dependente;

public class DependenteDAO {

	protected EntityManager entityManager;
	private static DependenteDAO instance;
	
	public static DependenteDAO getInstance(){
        if (instance == null){
                 instance = new DependenteDAO();
        }
        
        return instance;
	 }
	
	private DependenteDAO() {
		entityManager= getEntityManager();
	}
	
	
	private EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud");
       if (entityManager == null) {
                entityManager = factory.createEntityManager();
       }

       return entityManager;
	
	}
	
	
	 public void persist(Dependente dependente) {
         try 
         {
                  entityManager.getTransaction().begin();
                  entityManager.persist(dependente);
                  entityManager.getTransaction().commit();
                  
         } catch (Exception ex) {
                  ex.printStackTrace();
                  entityManager.getTransaction().rollback();
         }
	 }
	 
	 
	 public List<Dependente> getDependentesByIdCliente(Long id){
		  List <Dependente> list = null;
		  entityManager.getTransaction().begin();
		 	  
		  	Query query= entityManager.createQuery("SELECT d FROM Dependente d");
		  
		 
		  	list = query.getResultList();
		  		entityManager.getTransaction().commit();
		  	
		  
		  return list;
	  }
}
