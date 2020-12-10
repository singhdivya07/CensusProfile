//package com.cg.training.entity;
//
//import javax.persistence.*;
//@Entity
//@Table(name="admin_information")
//public class Admin 
//{
//	
//	@Id
//	@Column(name="admin_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer adminId;
//
//	@Column(name="admin_name")
//	private String adminName;
//	
//	@Column(name="password")
//	private String password;
//	    
//	@OneToOne(mappedBy = "admin",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Application application;
//
//	public Admin() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public Admin(String adminName, String password) {
//		super();
//		this.adminName = adminName;
//		this.password = password;
//	}
//
//
//	
//	public Admin(Integer adminId, String adminName, String password, Application application) {
//		super();
//		this.adminId = adminId;
//		this.adminName = adminName;
//		this.password = password;
//		this.application = application;
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////
////	
////	public List<Application> getApplication() {
////		return applicationList;
////	}
////
////
////	public void setApplication(Application application)
////	{
////		applicationList.add(application);
////		application.setUser(this);
////		
////	}
//
////
////	@Override
////	public String toString() {
////		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", application="
////				+ applicationList + "]";
////	}
//
//
//
//
//
//
//}
