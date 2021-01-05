package com.cg.census.service;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.training.dao.MemberInformationDaoImpl;
import com.cg.training.entity.MemberInformation;

import com.cg.training.exception.AdminException;

import com.cg.training.exception.MemberInformationException;
import com.cg.training.service.MemberInformationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

	@InjectMocks
	private MemberInformationServiceImpl memberServiceImpl; 

	@Mock	
	MemberInformationDaoImpl memberInformationDaoImpl ;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	//Test to Check Valid First Name
	@Test
	void testAddMemberValidateFirstName() throws MemberInformationException {

		try {

		MemberInformation memberInfo = new MemberInformation();

		memberInfo.setFirstName("Rucha-");
		memberInfo.setLastName("Sheth");	
		memberInfo.setAge(22);

		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

	
	}

	//Test to Check Valid Last Name
	@Test
	void testAddMemberValidateLastName() throws MemberInformationException   {

		try {

			MemberInformation memberInfo = new MemberInformation();

		memberInfo.setFirstName("Rucha");
		memberInfo.setLastName("Sheth*");	
		memberInfo.setAge(22);

		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

		
	}

	//Test to check Invalid FirstName
	@Test
	void testAddMemberInvalidName() throws MemberInformationException  {

		try
		{

		MemberInformation memberInfo = new MemberInformation();

		memberInfo.setFirstName("Rucha123");
		memberInfo.setLastName("Sheth");	
		memberInfo.setAge(22);

		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

		
	}

	//Test to check Invalid LastName
	@Test
	void testAddMemberInvalidLastName() throws MemberInformationException  {

		try {

		MemberInformation memberInfo = new MemberInformation();

		memberInfo.setFirstName("Rucha");
		memberInfo.setLastName("Sheth@");	
		memberInfo.setAge(22);
		
		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

		
	}


	//Test to check Valid Age
	@Test
	void testAddMemberValidateAge() throws MemberInformationException  {

		try {

		MemberInformation memberInfo = new MemberInformation();
		memberInfo.setFirstName("Rucha");
		memberInfo.setLastName("Sheth");	
		memberInfo.setAge(24);

		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

		
	}	

	//Test to check Invalid Age
	@Test
	void testAddMemberInvalidAge() throws MemberInformationException {

		try {

		MemberInformation memberInfo = new MemberInformation();
		memberInfo.setFirstName("Rucha");
		memberInfo.setLastName("Sheth");	
		memberInfo.setAge(126);

		memberServiceImpl.addMember(memberInfo);

		verify(memberInformationDaoImpl,times(1)).addMember(memberInfo);	

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

		
	}			


	//Test to get existing id 
	@Test
	public void testGetMemberByIdExistingId() throws MemberInformationException {

		try {

		MemberInformation memberInfo = new MemberInformation();
		memberInfo.setMemberId(2);
		if(memberServiceImpl!=null)
			memberServiceImpl.searchMemberById(2);
		verify(memberInformationDaoImpl,times(1)).searchMemberById(2);       

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

	}

	//Test to get Not existing id 
	@Test
	public void testGetMemberByIdNotExisingId() throws MemberInformationException{

		
		try {

		MemberInformation memberInfo = new MemberInformation();
		memberInfo.setMemberId(2);
		if(memberServiceImpl!=null)
			memberServiceImpl.searchMemberById(3);
		verify(memberInformationDaoImpl,times(1)).searchMemberById(2);       

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

	}
	
	
	//Test to update Existing id
	@Test
	public void testUpdateByIdExistingId() throws MemberInformationException {

		try {


		MemberInformation memberInfo = new MemberInformation();
		memberInfo.setMemberId(2);
		memberInfo= memberServiceImpl.searchMemberById(2);
		if(memberServiceImpl!=null)
			memberServiceImpl.updateMember(memberInfo);
		verify(memberInformationDaoImpl,times(1)).updateMember(memberInfo);

		}
		catch(Exception e)
		{
			throw new MemberInformationException("");
		}

	}
	
//	//Test to update Not Existing id
//		@Test
//		public void testUpdateByIdNotExistingId() throws UserException {
//
//			MemberInformation memberInfo = new MemberInformation();
//			memberInfo.setMemberId(22);
//			memberInfo= userServiceImpl.getMemberById(5);
//			if(userServiceImpl!=null)
//				userServiceImpl.updateMember(memberInfo);
//			verify(userDaoImpl,times(1)).updateMember(memberInfo);
//		}
	
	
}
