package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String firstName;

	private String lastName;

	//bi-directional many-to-one association to UserAttribute
	@OneToMany(mappedBy="user")
	private List<UserAttribute> userAttributes;

	//bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy="user")
	private List<UserGroup> userGroups;

	//bi-directional many-to-one association to UserOrganization
	@OneToMany(mappedBy="user")
	private List<UserOrganization> userOrganizations;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<UserAttribute> getUserAttributes() {
		return this.userAttributes;
	}

	public void setUserAttributes(List<UserAttribute> userAttributes) {
		this.userAttributes = userAttributes;
	}

	public UserAttribute addUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().add(userAttribute);
		userAttribute.setUser(this);

		return userAttribute;
	}

	public UserAttribute removeUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().remove(userAttribute);
		userAttribute.setUser(null);

		return userAttribute;
	}

	public List<UserGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserGroup addUserGroup(UserGroup userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setUser(this);

		return userGroup;
	}

	public UserGroup removeUserGroup(UserGroup userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setUser(null);

		return userGroup;
	}

	public List<UserOrganization> getUserOrganizations() {
		return this.userOrganizations;
	}

	public void setUserOrganizations(List<UserOrganization> userOrganizations) {
		this.userOrganizations = userOrganizations;
	}

	public UserOrganization addUserOrganization(UserOrganization userOrganization) {
		getUserOrganizations().add(userOrganization);
		userOrganization.setUser(this);

		return userOrganization;
	}

	public UserOrganization removeUserOrganization(UserOrganization userOrganization) {
		getUserOrganizations().remove(userOrganization);
		userOrganization.setUser(null);

		return userOrganization;
	}

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(userId).append(":");
		buffer.append(firstName).append(".");
		buffer.append(lastName).append("");
		return buffer.toString();
	}
}