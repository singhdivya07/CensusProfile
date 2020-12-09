package com.cg.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.training.entity.User;

public class UserDaoImpl implements UserDao
{
	private EntityManagerFactory emf= 
			Persistence.createEntityManagerFactory("census-profile-app");

	@Override
	public User addUser(User user) throws PersistenceException 
	{
		EntityManager entityManager=emf.createEntityManager();
		
//		User user=new User(userName,password);
		String userName=user.getUserName();
		String password=user.getPassword();
		try {
			TypedQuery<User> query = entityManager.createQuery(
					"SELECT c FROM User c WHERE c.userName = :userName", User.class);
			/**/
			query.setParameter("userName", userName);
			List<User> list=query.getResultList();
			System.out.println(list);
			if(list.isEmpty())
			{
				User user1=new User(userName,password);
				entityManager.getTransaction().begin();
				entityManager.persist(user1);
				entityManager.flush();
				System.out.println("user added ");
				entityManager.getTransaction().commit();
				return user1;
			}
			else {
				System.out.println("user already exists");
				loginUser(userName, password);
				if(loginUser(userName, password))
				{
					User userFetched=entityManager.find(User.class, user.getUserId());
					return userFetched;
				}
//				throw new PersistenceException("user already exists");
			}
			
		}catch(PersistenceException e) 
		{
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}finally 
		{
			entityManager.close();
		}
		return user;		
	
//		
//		try {			
//			entityManager.getTransaction().begin();
//			entityManager.persist(user);
//			entityManager.flush();
//			entityManager.getTransaction().commit();			
//		}catch(PersistenceException e) {
//			entityManager.getTransaction().rollback();
//			e.printStackTrace();
//			throw e;
//		}finally {
//			entityManager.close();
//		}		
//	
		
	}

	@Override
	public boolean loginUser(String userName,String password) throws PersistenceException 
	{
		
		
		EntityManager entityManager=emf.createEntityManager();
		
		
		 try{
			 entityManager.getTransaction().begin();
			 
			 
			 TypedQuery<User> query = entityManager.createQuery(
						"SELECT c FROM User c WHERE c.userName = ?3 AND c.password= ?2", User.class);
				/**/
				query.setParameter(3,userName);
				query.setParameter(2,password);
				//List<User> list=query.getResultList();
//	        Query query = em.createQuery("SELECT c FROM Clients c WHERE c.clientID = ?1 AND c.password = ?2");
//	        query.setParameter(1, CID).setParameter(2, password); 
	        try
	        { 
	        	User c = (User) query.getSingleResult();
	        	System.out.println("user login successfully");
	        	return true;
	        }catch(PersistenceException e)
	        {
	            return false;
	        }
	        }
	        finally{
	        entityManager.close();
	        }
		
		
		
		
	}

}
