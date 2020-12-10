package com.cg.training.pl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.cg.training.dao.ApplicationDao;
import com.cg.training.dao.ApplicationDaoImpl;
import com.cg.training.dao.MemberInformationDao;
import com.cg.training.dao.MemberInformationDaoImpl;
import com.cg.training.entity.Application;
import com.cg.training.entity.MemberInformation;
import com.cg.training.entity.User;
import com.cg.training.exception.AdminException;
import com.cg.training.exception.MemberInformationException;
import com.cg.training.exception.UserException;
import com.cg.training.util.AdminInputForRegisterLogin;
import com.cg.training.util.AdminUtil;
import com.cg.training.util.UserInputForRegisterAndLogin;
import com.cg.training.util.UserUtil;

public class ApplicationDemo {

	private static AdminInputForRegisterLogin adminDo= new AdminInputForRegisterLogin();
	private static UserInputForRegisterAndLogin userDo=new UserInputForRegisterAndLogin();
	private static AdminUtil adminUtil=new AdminUtil();
	private static UserUtil userUtil=new UserUtil();

	private static ApplicationDao applicationDao=new ApplicationDaoImpl();
	private static MemberInformation memberInformation =new MemberInformation();
	private static MemberInformationDao memberInformationDao= new MemberInformationDaoImpl();

	private static Scanner sc = new Scanner(System.in);
	private static Logger logger=Logger.getLogger(ApplicationDemo.class);

	public static void main(String[] args) throws AdminException, UserException, MemberInformationException {
		while(true)
		{
			System.out.println("Only family head can enter the data ");
			System.out.println("Enter 1. Admin 2. User ");
			int option= Integer.parseInt(sc.nextLine());
			try {
				switch(option) 
				{
				case 1:							//login or register for admin
					User user =new User();
					int flag=0;
					Application application=new Application();


					user=adminDo.addUser(user);		//user added
					System.out.println("1.user done");
					application.setUser(user);		//set user by application but due to this data getting persisted twice
					System.out.println("1.user done");
					application=applicationDao.addApplication(application); //call addApplication to persist application

					System.out.println("1. Add member 2. Search member by ID 2. Search member by first name 2. Search member by Last name 3. Update");
					int operation =sc.nextInt();
					switch (operation)
					{
					case 1:
						System.out.println("How many family members do you want to add ? Note: You can not add more than 5 members ");
						int noOfMembers=sc.nextInt();
						System.out.println("outside while");
						while(flag<noOfMembers)
						{
							System.out.println("1.inside while");
							memberInformation.setApplication(application);
							System.out.println("2.inside while");
							//memberInformation=adminUtil.addMember(memberInformation,noOfMembers);
							memberInformation=adminUtil.addMember(memberInformation);
							System.out.println("3.inside while");
							//application.setMembers(memberInformation);
							System.out.println("4.inside while");
							flag++;
							System.out.println("5.end while");
						}
						break;

					case 2: 
						System.out.println("enter id of member to serach");
						Integer memberId=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Member Id");
						memberInformation=adminUtil.searchMemberById(memberId);
						System.out.println(memberInformation);

						break;

					case 3: 
						System.out.println("Enter Member first name");
						String firstName = sc.nextLine();
						List<MemberInformation>member = adminUtil.searchMemberByFirstName(firstName);
						System.out.println(member);

						break;

					case 4:
						System.out.println("Enter Member last name");
						String lastName = sc.nextLine();
						member = adminUtil.searchMemberByLastName(lastName);
						System.out.println(member);
						break;	

					default:
						System.out.println("invalid choice");

					}
					break;

				case 2: 						//login or register for admin
					user =new User();
					flag=0;
					application=new Application();

					user=userDo.addUser(user);		//user added
					application.setUser(user);		//set user by application
					application=applicationDao.addApplication(application); //call addApplication to persist application
					System.out.println("1. Add member 2. Search member by ID 2. Search member by first name 2. Search member by Last name 3. Update");
					operation =sc.nextInt();
					switch (operation)
					{
					case 1:
						System.out.println("How many family members do you want to add ? Note: You can not add more than 5 members ");
						int noOfMembers=sc.nextInt();
						System.out.println("outside while");
						while(flag<noOfMembers)
						{
							System.out.println("1.inside while");
							memberInformation.setApplication(application);
							System.out.println("2.inside while");
							//memberInformation=adminUtil.addMember(memberInformation,noOfMembers);
							memberInformation=userUtil.addMember(memberInformation);
							System.out.println("3.inside while");
							//application.setMembers(memberInformation);
							System.out.println("4.inside while");
							flag++;
							System.out.println("5.end while");
						}
						break;

					case 2: 
						System.out.println("enter id of member to serach");
						Integer memberId=Integer.parseInt(sc.nextLine());
						System.out.println("Enter Member Id");
						memberInformation=userUtil.searchMemberById(memberId);
						System.out.println(memberInformation);

						break;

					case 3: 
						System.out.println("Enter Member first name");
						String firstName = sc.nextLine();
						List<MemberInformation>member = userUtil.searchMemberByFirstName(firstName);
						System.out.println(member);

						break;

					case 4:
						System.out.println("Enter Member last name");
						String lastName = sc.nextLine();
						member = userUtil.searchMemberByLastName(lastName);
						System.out.println(member);
						break;	

					default:
						System.out.println("invalid choice");
						break;
					}			


				default:System.out.println("Invalid option");
				break;				

				}
			}catch(PersistenceException e)
			{
				e.printStackTrace();
			}

			System.out.println("Enter y to continue..");
			String ch=sc.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}


		}

	}

}