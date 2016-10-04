package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Attribute database table.
 * 
 */
@Entity
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String attributeId;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	//bi-directional many-to-one association to UserAttribute
	@OneToMany(mappedBy="attribute")
	private List<UserAttribute> userAttributes;

	public Attribute() {
	}

	public String getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<UserAttribute> getUserAttributes() {
		return this.userAttributes;
	}

	public void setUserAttributes(List<UserAttribute> userAttributes) {
		this.userAttributes = userAttributes;
	}

	public UserAttribute addUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().add(userAttribute);
		userAttribute.setAttribute(this);

		return userAttribute;
	}

	public UserAttribute removeUserAttribute(UserAttribute userAttribute) {
		getUserAttributes().remove(userAttribute);
		userAttribute.setAttribute(null);

		return userAttribute;
	}

}