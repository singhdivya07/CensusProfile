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
import com.cg.training.util.AdminUserInputForRegisterLogin;
import com.cg.training.util.AdminUserUtil;


public class ApplicationDemo {

	private static AdminUserInputForRegisterLogin adminUserDo= new AdminUserInputForRegisterLogin();
	private static AdminUserUtil adminUserUtil=new AdminUserUtil();
	private static ApplicationDao applicationDao=new ApplicationDaoImpl();
	private static MemberInformation memberInformation =new MemberInformation();
	private static MemberInformationDao memberInformationDao= new MemberInformationDaoImpl();

	private static Scanner sc = new Scanner(System.in);
	private static Logger logger=Logger.getLogger(ApplicationDemo.class);

	public static void main(String[] args) throws AdminException, UserException, MemberInformationException {
		System.out.println("Only family head can enter the data ");
		System.out.println("Enter 1. Admin 2. User ");
		int option = Integer.parseInt(sc.nextLine());
		if (option == 1 || option == 2) {

			User user = new User();
			Application application = new Application();
			user = adminUserDo.addUser(user); // user added
			System.out.println("1.user done");
			application.setUser(user); // set user by application but due to this data getting persisted twice
			System.out.println("1.user done");
			application = applicationDao.addApplication(application); // call addApplication to persist
																		// application

		
		while (true) {
			System.out.println("1. Add member 2. Search member by ID 3. Search member by first name 4. Search member by Last name 5. Update");
			int operation = sc.nextInt();
				try {
					
					switch (operation) {
					case 1:
						System.out.println(
								"How many family members do you want to add ? Note: You can not add more than 5 members ");
						int noOfMembers = sc.nextInt();
						System.out.println("outside while");
						// int flag = noOfMembers;
						while (noOfMembers >= 1 && noOfMembers <= 5) {
							System.out.println("1.inside while");
							memberInformation.setApplication(application);
							System.out.println("2.inside while");
							// memberInformation=adminUtil.addMember(memberInformation,noOfMembers);

							 adminUserUtil.addMember(memberInformation, option);

							System.out.println("3.inside while");
							// application.setMembers(memberInformation);
							System.out.println("4.inside while");
							noOfMembers--;
							System.out.println("5.end while");
						}
						break;

					case 2:
						System.out.println("enter id of member to search");
						Integer memberId = Integer.parseInt(sc.nextLine());
						System.out.println("Enter Member Id");
						memberInformation = adminUserUtil.searchMemberById(memberId, option);
						System.out.println(memberInformation);

						break;

					case 3:
						System.out.println("Enter Member first name");
						String firstName = sc.nextLine();
						List<MemberInformation> member = adminUserUtil.searchMemberByFirstName(firstName, option);
						System.out.println(member);

						break;

					case 4:
						System.out.println("Enter Member last name");
						String lastName = sc.nextLine();
						member = adminUserUtil.searchMemberByLastName(lastName, option);
						System.out.println(member);
						break;

					default:
						System.out.println("invalid choice");
						break;
					}
				}
				 catch (PersistenceException e) {
						logger.error(e.getMessage(),e);
					}

					System.out.println("Enter y to continue..");
					
					String ch = sc.nextLine();
					
					if (!ch.equalsIgnoreCase("y")) {
						break;
					}

				}
		}
		
			else
				System.out.println("Invalid Option");
		
		}
	}
