package edu.mum.cs.cs425.corebankapi.model.setting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UtilitySetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String accountNumber;
	
	public UtilitySetting(){
		
	}
	
	
	
	public UtilitySetting(String name, String accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	@Override
	public String toString() {
		return "UtilitySetting [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + "]";
	}
	
	
	
	

}
