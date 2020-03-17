package edu.mum.cs.cs425.corebankapi.model.transaction;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Table(name = "transactions")
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "transaction_type_id")
	private TransactionType transactionType;
	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@OneToOne
	@JoinColumn(name = "from_account_id")
	private Account fromAccount;
	@OneToOne
	@JoinColumn(name = "to_account_id")
	private Account toAccount;
	private double amount;
	@NotBlank
	@Column(name = "transaction_date", nullable = false)
	private LocalDate transactionDate;
	@NotBlank
	@Column(name = "description", nullable = false)
	private String description;
	public Transaction() {}
	public Transaction(TransactionType transactionType, Account account, Account fromAccount, Account toAccount,
			double amount, LocalDate transactionDate, String description) {
		super();
		this.transactionType = transactionType;
		this.account = account;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
