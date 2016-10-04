package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserGroup database table.
 * 
 */
@Entity
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserGroupPK id;

	private String extention;

	//bi-directional many-to-one association to Group
	@ManyToOne(optional=false)
	@JoinColumn(name="groupId",insertable=false, updatable=false)
	private Group group;

	//bi-directional many-to-one association to User
	@ManyToOne(optional=false)
	@JoinColumn(name="userId",insertable=false, updatable=false)
	private User user;

	public UserGroup() {
	}

	public UserGroupPK getId() {
		return this.id;
	}

	public void setId(UserGroupPK id) {
		this.id = id;
	}

	public String getExtention() {
		return this.extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}