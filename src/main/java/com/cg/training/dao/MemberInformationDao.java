package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;

public interface MemberInformationDao {
	
	public void addMember(MemberInformation memberInformation) throws PersistenceException;
	public MemberInformation updateMember(MemberInformation memberInformation) throws PersistenceException;
	public MemberInformation getMemberById(Integer memId) throws PersistenceException;

}
