package edu.mum.cs.cs425.corebankapi.model.loan;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "schedules")
@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long scheduleId;
	@NotNull
	@Column(name = "principal", nullable = false)
	private double principal;
	@NotNull
	@Column(name = "interest", nullable = false)
	private double interest;
	@NotNull
	@Column(name = "outstanding_balance", nullable = false)
	private double outstandingBalance;
	@NotNull
	@Column(name = "payment_date", nullable = false)
	private LocalDate paymentDate;
	private LocalDate actualPaymentDate;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "loan_application_id")
	private LoanApplication loanApplication;
	public Schedule() {}
	public Schedule(@NotNull double principal, @NotNull double interest, @NotNull double outstandingBalance,
			@NotNull LocalDate paymentDate, LocalDate actualPaymentDate, @NotNull LoanApplication loanApplication) {
		super();
		this.principal = principal;
		this.interest = interest;
		this.outstandingBalance = outstandingBalance;
		this.paymentDate = paymentDate;
		this.actualPaymentDate = actualPaymentDate;
		this.loanApplication = loanApplication;
	}

	public long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getOutstandingBalance() {
		return outstandingBalance;
	}
	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public LocalDate getActualPaymentDate() {
		return actualPaymentDate;
	}
	public void setActualPaymentDate(LocalDate actualPaymentDate) {
		this.actualPaymentDate = actualPaymentDate;
	}
	public LoanApplication getLoanApplication() {
		return loanApplication;
	}
	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
}
