package com.cg.training.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.training.entity.MemberInformation;

public interface MemberInformationDao {
	
	public MemberInformation addMember(MemberInformation memberInformation) throws PersistenceException;
	public MemberInformation updateMember(MemberInformation memberInformation) throws PersistenceException;
	public int deleteMember(Integer memberId) throws PersistenceException;
	
	//Search Operations
	
		//by id
		public MemberInformation searchMemberById(Integer memberId) throws PersistenceException;
		
		//by firstName
		public List<MemberInformation> searchMemberByFirstName(String firstName) throws PersistenceException;
		
		//by lastName
		public List<MemberInformation> searchMemberByLastName(String lastName) throws PersistenceException;
		
		//by DOB
		public List<MemberInformation> searchMemberByDob(Date dob) throws PersistenceException;

}
