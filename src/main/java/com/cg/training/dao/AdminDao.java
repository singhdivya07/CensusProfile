package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;

public interface AdminDao {
	
	public void addMember(MemberInformation memberInformation) throws PersistenceException;
	public void updateMember(MemberInformation memberInformation) throws PersistenceException;
	public int deleteMember(Integer memberId) throws PersistenceException;
	public void searchMember(MemberInformation memberInformation) throws PersistenceException;

}
