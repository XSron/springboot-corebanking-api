package edu.mum.cs.cs425.corebankapi.model.setting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Entity
public class UtilitySetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	public UtilitySetting(){
		
	}
	
	
	
	public UtilitySetting(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
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
	



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	@Override
	public String toString() {
		return "UtilitySetting [id=" + id + ", name=" + name + ", account=" + account + "]";
	}



	
	
	

}
