package com.cg.training.service;

import java.util.Date;
import java.util.List;

import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;

public interface AdminService {
	//public MemberInformation addMember(MemberInformation memInfo,int noOfMembers) throws AdminException;
	public MemberInformation addMember(MemberInformation memInfo) throws AdminException;
	public MemberInformation updateMember(MemberInformation memInfo) throws AdminException;
	//public int deleteMember(Integer memberId) throws AdminException;
	
	
	//Search Operations
	
		//by id
		public MemberInformation searchMemberById(Integer memberId) throws AdminException;
		
		//by firstName
		public List<MemberInformation> searchMemberByFirstName(String firstName) throws AdminException;
		
		//by lastName
		public List<MemberInformation> searchMemberByLastName(String lastName) throws AdminException;
		
		//by DOB
		public List<MemberInformation> searchMemberByDob(Date dob) throws AdminException;

}
