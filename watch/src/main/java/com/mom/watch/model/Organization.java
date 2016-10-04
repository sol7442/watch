package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String organizationId;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="parentId")
	private Organization organization;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="organization")
	private List<Organization> organizations;

	//bi-directional many-to-one association to UserOrganization
	@OneToMany(mappedBy="organization")
	private List<UserOrganization> userOrganizations;

	public Organization() {
	}

	public String getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
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

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public Organization addOrganization(Organization organization) {
		getOrganizations().add(organization);
		organization.setOrganization(this);

		return organization;
	}

	public Organization removeOrganization(Organization organization) {
		getOrganizations().remove(organization);
		organization.setOrganization(null);

		return organization;
	}

	public List<UserOrganization> getUserOrganizations() {
		return this.userOrganizations;
	}

	public void setUserOrganizations(List<UserOrganization> userOrganizations) {
		this.userOrganizations = userOrganizations;
	}

	public UserOrganization addUserOrganization(UserOrganization userOrganization) {
		getUserOrganizations().add(userOrganization);
		userOrganization.setOrganization(this);

		return userOrganization;
	}

	public UserOrganization removeUserOrganization(UserOrganization userOrganization) {
		getUserOrganizations().remove(userOrganization);
		userOrganization.setOrganization(null);

		return userOrganization;
	}

}