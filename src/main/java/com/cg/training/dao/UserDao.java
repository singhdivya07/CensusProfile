package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.Entity.MemberInformation;

public interface UserDao {
	
	public void addMember(MemberInformation memInfo) throws PersistenceException;
	public MemberInformation updateMember(MemberInformation memInfo) throws PersistenceException;
	public MemberInformation getMemberById(Integer memId) throws PersistenceException;

}
