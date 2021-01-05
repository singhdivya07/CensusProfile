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

import com.cg.training.dao.AdminDaoImpl;
import com.cg.training.entity.MemberInformation;
import com.cg.training.exception.AdminException;
import com.cg.training.service.AdminServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class AdminServiceTest {

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Mock
	private AdminDaoImpl adminDaoImpl;
		
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	//Test to Check Valid First Name
		@Test
		void testAddMemberValidateFirstName() throws AdminException {

			try
			{

			MemberInformation memberInfo = new MemberInformation();

			memberInfo.setFirstName("Rucha");
			memberInfo.setLastName("Sheth");	
			memberInfo.setAge(22);

			adminServiceImpl.addMember(memberInfo);

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			}
			catch(Exception e)
			{
				throw new AdminException("");
			}

		
		}

		//Test to Check Valid Last Name
		@Test
		void testAddMemberValidateLastName() throws AdminException {
				MemberInformation memberInfo = new MemberInformation();

try {

			memberInfo.setFirstName("Rucha");
			memberInfo.setLastName("Sheth*");	
			memberInfo.setAge(22);

			adminServiceImpl.addMember(memberInfo);


			verify(adminDaoImpl,times(1)).addMember(memberInfo);
		}
		catch(Exception e)
		{
			throw new AdminException("");
		}

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			
		}

		//Test to check Invalid FirstName
		@Test
		void testAddMemberInvalidName() throws AdminException {

			try {

			MemberInformation memberInfo = new MemberInformation();

			memberInfo.setFirstName("Rucha123");
			memberInfo.setLastName("Sheth");	
			memberInfo.setAge(22);

			adminServiceImpl.addMember(memberInfo);

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			}
			catch(Exception e)
			{
				throw new AdminException("");
			}

			
		}

		//Test to check Invalid LastName
		@Test
		void testAddMemberInvalidLastName() throws AdminException {

			try
			{

			MemberInformation memberInfo = new MemberInformation();

			memberInfo.setFirstName("Rucha");
			memberInfo.setLastName("Sheth@");	
			memberInfo.setAge(22);
			
			adminServiceImpl.addMember(memberInfo);

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			}
			catch(Exception e)
			{
				throw new AdminException("");
			}

			
		}


		//Test to check Valid Age
		@Test
		void testAddMemberValidateAge() throws AdminException {

			try {

			MemberInformation memberInfo = new MemberInformation();
			memberInfo.setFirstName("Rucha");
			memberInfo.setLastName("Sheth");	
			memberInfo.setAge(24);

			adminServiceImpl.addMember(memberInfo);

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			}
			catch(Exception e)
			{
				throw new AdminException("");
			}

			
		}	

		//Test to check Invalid Age
		@Test
		void testAddMemberInvalidAge() throws AdminException {

			try {

			MemberInformation memberInfo = new MemberInformation();
			memberInfo.setFirstName("Rucha");
			memberInfo.setLastName("Sheth");	
			memberInfo.setAge(126);

			adminServiceImpl.addMember(memberInfo);

			verify(adminDaoImpl,times(1)).addMember(memberInfo);	

			}
			catch(Exception e)
			{
				throw new AdminException("");
			}

		}	
		
		
		
		
		@Test
		void testSearchById() {
			//MemberInformation memberInfo = new MemberInformation();
			
		}

}
