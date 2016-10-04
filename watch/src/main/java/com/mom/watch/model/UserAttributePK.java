package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UserAttribute database table.
 * 
 */
@Embeddable
public class UserAttributePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String attributeId;

	@Column(insertable=false, updatable=false)
	private String userId;

	public UserAttributePK() {
	}
	public String getAttributeId() {
		return this.attributeId;
	}
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
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
		if (!(other instanceof UserAttributePK)) {
			return false;
		}
		UserAttributePK castOther = (UserAttributePK)other;
		return 
			this.attributeId.equals(castOther.attributeId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.attributeId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}