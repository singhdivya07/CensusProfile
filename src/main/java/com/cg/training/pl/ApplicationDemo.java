package com.cg.training.pl;

import com.cg.training.entity.*;

import com.cg.training.exception.UserException;
import com.cg.training.service.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


import com.cg.training.dao.UserDaoImpl;


public class ApplicationDemo {
private static Scanner scanner = new Scanner(System.in);
private static UserService userService = new UserServiceImpl();
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter 1. Add product 2.List Member by Id 3.Update product");
			int option= Integer.parseInt(scanner.nextLine());
			try {
				switch(option) {
				case 1: MemberInformation mem=new MemberInformation();
						addMember(mem);
						System.out.println("New Member Added: ");
						break;
				case 2: System.out.println("Enter Member Id");
				        Integer memId = Integer.parseInt(scanner.nextLine());
				        mem = getMemberById(memId);	
				        System.out.println(mem);
				break;		
				case 3: System.out.println("Enter product id to be updated: ");
						Integer memberId= Integer.parseInt(scanner.nextLine());
						mem = getMemberById(memberId);	
						MemberInformation updatedMember= updateMember(mem);
					 	System.out.println(updatedMember);
					 	break;
				default: System.out.println("Invalid option");
						 break;				
				
				}
				
				
			}catch(UserException e) {
				e.printStackTrace();
			}
			
			System.out.println("Enter y to continue..");
			String ch=scanner.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}
			
			
		}

		
		
		
		
		
		
		
		
		
	}
	private static MemberInformation updateMember(MemberInformation mem) throws UserException {
		System.out.println("Existing age of "+mem.getFirstName()+ " is "+mem.getAge());
		System.out.println("Enter new age: ");
		mem.setAge(scanner.nextInt());
		
		MemberInformation updatedMember= userService.updateMember(mem);
		return updatedMember;
		
	}
	private static MemberInformation getMemberById(Integer memberId) throws UserException{
		return userService.getMemberById(memberId);	
		
	}
	private static void addMember(MemberInformation memInfo) throws UserException {

		System.out.println("Enter first name:");
		memInfo.setFirstName(scanner.nextLine());
		System.out.println("Enter Last name:");
		memInfo.setLastName(scanner.nextLine());
		System.out.println("Enter Age:");
		memInfo.setAge(scanner.nextInt());
		scanner.nextLine();
		memInfo.setGender(Gender.FEMALE);
		System.out.println(memInfo.getGender());
		memInfo.setDob(new Date());
		System.out.println("Enter Educational Details:");
		memInfo.setEducationDetails(scanner.nextLine());

		memInfo.setMaritalStatus(MaritalStatus.MARRIED);

        memInfo.setRelationship(Relationship.DAUGHTER);
		
        userService.addMember(memInfo);

		
		
	}
		
		
		
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		EntityManager entityManager =
//				Persistence.createEntityManagerFactory("census-profile-app1").createEntityManager();
//		try
//		{
//		 
//		
//		 entityManager.getTransaction().begin();
//		 MemberInformation memInfo = new MemberInformation();
//		Actor actor = new Actor();
//		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		//MemberInformation memInfo = new MemberInformation("shravani","mehetre",23,Gender.FEMALE,new Date(),"BE",MaritalStatus.MARRIED,Relationship.DAUGHTER);
//		memInfo.setFirstName("bhagay");
//		memInfo.setLastName("marekar");
//		memInfo.setAge(24);
//		memInfo.setGender(Gender.FEMALE);
//		memInfo.setDob(new Date());
//       memInfo.setEducationDetails("BE");
//       memInfo.setMaritalStatus(MaritalStatus.UNMARRIED);
//       memInfo.setRelationship(Relationship.MOTHER);
//		entityManager.persist(memInfo);
//		//entityManager.flush();
//		entityManager.getTransaction().commit();
//		}
//		catch(PersistenceException e)
//		{
//			entityManager.getTransaction().rollback();
//		}
//		finally {
//		entityManager.close();
//		}
//		System.out.println("Enter your choice");
//		int ch = sc.nextInt();
//		try
//		{
//		switch(ch)
//		{
//		case 1: 
//			MemberInformation memInfo = new MemberInformation();
//			
//		    addMember(memInfo);
//		    System.out.println("New Product Added product: ");
//		break;
//
////        case 2: 
////        	System.out.println("Enter product id to be updated: ");
////		    String memberId = sc.nextLine();
////		    	
////	 	    MemberInformation updatedMember= userDaoImpl.updateMember(memInfo);
////	 	    System.out.println(updatedMember);
////	 	break;
//         default: System.out.println("Invalid option");
//		 break;				
//		}
//		
//		}
//		catch(PersistenceException e)
//		{
//			e.printStackTrace();
//		}
//		
//
//	}
//	
//	
//
//	private static void addMember(MemberInformation memInfo) {
//		System.out.println("Enter Member id:");
//		memInfo.setMemberId(sc.nextInt());
//		sc.nextLine();
//		System.out.println("Enter first name:");
//		memInfo.setFirstName(sc.nextLine());
//		System.out.println("Enter Last name:");
//		memInfo.setLastName(sc.nextLine());
//		System.out.println("Enter Age:");
//		memInfo.setAge(sc.nextInt());
//		//System.out.println("Enter Gender:");
//		sc.nextLine();
//		memInfo.setGender(Gender.FEMALE);
//		System.out.println(memInfo.getGender());
////		String gender = sc.nextLine();
////		memInfo.setGender(Gender.valueOf(gender.toLowerCase().trim()));
//		System.out.println("Enter DOB: in dd/MM/yyyy Format");
//		String strDate = sc.nextLine();
//		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");		
//		memInfo.setDob(LocalDate.parse(strDate, formatter));
//		System.out.println("Enter Educational Details:");
//		memInfo.setEducationDetails(sc.nextLine());
////		System.out.println("Marital Status:");
////		String mi = sc.nextLine();
////		memInfo.setMaritalStatus(MaritalStatus.valueOf(mi.toUpperCase()));
//		memInfo.setMaritalStatus(MaritalStatus.MARRIED);
////		System.out.println("Enter relationship:");
////		String relation = sc.nextLine();
////		memInfo.setRelationship(Relationship.valueOf(relation.toUpperCase()));
//        memInfo.setRelationship(Relationship.DAUGHTER);
//		
//		userDaoImpl.addMember(memInfo);
//		
//		
//		
//		
          

