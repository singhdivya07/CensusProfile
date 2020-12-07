package com.cg.training.dao;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;


public interface UserDao
{
	public void addMember(MemberInformation memberInformation) throws PersistenceException;
	public MemberInformation updateMember(MemberInformation memberInformation) throws PersistenceException;
	public MemberInformation getMemberById(Integer memberId) throws PersistenceException;

}
