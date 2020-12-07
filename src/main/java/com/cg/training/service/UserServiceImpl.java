package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.UserException;

public class UserServiceImpl implements UserService
{
 private UserDao userDao = new UserDaoImpl();

public void addMember(MemberInformation memberInformation) throws UserException {
	try {
		//validate member
		userDao.addMember(memberInformation);		
	}catch(PersistenceException e) {
		throw new UserException(e.getMessage(),e);
	}
	
}

public MemberInformation updateMember(MemberInformation memberInformation) throws UserException {
	try {			
		MemberInformation updatedMember = 
				userDao.updateMember(memberInformation);
		return updatedMember;
	}catch(PersistenceException e) {
		throw new UserException(e.getMessage(),e);
	}
}

public MemberInformation getMemberById(Integer memberId) throws UserException {
	try {			
		MemberInformation memberInformation = userDao.getMemberById(memberId);
		return memberInformation;
	}catch(PersistenceException e) {
		throw new UserException(e.getMessage(),e);
	}
}
	

}
