package com.cg.training.service;



import com.cg.training.entity.Application;
import com.cg.training.exception.ApplicationException;

public interface ApplicationService 
{
	public Application addApplication(Application application) throws ApplicationException;

}
