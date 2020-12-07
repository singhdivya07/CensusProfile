package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;


public class UserDaoImpl implements UserDao
{
	private EntityManagerFactory entityManagerFactory= 
			Persistence.createEntityManagerFactory("census-profile-app1");

	public void addMember(MemberInformation memberInformation) throws PersistenceException {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(memberInformation);
			entityManager.flush();
			entityManager.getTransaction().commit();			
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}		
	
		
	}

	public MemberInformation updateMember(MemberInformation memberInformation) throws PersistenceException
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MemberInformation updatedMember= 
					entityManager.merge(memberInformation);			
			entityManager.flush();
			entityManager.getTransaction().commit();	
			return updatedMember;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
		
	}

	public MemberInformation getMemberById(Integer memberId) throws PersistenceException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			MemberInformation memberInformation =
					entityManager.find(MemberInformation.class, memberId);			
			return memberInformation;
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	}

}
