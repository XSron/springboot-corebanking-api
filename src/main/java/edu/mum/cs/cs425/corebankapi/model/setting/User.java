package edu.mum.cs.cs425.corebankapi.model.setting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Entity
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String password;
	private Boolean Locked = false;
	@ManyToOne
	@JoinColumn(name="userType_id")
	private UserType userType;
	@OneToOne
	@JoinColumn(name="customer_id", unique = true)
	private Customer customer;	

	public User () {
		
	}
	

	
	public User(String userName, String password, Boolean Locked, UserType userType, Customer customer) {
		super();
		this.userName = userName;
		this.password = password;
		this.Locked =  Locked;
		this.userType = userType;
		this.customer = customer;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getLocked() {
		return Locked;
	}

	public void setLocked(Boolean locked) {
		Locked = locked;
	}

	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
//	public long getCustomerId() {
//		return customerId;
//	}
//
//
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//		
//	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", Locked=" + Locked
				+ ", userType=" + userType + "]";
	}
}
