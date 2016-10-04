package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserOrganization database table.
 * 
 */
@Entity
@NamedQuery(name="UserOrganization.findAll", query="SELECT u FROM UserOrganization u")
public class UserOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserOrganizationPK id;

	private String extention;

	//bi-directional many-to-one association to Organization
	@ManyToOne(optional=false)
	@JoinColumn(name="organizationId",insertable=false, updatable=false)
	private Organization organization;

	//bi-directional many-to-one association to User
	@ManyToOne(optional=false)
	@JoinColumn(name="userId",insertable=false, updatable=false)
	private User user;

	public UserOrganization() {
	}

	public UserOrganizationPK getId() {
		return this.id;
	}

	public void setId(UserOrganizationPK id) {
		this.id = id;
	}

	public String getExtention() {
		return this.extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}