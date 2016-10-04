package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserAttribute database table.
 * 
 */
@Entity
@NamedQuery(name="UserAttribute.findAll", query="SELECT u FROM UserAttribute u")
public class UserAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserAttributePK id;

	private String extention;

	//bi-directional many-to-one association to Attribute
	@ManyToOne(optional=false)
	@JoinColumn(name="attributeId",insertable=false, updatable=false)
	private Attribute attribute;

	//bi-directional many-to-one association to User
	@ManyToOne(optional=false)
	@JoinColumn(name="userId",insertable=false, updatable=false)
	private User user;

	public UserAttribute() {
	}

	public UserAttributePK getId() {
		return this.id;
	}

	public void setId(UserAttributePK id) {
		this.id = id;
	}

	public String getExtention() {
		return this.extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}