package com.cg.training.service;

import javax.persistence.PersistenceException;

import com.cg.training.dao.AdminDao;
import com.cg.training.dao.AdminDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;

public class AdminServiceImpl implements AdminService{
	
	private AdminDao adminDao=new AdminDaoImpl();
	
	public void addMember(MemberInformation memberInformation) throws AdminException {
		try {
			adminDao.addMember(memberInformation);
		}catch(PersistenceException e) {
			throw e;
		}
		
	}

	public void updateMember(MemberInformation memberInformation) throws AdminException {
		// TODO Auto-generated method stub
		
	}

	public int deleteMember(Integer memberId) throws AdminException {
		try 
		{
			adminDao.deleteMember(memberId);
			return memberId;
		}catch(PersistenceException e) 
		{
			throw e;
		}
	}

	public void searchMember(MemberInformation memberInformation) throws AdminException {
		// TODO Auto-generated method stub
		
	}

	
}
