package com.cg.training.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

//inverse side

@Entity
public class Application {
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer applicationId;

	@OneToMany(mappedBy = "application")
	private List<MemberInformation> members=new ArrayList<MemberInformation>();
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	

	public Application() {
		// TODO Auto-generated constructor stub
	}


	public Application(Integer applicationId, List<MemberInformation> members, User user) {
		super();
		this.applicationId = applicationId;
		this.members = members;
		this.user = user;
	}


	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public List<MemberInformation> getMembers() {
		return members;
	}
	
	
	public void setMembers(MemberInformation member)
	{
		members.add(member);
		member.setApplication(this);
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", members=" + members + ", user=" + user + "]";
	}



}
