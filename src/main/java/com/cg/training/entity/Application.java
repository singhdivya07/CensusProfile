package com.cg.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer applicationId;

	public Application() {
		super();
	}

	public Application(Integer applicationId) {
		super();
		this.applicationId = applicationId;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + "]";
	}
	
	

}
