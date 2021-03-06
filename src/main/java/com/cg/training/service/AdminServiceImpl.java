package com.cg.training.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.PersistenceException;

import com.cg.training.dao.AdminDao;
import com.cg.training.dao.AdminDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;



public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao=new AdminDaoImpl();
	@Override
	//public MemberInformation addMember(MemberInformation memInfo,int noOfMembers) throws AdminException
	public MemberInformation addMember(MemberInformation memInfo) throws AdminException
	{
		try {
					
					String firstName = memInfo.getFirstName();
					String lastName = memInfo.getLastName();
					 // Regex to check valid AdminName.
					
			        String regex = "^[A-Za-z]{2,30}[\\s'*-]*[A-Za-z]*$";
			        
			        // Compile the ReGex 
			        Pattern p = Pattern.compile(regex); 
			        Matcher m = p.matcher(firstName);
			        Matcher m1 = p.matcher(lastName);
			         
					if((m.matches())&&(m1.matches())) 
				    	{
						//Age validation
							if(memInfo.getAge()<125)
								//adminDao.addMember(memInfo,noOfMembers);
								adminDao.addMember(memInfo);
							else
							{
								throw new AdminException("Age cannot be greater than 125 yrs");
							}
				    	}
					else
						throw new AdminException("Invalid Name! Please Enter Valid Names");			
					
				}catch(PersistenceException e) {
					throw e;
				}
		return memInfo;	
		
		
	}

	@Override
	public MemberInformation updateMember(MemberInformation memberInformation) throws AdminException {
		try {			
			MemberInformation memInfo =  adminDao.updateMember(memberInformation);
			return memInfo;
		}catch(PersistenceException e) {
			throw new AdminException(e.getMessage(),e);
		}
	}
//	@Override
//	public int deleteMember(Integer memberId) throws AdminException {
//		try {
//			adminDao.deleteMember(memberId);
//			return memberId;
//		}catch(PersistenceException e) {
//			throw e;
//		}
//	}

	//search operations
	
		//by id
		public MemberInformation searchMemberById(Integer memberId) throws AdminException {
			try {			
				MemberInformation memberInfo = adminDao.searchMemberById(memberId);
				return memberInfo;
			}catch(PersistenceException e) {
				throw e;
			}
		}
		
		
		//by firstName
		public List< MemberInformation> searchMemberByFirstName(String firstName) throws AdminException {
			try {			
				List<MemberInformation> list = adminDao.searchMemberByFirstName(firstName);
				return list;
			}catch(PersistenceException e) {
				throw e;
			}
		}
		
		//by lastName

		public List<MemberInformation> searchMemberByLastName(String lastName) throws AdminException {
			try {	
				List<MemberInformation> list = adminDao.searchMemberByFirstName(lastName);
				return list;
			}catch(PersistenceException e) {
				throw e;
			}
		}
		
		
		public List<MemberInformation> searchMemberByDob(Date dob) throws AdminException {
			// TODO Auto-generated method stub
			return null;
		}
}
