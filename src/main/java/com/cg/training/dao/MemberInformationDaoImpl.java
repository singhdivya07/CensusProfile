package com.cg.training.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.MemberInformation;



public class MemberInformationDaoImpl implements MemberInformationDao{

	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app");

	public MemberInformation addMember(MemberInformation memberInformation) throws PersistenceException 
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
		return memberInformation;

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
	
	//delete
	public int deleteMember(Integer memberId) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MemberInformation memberInformation= 
					entityManager.find(MemberInformation.class, memberId);
			entityManager.remove(memberInformation);
			entityManager.flush();
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

		public List<MemberInformation> searchMemberByFirstName(String firstName) throws PersistenceException {


			EntityManager entityManager=emf.createEntityManager();
			try {

				TypedQuery<MemberInformation> query = entityManager.createQuery(
						"SELECT c FROM MemberInformation c WHERE c.firstName = :firstName", MemberInformation.class);
				/**/
				query.setParameter("firstName", firstName);
				List<MemberInformation> list=query.getResultList();
				return list;

			}catch(PersistenceException e) {
				e.printStackTrace();
				throw e;
			}finally {
				entityManager.close();
			}	
		}

		//by lastName
		public List<MemberInformation> searchMemberByLastName(String lastName) throws PersistenceException 
		{

			EntityManager entityManager=emf.createEntityManager();
			try {

				TypedQuery<MemberInformation> query = entityManager.createQuery(
						"SELECT c FROM MemberInformation c WHERE c.lastName = :lastName", MemberInformation.class);
				/**/
				query.setParameter("lastName", lastName);
				List<MemberInformation> list=query.getResultList();
				return list;

			}catch(PersistenceException e) {
				e.printStackTrace();
				throw e;
			}finally {
				entityManager.close();
			}	
		}

		//by DOB
		public List<MemberInformation> searchMemberByDob(Date dob) throws PersistenceException {
			// TODO Auto-generated method stub
			return null;
		}

		
	}





	//	





