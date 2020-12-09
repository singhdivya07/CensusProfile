package com.cg.training.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.MemberInformation;

public class AdminDaoImpl implements AdminDao{

	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("census-profile-app");
	
	public void addMember(MemberInformation memberInformation) throws PersistenceException 
	{
		
		EntityManager entityManager=emf.createEntityManager();
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

	//Update
	public MemberInformation updateMember(MemberInformation memberInformation) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
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

	public int deleteMember(Integer memberId) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
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
	
	//search operations
	//by id
	public MemberInformation searchMemberById(Integer memberId) throws PersistenceException 
	{

		EntityManager entityManager=emf.createEntityManager();
		try {
			MemberInformation memberInfo =
					entityManager.find(MemberInformation.class, memberId);			
			return memberInfo;
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	
	}
	
	//firstName

	public MemberInformation searchMemberByFirstName(String firstName) throws PersistenceException {
		
		MemberInformation memberInformation;
		EntityManager entityManager=emf.createEntityManager();
		try {
			
			 TypedQuery<MemberInformation> query = entityManager.createQuery(
				        "SELECT c FROM MemberInformation c WHERE c.firstName = :firstName", MemberInformation.class);
				    /**/
			  memberInformation=query.getSingleResult();
			  return memberInformation;
			
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	}
	
	//by lastName
	public MemberInformation searchMemberByLastName(String lastName) throws PersistenceException 
	{

		EntityManager entityManager=emf.createEntityManager();
		try {
			MemberInformation memberInfo =
					entityManager.find(MemberInformation.class, lastName);			
			return memberInfo;
		}catch(PersistenceException e) {
			e.printStackTrace();
			throw e;
		}finally {
			entityManager.close();
		}	
	}
	
	//by DOB
	public MemberInformation searchMemberByDob(Date dob) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
