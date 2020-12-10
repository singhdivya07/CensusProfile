package com.cg.training.util;

import static com.cg.training.entity.MemberInformationBuilder.anmemberInformationBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.cg.training.entity.Gender;
import com.cg.training.entity.MaritalStatus;
import com.cg.training.entity.MemberInformation;
import com.cg.training.entity.Relationship;
import com.cg.training.exception.AdminException;
import com.cg.training.service.AdminService;
import com.cg.training.service.AdminServiceImpl;

public class AdminUtil {

	private static Scanner sc = new Scanner(System.in);
	private static AdminService service = new AdminServiceImpl();
//	private static Logger plLogger=Logger.getLogger(ApplicationDemo1.class);
	

	//public  MemberInformation addMember(MemberInformation memberInformation,int noOfMembers) throws  AdminException
	public  MemberInformation addMember(MemberInformation memberInformation) throws  AdminException 
	{

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
            throw new AdminException("Invalid gender option");
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
            throw new AdminException("Invalid Marital status option");
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
            throw new AdminException("Invalid gender option");
        }
        memberInformation = anmemberInformationBuilder().withFirstName(firstName).withLastName(lastName).withAge(age).withGender(gen).withDob(date)
                .withEducationDetails(educationDetails).withMaritalStatus(maritalStatus1).withRelationship(relationship).build();

 

        
            service.addMember(memberInformation);
    

 

        return service.addMember(memberInformation);
        //return service.addMember(memberInformation,noOfMembers);
	}
	
	public  MemberInformation searchMemberById(Integer memberId) throws AdminException
	{
		return service.searchMemberById(memberId);

	}
	
	public  List<MemberInformation> searchMemberByLastName(String lastName) throws AdminException {
		return service.searchMemberByLastName(lastName);
	}

	public  List<MemberInformation> searchMemberByFirstName(String firstName) throws AdminException {

		return service.searchMemberByFirstName(firstName);
	}

	

}
