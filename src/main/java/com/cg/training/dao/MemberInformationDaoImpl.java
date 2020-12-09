package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;



public class MemberInformationDaoImpl implements MemberInformationDao{

	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app");

	public void addMember(MemberInformation memInfo) throws PersistenceException 
	{

		
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(memInfo);
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
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	public MemberInformation getMemberById(Integer memId) throws PersistenceException 
	{
		EntityManager entityManager=emf.createEntityManager();
		try {
			MemberInformation memberInfo =
					entityManager.find(MemberInformation.class, memId);			
			return memberInfo;
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	}

	}

	
	

	
//	
	
	
	
	
	
