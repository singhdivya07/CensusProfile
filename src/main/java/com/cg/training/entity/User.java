package com.cg.training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="user_information")
public class User 
{
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;

	@Column(name="user_name")
	private String userName;
	
	
	private String password;
//
//	 @OneToOne(cascade=CascadeType.ALL)
//	    @JoinColumn(name="address_id")
//	    private AddressBi addressBi;
//	    
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//	@JoinColumn(name="application_id")
	//private List<Application> applicationList=new ArrayList<>() ;
	private Application application;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

//	
//	public User(Integer userId, String userName, String password, List<Application> applicationList) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//		this.applicationList = applicationList;
//	}
	
	
	public User(Integer userId, String userName, String password, Application application) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.application = application;
	}



	public Integer getUserId() {
		return userId;
	}

	

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) 
	{
		application.setUser(this);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", application="
				+ application + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	
//	public List<Application> getApplication() {
//		return applicationList;
//	}
//
//
//	public void setApplication(Application application)
//	{
//		applicationList.add(application);
//		application.setUser(this);
//		
//	}

//
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", application="
//				+ applicationList + "]";
//	}






}
