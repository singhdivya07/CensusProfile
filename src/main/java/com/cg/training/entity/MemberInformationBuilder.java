package com.cg.training.entity;

import java.time.LocalDate;

public final class MemberInformationBuilder {
		private Integer memberId;
		private String firstName;
		private String lastName;
		private Integer age;
		private Gender gender;
		private LocalDate dob;
		private String educationDetails;
		private MaritalStatus maritalStatus;
		private Relationship relationship;
		
		
		public MemberInformationBuilder()
		{
			
		}
		
		public static MemberInformationBuilder anmemberInformationBuilder() 
		{
			return new MemberInformationBuilder();
		}
		
		

		

		public MemberInformationBuilder withMemberId(Integer memberId) {
			this.memberId = memberId;
			return this;
		}

		public MemberInformationBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public MemberInformationBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public MemberInformationBuilder withAge(Integer age) {
			this.age = age;
			return this;
		}

		public MemberInformationBuilder withGender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public MemberInformationBuilder withDob(LocalDate dob) {
			this.dob = dob;
			return this;
		}

		public MemberInformationBuilder withEducationDetails(String educationDetails) {
			this.educationDetails = educationDetails;
			return this;
		}

		public MemberInformationBuilder withMaritalStatus(MaritalStatus maritalStatus) {
			this.maritalStatus = maritalStatus;
			return this;
		}

		public MemberInformationBuilder withRelationship(Relationship relationship) {
			this.relationship = relationship;
			return this;
		}

		public MemberInformation build() {
			MemberInformation memberInfo = new MemberInformation();
			memberInfo.setFirstName(firstName);
			memberInfo.setLastName(lastName);
			memberInfo.setAge(age);
			memberInfo.setGender(gender);
			memberInfo.setDob(dob);
			memberInfo.setEducationDetails(educationDetails);
			memberInfo.setRelationship(relationship);
			memberInfo.setMaritalStatus(maritalStatus);
		
			 return memberInfo;
			
			
			
			
			
			
					}
	}
