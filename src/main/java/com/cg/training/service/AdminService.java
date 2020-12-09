package com.cg.training.service;

import java.util.Date;

import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;

public interface AdminService {
	public void addMember(MemberInformation memInfo) throws AdminException;
	public MemberInformation updateMember(MemberInformation memInfo) throws AdminException;
	public int deleteMember(Integer memberId) throws AdminException;
	
	
	//Search Operations
	
		//by id
		public MemberInformation searchMemberById(Integer memberId) throws AdminException;
		
		//by firstName
		public MemberInformation searchMemberByFirstName(String firstName) throws AdminException;
		
		//by lastName
		public MemberInformation searchMemberByLastName(String lastName) throws AdminException;
		
		//by DOB
		public MemberInformation searchMemberByDob(Date dob) throws AdminException;

}
