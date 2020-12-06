package com.cg.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.training.service.Role;

@Entity
@Table(name="actor_information")
public class Actor {
	
	@Id
	@Column(name="actor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer actorId;
	@Column(name="actor_name",nullable=false)
	private String actorName;
	private String password;
	private Role role;
	public Actor() {
		super();
	}
	public Actor(Integer actorId, String actorName, String password, Role role) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
		this.password = password;
		this.role = role;
	}
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	

}
