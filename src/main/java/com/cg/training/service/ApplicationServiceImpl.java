package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.dao.ApplicationDao;
import com.cg.training.dao.ApplicationDaoImpl;
import com.cg.training.entity.Application;
import com.cg.training.exception.ApplicationException;


public class ApplicationServiceImpl implements ApplicationService
{
	ApplicationDao applicationDao=new ApplicationDaoImpl();

	@Override
	public Application addApplication(Application application) throws ApplicationException {
		try 
		{
			applicationDao.addApplication(application);
			
		} catch(PersistenceException e) {
			throw new ApplicationException(e.getMessage(),e);
		}
		return application;	}

}
