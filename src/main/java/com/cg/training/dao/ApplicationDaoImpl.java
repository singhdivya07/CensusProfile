package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.Application;

public class ApplicationDaoImpl implements ApplicationDao 
{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app");

	@Override
	public Application addApplication(Application application) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {	
			
			entityManager.getTransaction().begin();
			entityManager.persist(application);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}
		return application;		
	}

}
