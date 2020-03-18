package edu.mum.cs.cs425.corebankapi.model.paycheck;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Entity
@Table(name = "paycheckdetails")
public class PaycheckDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "paycheck_id")
	private Paycheck paycheck;
	private double amount;
	@OneToOne
	@JoinColumn(name = "to_account_id")
	private Account account;
	private boolean seen;
	public PaycheckDetail() {}
	public PaycheckDetail(Paycheck paycheck, double amount, Account account, boolean seen) {
		super();
		this.paycheck = paycheck;
		this.amount = amount;
		this.account = account;
		this.seen = seen;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Paycheck getPaycheck() {
		return paycheck;
	}
	public void setPaycheck(Paycheck paycheck) {
		this.paycheck = paycheck;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
}
