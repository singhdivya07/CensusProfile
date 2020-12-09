package com.cg.training.service;



import com.cg.training.entity.User;
import com.cg.training.exception.UserException;

public interface UserService 
{
	public void addUser(User user) throws UserException;
	

}
