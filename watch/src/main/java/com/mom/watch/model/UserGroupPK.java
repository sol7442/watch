package com.mom.watch.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the UserGroup database table.
 * 
 */
@Embeddable
public class UserGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String groupId;

	@Column(insertable=false, updatable=false)
	private String userId;

	public UserGroupPK() {
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
		if (!(other instanceof UserGroupPK)) {
			return false;
		}
		UserGroupPK castOther = (UserGroupPK)other;
		return 
			this.groupId.equals(castOther.groupId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}