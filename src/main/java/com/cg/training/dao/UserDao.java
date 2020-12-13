package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.User;

public interface UserDao 
{
	public User addUser(User user) throws PersistenceException;
	public boolean loginUser(String userName,String password) throws PersistenceException;
}
