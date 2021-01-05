package com.cg.training.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//owning side for one to one
//reverse side for one to many

@Entity
@Table(name="application")
public class Application {
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer applicationId;

	@OneToMany(mappedBy = "application")
	private Set<MemberInformation> members;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private Admin admin;
	
	public Application() {
	}


//	public Application(Integer applicationId, List<MemberInformation> members, User user) {
//		super();
//		this.applicationId = applicationId;
//		this.members = members;
//		this.user = user;
//	}
	
//	public Application(Integer applicationId, User user) {
//		super();
//		this.applicationId = applicationId;
//	
//		this.user = user;
//	}


	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public Set<MemberInformation> getMembers() {
		return members;
	}
	
	public void setMembers(Set<MemberInformation> members) {
		this.members = members;
	}


	//	
//	public void setMembers(MemberInformation member)
//	{
//		members.add(member);
//		member.setApplication(this);
//	}
//	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	
	}


//	public Admin getAdmin() {
//		return admin;
//	}
//
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}

	
//	@Override
//	public String toString() {
//		return "Application [applicationId=" + applicationId + ", user=" + user + "]";
//	}

}
