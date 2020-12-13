package com.cg.training.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import com.cg.training.dao.MemberInformationDao;
import com.cg.training.dao.MemberInformationDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.MemberInformationException;

public class MemberInformationServiceImpl implements MemberInformationService{
	 private MemberInformationDao memberInformationDao = new MemberInformationDaoImpl();
	 @Override
	public MemberInformation addMember(MemberInformation memInfo) throws MemberInformationException {
		try {
			//Name validation
			String firstName = memInfo.getFirstName();
			String lastName = memInfo.getLastName();
			 // Regex to check valid username. 
	        String regex = "^[A-Za-z]{2,30}[\\s'*-]*[A-Za-z]*$";
	        
	        Pattern p = Pattern.compile(regex); 
	        Matcher m = p.matcher(firstName);
	        Matcher m1 = p.matcher(lastName);
	   
	        
			if((m.matches())&&(m1.matches())) 
		    	{
				// Age validation
					if(memInfo.getAge()<125)
					 memberInformationDao.addMember(memInfo);
					else
					{
						throw new MemberInformationException("Age cannot be greater than 125 yrs");
					}
		    	}
			else
				throw new MemberInformationException("Invalid Name! Please Enter Valid Names");
			
		
			
			
			
		}catch(PersistenceException e) {
			e.getMessage();
		}
		return memInfo;
		
	}
	@Override
	public MemberInformation updateMember(MemberInformation memInformation) throws MemberInformationException {
		try {			
			MemberInformation memInfo = 
					memberInformationDao.updateMember(memInformation);
			return memInfo;
		}catch(PersistenceException e) {
			throw new MemberInformationException(e.getMessage(),e);
		}
	}
	
	@Override
	public int deleteMember(Integer memberId) throws MemberInformationException {
		try {
			memberInformationDao.deleteMember(memberId);
			return memberId;
		}catch(PersistenceException e) {
			throw e;
		}
	}
	
	//search operations
	
			//by id
			public MemberInformation searchMemberById(Integer memberId) throws MemberInformationException {
				try {			
					MemberInformation memberInfo = memberInformationDao.searchMemberById(memberId);
					return memberInfo;
				}catch(PersistenceException e) {
					throw e;
				}
			}
			
			
			//by firstName
			public List< MemberInformation> searchMemberByFirstName(String firstName) throws MemberInformationException {
				try {			
					List<MemberInformation> list = memberInformationDao.searchMemberByFirstName(firstName);
					return list;
				}catch(PersistenceException e) {
					throw e;
				}
			}
			
			//by lastName

			public List<MemberInformation> searchMemberByLastName(String lastName) throws MemberInformationException {
				try {	
					List<MemberInformation> list = memberInformationDao.searchMemberByFirstName(lastName);
					return list;
				}catch(PersistenceException e) {
					throw e;
				}
			}
			
			
			public List<MemberInformation> searchMemberByDob(Date dob) throws MemberInformationException {
				// TODO Auto-generated method stub
				return null;
			}
 

}
