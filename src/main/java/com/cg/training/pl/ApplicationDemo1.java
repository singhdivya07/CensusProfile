package com.cg.training.pl;

import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.entity.*;
import com.cg.training.exception.AdminException;
import com.cg.training.exception.UserException;
import com.cg.training.service.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

import static com.cg.training.entity.MemberInformationBuilder.anmemberInformationBuilder;

public class ApplicationDemo1 {
	private static Scanner sc = new Scanner(System.in);
	private static MemberInformationService memberInformationService = new MemberInformationServiceImpl();
	private static AdminService service = new AdminServiceImpl();
	private static Logger plLogger=Logger.getLogger(ApplicationDemo1.class);
	
	public static void main(String[] args) throws AdminException, UserException {
		while (true) {
			System.out.println("Select: 1.Admin  2.User 3.Login");
			Integer option1 = Integer.parseInt(sc.nextLine());
			if (option1 == 1) {
				System.out.println("Enter Username");
				String username=sc.nextLine();
				System.out.println("Enter Password");
				String password=sc.nextLine();
				
				if((username.equals("Admin"))&&(password.equals("Admin123")))
				{
				System.out.println(
						"Enter 1. Add member 2. Delete member 3. search by id 4.search by first name 5. search by last name 6.Update member by id ");
				Integer option = Integer.parseInt(sc.nextLine());
				try {
					switch (option) {
					case 1:
						MemberInformation memberInformation = new MemberInformation();
						addMember(memberInformation, option1);
						//System.out.println("new member Added");
						plLogger.info("1 member Added ");
						break;
					case 2:
						System.out.println("Enter member id: ");
						Integer memberId = Integer.parseInt(sc.nextLine());
						int id = deleteMember(memberId);
						plLogger.info("Product: " + id + " deleted");
						break;
					case 3:
						System.out.println("Enter Member Id");
						memberId = Integer.parseInt(sc.nextLine());
						memberInformation = searchMemberById(memberId);
						System.out.println(memberInformation);
						plLogger.info("member found");
						break;

					case 4:
						System.out.println("Enter Member first name");
						String firstName = sc.nextLine();
						memberInformation = searchMemberByFirstName(firstName);
						System.out.println(memberInformation);
						plLogger.info("member found"+memberInformation);
						break;

					case 5:
						System.out.println("Enter Member last name");
						String lastName = sc.nextLine();
						memberInformation = searchMemberByLastName(lastName);
						System.out.println(memberInformation);
						plLogger.info("member found"+memberInformation);
						break;
					case 6:
						System.out.println("Enter product id to be updated: ");
						memberId = Integer.parseInt(sc.nextLine());
						memberInformation = getMemberById(memberId);
						MemberInformation updatedMember = updateMember(memberInformation);
						//System.out.println(updatedMember);
						plLogger.info("member found"+updatedMember);
						break;

					default:
						System.out.println("Invalid option");
						break;

					}

				} catch (PersistenceException e) {
					e.printStackTrace();
				}

				System.out.println("Enter y to continue..");
				String ch = sc.nextLine();
				if (!ch.equalsIgnoreCase("y")) {
					break;
				}
			}
				else
					System.out.println("Invalid Username or password");
			}

			else if (option1 == 2) {
				System.out.println("Enter Username");
				String username=sc.nextLine();
				System.out.println("Enter Password");
				String password=sc.nextLine();
				
				if((username.equals("User"))&&(password.equals("User123")))
				{
				System.out.println("Enter 1. Add member 2.Update member by id 3.List Member by Id");
				int option = Integer.parseInt(sc.nextLine());
				try {
					switch (option) {
					case 1:
						MemberInformation mem = new MemberInformation();
						addMember(mem, option1);
						System.out.println("New Member Added: ");
						break;
					case 2:
						System.out.println("Enter Member Id");
						Integer memId = Integer.parseInt(sc.nextLine());
						mem = getMemberById(memId);
						System.out.println(mem);
						break;
					case 3:
						System.out.println("Enter product id to be updated: ");
						Integer memberId = Integer.parseInt(sc.nextLine());
						mem = getMemberById(memberId);
						MemberInformation updatedMember = updateMember(mem);
						System.out.println(updatedMember);
						break;
					default:
						System.out.println("Invalid option");
						break;

					}

				} catch (UserException e) {
					plLogger.error(e.getMessage(),e);
				}

				System.out.println("Enter y to continue..");
				String ch = sc.nextLine();
				if (!ch.equalsIgnoreCase("y")) {
					break;
				}

			}}
//		}else if(option1==3) 
//		{
//			UserDao userDao=new UserDaoImpl();
//			
//			System.out.println("Enter Username");
//			String userName=sc.nextLine();
//			System.out.println("Enter Password");
//			String password=sc.nextLine();
//			try {
////			userDao.addUser(user);
//			userDao.addUser(userName, password);
//			}catch (PersistenceException e) {
//				plLogger.error(e.getMessage(),e);
//			}
//		}
			else
			System.out.println("Invalid Username or password");
		}
	}

