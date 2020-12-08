package com.cg.training.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String applicationId;

	public Application() {
		super();
	}

	public Application(String applicationId) {
		super();
		this.applicationId = applicationId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + "]";
	}
	
	

}
