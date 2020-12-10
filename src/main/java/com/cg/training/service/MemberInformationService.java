package com.cg.training.service;


import java.util.Date;
import java.util.List;

import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.MemberInformationException;



public interface MemberInformationService {
	public MemberInformation addMember(MemberInformation memInfo) throws MemberInformationException;
	public MemberInformation updateMember(MemberInformation memInfo) throws MemberInformationException;
	public int deleteMember(Integer memberId) throws MemberInformationException;
	//Search Operations
	
			//by id
			public MemberInformation searchMemberById(Integer memberId) throws MemberInformationException;
			
			//by firstName
			public List<MemberInformation> searchMemberByFirstName(String firstName) throws MemberInformationException;
			
			//by lastName
			public List<MemberInformation> searchMemberByLastName(String lastName) throws MemberInformationException;
			
			//by DOB
			public List<MemberInformation> searchMemberByDob(Date dob) throws MemberInformationException;

}
