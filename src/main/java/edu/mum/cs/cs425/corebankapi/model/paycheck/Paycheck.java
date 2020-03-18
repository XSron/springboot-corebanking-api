package edu.mum.cs.cs425.corebankapi.model.paycheck;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Table(name = "paychecks")
@Entity
public class Paycheck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	@NotNull
	@Column(name = "payment_date", nullable = false)
	private LocalDate paymentDate;
	@NotNull
	@OneToMany(mappedBy = "paycheck", cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private List<PaycheckDetail> paycheckdetail;
	public Paycheck() {}
	public Paycheck(Account account, @NotNull LocalDate paymentDate, @NotNull List<PaycheckDetail> paycheckdetail) {
		super();
		this.account = account;
		this.paymentDate = paymentDate;
		this.paycheckdetail = paycheckdetail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public List<PaycheckDetail> getPaycheckdetail() {
		return paycheckdetail;
	}
	public void setPaycheckdetail(List<PaycheckDetail> paycheckdetail) {
		this.paycheckdetail = paycheckdetail;
	}
}
