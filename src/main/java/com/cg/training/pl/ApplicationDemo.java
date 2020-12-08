package com.cg.training.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import com.cg.training.Entity.Gender;
import com.cg.training.Entity.MaritalStatus;
import com.cg.training.Entity.MemberInformation;
import com.cg.training.Entity.Relationship;
import com.cg.training.exception.AdminException;
import com.cg.training.service.AdminService;
import com.cg.training.service.AdminServiceImpl;


public class ApplicationDemo 
{
	private static AdminService service= new AdminServiceImpl();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws AdminException {
		while(true) {
			System.out.println("Enter 1. Add member 2. Delete member 3. search by id 4.search by first name 5. search by last name ");
			int option= Integer.parseInt(sc.nextLine());
			try {
				switch(option) {
				case 1: MemberInformation memberInformation=new MemberInformation();
						addMember(memberInformation);
						System.out.println("new member Added");
						break;
//				case 2: System.out.println("Enter product Id");
//						Integer productId = Integer.parseInt(scanner.nextLine());
//						product= getProductById(productId);						
//						System.out.println(product);
//						break;
				case 2: System.out.println("Enter member id: ");
						Integer memberId= Integer.parseInt(sc.nextLine());
						int id= deleteMember(memberId);
						System.out.println("Product: "+id+" deleted");
						break;
				case 3:	
						System.out.println("Enter Member Id");
				        memberId = Integer.parseInt(sc.nextLine());
				        memberInformation = searchMemberById(memberId);	
				        System.out.println(memberInformation);
				        break;		
				        
				case 4:	
						System.out.println("Enter Member first name");
				        String firstName = sc.nextLine();
				        memberInformation = searchMemberByFirstName(firstName);	
				        System.out.println(memberInformation);
				        break;	
		        
				case 5:	
						System.out.println("Enter Member last name");
				        String lastName = sc.nextLine();
				        memberInformation = searchMemberByLastName(lastName);	
				        System.out.println(memberInformation);
				        break;		
//				case 3: List<Product> productList= getAllProducts();
//						productList.stream().forEach(System.out::println);
//						break;
//				case 5:System.out.println("Enter product Id to be updated-");
//						productId=Integer.parseInt(scanner.nextLine());
//						product=getProductById(productId);
//						Product updatedproduct=updateProduct(product);
//						System.out.println(updatedproduct);
				default:System.out.println("Invalid option");
						 break;				
				
				}
				
				
			}catch(PersistenceException e) {
				e.printStackTrace();
			}
			
			System.out.println("Enter y to continue..");
			String ch=sc.nextLine();
			if(!ch.equalsIgnoreCase("y")) {
				break;
			}
		
	}

}
	
	private static MemberInformation searchMemberByLastName(String lastName) throws AdminException {
		// TODO Auto-generated method stub
		return service.searchMemberByLastName(lastName);
	}

	private static MemberInformation searchMemberByFirstName(String firstName) throws AdminException {
		// TODO Auto-generated method stub
		return service.searchMemberByFirstName(firstName);
	}

	private static MemberInformation searchMemberById(Integer memberId) throws AdminException
	{
		return service.searchMemberById(memberId);
		
	}

	private static int deleteMember(Integer memberId) throws AdminException {
		return service.deleteMember(memberId);
		
	}
	private static void addMember(MemberInformation memInfo) throws AdminException {
		
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
		
		service.addMember(memInfo);
		
	}
}