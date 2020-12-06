package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;

public interface AdminDao {
	
	public void addMember(MemberInformation memInfo) throws PersistenceException;
	public void updateMember(MemberInformation memInfo) throws PersistenceException;
	public void deleteMember(MemberInformation memInfo) throws PersistenceException;
	public void searchMember(MemberInformation memInfo) throws PersistenceException;

}
