package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UserOrganization database table.
 * 
 */
@Embeddable
public class UserOrganizationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String organizationId;

	@Column(insertable=false, updatable=false)
	private String userId;

	public UserOrganizationPK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserOrganizationPK)) {
			return false;
		}
		UserOrganizationPK castOther = (UserOrganizationPK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}