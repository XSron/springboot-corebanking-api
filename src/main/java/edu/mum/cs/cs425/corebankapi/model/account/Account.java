package edu.mum.cs.cs425.corebankapi.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Table(name = "accounts")
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	@NotBlank
	@Column(name = "account_number", nullable = false)
	private String accountNumber;
	private double balance;
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "account_type_id")
	private AccountType accountType;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "customer_id", insertable = false, updatable = false)
	private long customerId;
	@Column(name = "account_type_id", insertable = false, updatable = false)
	private int accountTypeId;
	public Account() {}
	public Account(@NotBlank String accountNumber, double balance, boolean active, AccountType accountType,
			Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.active = active;
		this.accountType = accountType;
		this.customer = customer;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
		accountType = new AccountType();
		accountType.setAccountTypeId(accountTypeId);
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
		customer = new Customer();
		customer.setCustomerId(customerId);
	}
}
