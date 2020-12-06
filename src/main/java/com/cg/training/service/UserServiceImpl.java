package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.UserException;

public class UserServiceImpl implements UserService{
 private UserDao userDao = new UserDaoImpl();
	@Override
	public void addMember(MemberInformation memInfo) throws UserException {
		try {
			//validate member
			userDao.addMember(memInfo);;			
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}

	@Override
	public MemberInformation updateMember(MemberInformation memInfo) throws UserException {
		try {			
			MemberInformation mem = 
					userDao.updateMember(memInfo);
					
			return mem;
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public MemberInformation getMemberById(Integer memberId) throws UserException {
		try {			
			MemberInformation mem = userDao.getMemberById(memberId);
			return mem;
		}catch(PersistenceException e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}

}