	private static MemberInformation updateMember(MemberInformation memberInformation) throws UserException {
		System.out.println("Existing age of " + memberInformation.getFirstName() + " is " + memberInformation.getAge());
		System.out.println("Enter new age: ");
		memberInformation.setAge(sc.nextInt());

		MemberInformation updatedMember = memberInformationService.updateMember(memberInformation);
		return updatedMember;

	}

	private static MemberInformation getMemberById(Integer memberId) throws UserException {
		return memberInformationService.getMemberById(memberId);

	}

	private static void addMember(MemberInformation memberInformation, Integer option1) throws UserException, AdminException {
		System.out.println("Enter First name");
		String firstName = sc.nextLine();
		System.out.println("Enter Last name");
		String lastName = sc.nextLine();
		System.out.println("Enter age");
		Integer age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter gender");
		String gender = sc.nextLine();
		Gender gen;
		if (gender.equalsIgnoreCase("female")) {
			gen = Gender.FEMALE;
		} else if (gender.equalsIgnoreCase("male")) {
			gen = Gender.MALE;
		} else if (gender.equalsIgnoreCase("other")) {
			gen = Gender.OTHER;
		} else {
			throw new UserException("Invalid gender option");
		}
		// convert String to LocalDate
		System.out.println("Enter birth date(dd/mm/yyyy): ");
		String strDate = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate date = LocalDate.parse(strDate, formatter);

		System.out.println("Enter educational Details");
		String educationDetails = sc.nextLine();

		System.out.println("Enter Marital Status");
		String maritalStatus = sc.nextLine();
		MaritalStatus maritalStatus1;
		if (maritalStatus.equalsIgnoreCase("MARRIED")) {
			maritalStatus1 = MaritalStatus.MARRIED;

		} else if (maritalStatus.equalsIgnoreCase("UNMARRIED")) {
			maritalStatus1 = MaritalStatus.UNMARRIED;
		} else {
			throw new UserException("Invalid Marital status option");
		}

		System.out.println("Enter Relationship Status");
		String relation = sc.nextLine();
		Relationship relationship;
		if (relation.equalsIgnoreCase("mother")) {
			relationship = Relationship.MOTHER;

		} else if (relation.equalsIgnoreCase("father")) {
			relationship = Relationship.FATHER;
		} else if (relation.equalsIgnoreCase("daughter")) {
			relationship = Relationship.DAUGHTER;
		} else if (relation.equalsIgnoreCase("son")) {
			relationship = Relationship.SON;
		} else {
			throw new UserException("Invalid gender option");
		}
		memberInformation = anmemberInformationBuilder().withFirstName(firstName).withLastName(lastName).withAge(age).withGender(gen).withDob(date)
				.withEducationDetails(educationDetails).withMaritalStatus(maritalStatus1).withRelationship(relationship).build();

		if (option1 == 1)
			service.addMember(memberInformation);
		else
			memberInformationService.addMember(memberInformation);

	}

	private static MemberInformation searchMemberByLastName(String lastName) throws AdminException {

		return service.searchMemberByLastName(lastName);
	}

	private static MemberInformation searchMemberByFirstName(String firstName) throws AdminException {

		return service.searchMemberByFirstName(firstName);
	}

	private static MemberInformation searchMemberById(Integer memberId) throws AdminException {

		return service.searchMemberById(memberId);

	}

	private static int deleteMember(Integer memberId) throws AdminException {
		return service.deleteMember(memberId);

	}

}
