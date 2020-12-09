package com.cg.training.entity;

public class ActorBuilder {
	private String actorId;
	private String actorName;
	private String password;
	private Role role;

	public ActorBuilder withActorId(String actorId) {
		this.actorId = actorId;
		return this;
	}

	public ActorBuilder withActorName(String actorName) {
		this.actorName = actorName;
		return this;
	}

	public ActorBuilder withPassword(String password) {
		this.password = password;
		return this;
	}

	public ActorBuilder withRole(Role role) {
		this.role = role;
		return this;
	}

	public Actor build() {
		return new Actor();
	}
}