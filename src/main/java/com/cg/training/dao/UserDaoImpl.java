package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;


public class UserDaoImpl implements UserDao{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app1");

	@Override
	public void addMember(MemberInformation memInfo) throws PersistenceException {
		
				
			EntityManager entityManager=emf.createEntityManager();
			try {			
				entityManager.getTransaction().begin();
				entityManager.persist(memInfo);
				entityManager.flush();
				entityManager.getTransaction().commit();			
			}catch(PersistenceException e) {
				entityManager.getTransaction().rollback();
				throw e;
			}catch(Exception e) {
				throw e;
			}finally {
				entityManager.close();
			}		
		
	}

	@Override
	public MemberInformation updateMember(MemberInformation memInfo) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MemberInformation updatedMember= 
					entityManager.merge(memInfo);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatedMember;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	@Override
	public MemberInformation getMemberById(Integer memId) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			MemberInformation product =
					entityManager.find(MemberInformation.class, memId);			
			return product;
		}catch(PersistenceException e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}



}
