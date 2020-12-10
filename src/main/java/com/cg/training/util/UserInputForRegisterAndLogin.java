package com.cg.training.util;

import java.util.Scanner;

import com.cg.training.entity.User;
import com.cg.training.exception.UserException;
import com.cg.training.service.UserService;
import com.cg.training.service.UserServiceImpl;

public class UserInputForRegisterAndLogin 
{
	private static Scanner sc = new Scanner(System.in);
	private static UserService service=new UserServiceImpl();
	
	public User addUser(User user) throws UserException{
		
		
		System.out.println("Enter Username");
		user.setUserName(sc.nextLine());
		System.out.println("Enter Password");
		user.setPassword(sc.nextLine());
		return service.addUser(user);
		
	}
}
