package com.cg.training.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.training.entity.Application;

@Entity
@Table(name = "member_information")
public class MemberInformation {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;
	@Column(name = "education_details")
	private String educationDetails;

	@Column(name = "marital_status")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	@Enumerated(EnumType.STRING)
	private Relationship relationship;
	
	
	
	//many to many mapping
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="application_id")  
		private Application application;


	public MemberInformation() {
		
	}


	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	@Override
	public String toString() {
		return "MemberInformation [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dob=" + dob + ", educationDetails=" + educationDetails
				+ ", maritalStatus=" + maritalStatus + ", relationship=" + relationship + "]";
	}

	
	}
