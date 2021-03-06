package com.cg.training.pl;

import java.util.Scanner;

import javax.persistence.PersistenceException;

import com.cg.training.dao.ApplicationDao;
import com.cg.training.dao.ApplicationDaoImpl;
import com.cg.training.dao.UserDao;
import com.cg.training.dao.UserDaoImpl;
import com.cg.training.entity.Application;
import com.cg.training.entity.User;

public class UserDemo {

	private static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {

		UserDao userDao=new UserDaoImpl();
		Application application=new Application();
		ApplicationDao applicationDao=new ApplicationDaoImpl();

		System.out.println("Enter Username");
		String userName=sc.nextLine();
		System.out.println("Enter Password");
		String password=sc.nextLine();
		try {
			User user=new User(userName,password);
			 user=userDao.addUser(user);

			application.setUser(user);
			applicationDao.addApplication(application);

		}
		catch (PersistenceException e) {
			//plLogger.error(e.getMessage(),e);
			e.printStackTrace();

		}

	}

}
