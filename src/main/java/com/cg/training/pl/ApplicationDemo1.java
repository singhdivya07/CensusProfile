package com.cg.training.pl;


import com.cg.training.entity.*;
import com.cg.training.exception.UserException;
import com.cg.training.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;



public class ApplicationDemo1 {
private static Scanner sc = new Scanner(System.in);
private static UserService userService = new UserServiceImpl();
	public static void main(String[] args) {
		while(true) {
			System.out.println("Enter 1. Add member 2.List Member by Id 3.Update member by id");
			int option= Integer.parseInt(sc.nextLine());
			try {
				switch(option) {
				case 1: MemberInformation mem=new MemberInformation();
						addMember(mem);
						System.out.println("New Member Added: ");
						break;
				case 2: System.out.println("Enter Member Id");
				        Integer memId = Integer.parseInt(sc.nextLine());
				        mem = getMemberById(memId);	
				        System.out.println(mem);
				break;		
				case 3: System.out.println("Enter product id to be updated: ");
						Integer memberId= Integer.parseInt(sc.nextLine());
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
			String ch=sc.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}
			
			
		}

		
		
		
		
		
		
		
		
		
	}
	private static MemberInformation updateMember(MemberInformation mem) throws UserException {
		System.out.println("Existing age of "+mem.getFirstName()+ " is "+mem.getAge());
		System.out.println("Enter new age: ");
		mem.setAge(sc.nextInt());
		
		MemberInformation updatedMember= userService.updateMember(mem);
		return updatedMember;
		
	}
	private static MemberInformation getMemberById(Integer memberId) throws UserException{
		return userService.getMemberById(memberId);	
		
	}
	private static void addMember(MemberInformation memInfo) throws UserException {


		System.out.println("Enter First name");
		memInfo.setFirstName(sc.nextLine());
		
		System.out.println("Enter Last name");
		memInfo.setLastName(sc.nextLine());
		
		System.out.println("Enter age");
		memInfo.setAge(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Enter gender");
		String gender=sc.nextLine();
		if(gender.equalsIgnoreCase("female"))
		{
			memInfo.setGender(Gender.FEMALE);
		}
		else if(gender.equalsIgnoreCase("male")) {
			memInfo.setGender(Gender.MALE);
		}
		else if(gender.equalsIgnoreCase("other")) {
			memInfo.setGender(Gender.OTHER);
		}
		else {
			System.out.println("Invalid gender option");
		}
		//convert String to LocalDate
		System.out.println("Enter birth date(dd/mm/yyyy): ");
		String strDate=sc.nextLine();	
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		memInfo.setDob(LocalDate.parse(strDate, formatter));
		
		System.out.println("Enter educational Details");
		memInfo.setEducationDetails(sc.nextLine());
		
		System.out.println("Enter Marital Status");
		String maritalStatus=sc.nextLine();
		if(maritalStatus.equalsIgnoreCase("MARRIED"))
		{
			memInfo.setMaritalStatus(MaritalStatus.MARRIED);
		}
		else if(maritalStatus.equalsIgnoreCase("UNMARRIED")) {
			memInfo.setMaritalStatus(MaritalStatus.UNMARRIED);
		}
		else {
			System.out.println("Invalid Marital status option");
		}
		
		
		System.out.println("Enter Relationship Status");
		String relation=sc.nextLine();
		if(relation.equalsIgnoreCase("mother"))
		{
			memInfo.setRelationship(Relationship.MOTHER);
		}
		else if(relation.equalsIgnoreCase("father")) {
			memInfo.setRelationship(Relationship.FATHER);
		}
		else if(relation.equalsIgnoreCase("daughter")) {
			memInfo.setRelationship(Relationship.DAUGHTER);
		}
		else if(relation.equalsIgnoreCase("son")) {
			memInfo.setRelationship(Relationship.SON);
		}
		else {
			System.out.println("Invalid gender option");
		}
		
		
        userService.addMember(memInfo);

		
		
	}
		
		
		
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		