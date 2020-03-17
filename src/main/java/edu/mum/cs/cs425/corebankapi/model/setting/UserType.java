package edu.mum.cs.cs425.corebankapi.model.setting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userTypeId;
	private String type;
	
	public UserType() {
		
	}
	
	public UserType(String type) {
		super();
		this.type = type;
	}
	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", type=" + type + "]";
	}
	
	
	

}
