package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.Application;


public interface ApplicationDao 
{
	public Application addApplication(Application application) throws PersistenceException;
	

}
