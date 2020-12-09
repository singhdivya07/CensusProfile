package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.entity.User;
import com.cg.training.exception.UserException;

public class UserServiceImpl implements UserService
{
	UserDao userDao=new UserDaoImpl();

	@Override
	public void addUser(User user) throws UserException {
		try 
		{
			userDao.addUser(user);
			
		} catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
		


}
}