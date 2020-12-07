package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;


public class AdminDaoImpl implements AdminDao
{
	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("census-profile-app");
	
	public void addMember(MemberInformation memberInformation) throws PersistenceException 
	{

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(memberInformation);
			entityManager.flush();
			entityManager.getTransaction().commit();
	
		}catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
		}
		
	}

	public void updateMember(MemberInformation memberInformation) throws PersistenceException 
	{
		// TODO Auto-generated method stub
		
	}

	public int deleteMember(MemberInformation memberId) throws PersistenceException 
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MemberInformation memberInformation= 
					entityManager.find(MemberInformation.class, memberId);
			entityManager.remove(memberInformation);
//			entityManager.flush();
			entityManager.getTransaction().commit();	
			return memberInformation.getMemberId();
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}finally {
			entityManager.close();
		}	
		
	}

	public void searchMember(MemberInformation memberInformation) throws PersistenceException 
	{
		// TODO Auto-generated method stub
		
	}

	

}
