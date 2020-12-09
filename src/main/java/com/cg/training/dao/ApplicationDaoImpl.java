package com.cg.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.training.entity.Application;

import com.cg.training.entity.User;

public class ApplicationDaoImpl implements ApplicationDao 
{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app");
	@Override
	public void addApplication(Application application) throws PersistenceException {
		
//		User user=new User();
//		UserDao userDao=new UserDaoImpl();
//		MemberInformationDao memberInformationDao=new MemberInformationDaoImpl();
//		MemberInformation memberInformation=new MemberInformation();
		
		//userDao.addUser(user);
		//memberInformationDao.addMember(memberInformation);
		
		
		
		EntityManager entityManager=emf.createEntityManager();
		try {	
			
			
			//application.setMembers(memberInformation);
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
	
		
	}

}
