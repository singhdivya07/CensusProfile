package com.cg.training.dao;

import java.util.Date;

import javax.persistence.PersistenceException;

import com.cg.training.Entity.MemberInformation;
import com.cg.training.exception.AdminException;

public interface AdminDao {
	
	public void addMember(MemberInformation  memInfo) throws PersistenceException;
	public void updateMember(MemberInformation memInfo) throws PersistenceException;
	public int deleteMember(Integer memberId) throws PersistenceException;
	
	//Search Operations
	
	//by id
	public MemberInformation searchMemberById(Integer memberId) throws PersistenceException;
	
	//by firstName
	public MemberInformation searchMemberByFirstName(String firstName) throws PersistenceException;
	
	//by lastName
	public MemberInformation searchMemberByLastName(String lastName) throws PersistenceException;
	
	//by DOB
	public MemberInformation searchMemberByDob(Date dob) throws PersistenceException;
}
