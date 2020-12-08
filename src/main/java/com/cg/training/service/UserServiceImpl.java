package com.cg.training.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import com.cg.training.Entity.*;
import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.exception.UserException;

public class UserServiceImpl implements UserService{
	 private UserDao userDao = new UserDaoImpl();
	public void addMember(MemberInformation memInfo) throws UserException {
		try {
			//Name validation
			String firstName = memInfo.getFirstName();
			String lastName = memInfo.getLastName();
			 // Regex to check valid username. 
	        String regex = "^[A-Za-z]{2,30}[\\s'*-]*[A-Za-z]*$";
	        
	        Pattern p = Pattern.compile(regex); 
	        Matcher m = p.matcher(firstName);
	        Matcher m1 = p.matcher(lastName);
	   
	        
			if((m.matches())&&(m1.matches())) 
		    	{
				// Age validation
					if(memInfo.getAge()<125)
					 userDao.addMember(memInfo);
					else
					{
						throw new UserException("Age cannot be greater than 125 yrs");
					}
		    	}
			else
				throw new UserException("Invalid Name! Please Enter Valid Names");
			
		
			
			
			
		}catch(PersistenceException e) {
			e.getMessage();
		}
		
	}

	public MemberInformation updateMember(MemberInformation memInfo) throws UserException {
		try {			
			MemberInformation mem = 
					userDao.updateMember(memInfo);
			return mem;
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	public MemberInformation getMemberById(Integer memberId) throws UserException {
		try {			
			MemberInformation memberInfo = userDao.getMemberById(memberId);
			return memberInfo;
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}
 

}
