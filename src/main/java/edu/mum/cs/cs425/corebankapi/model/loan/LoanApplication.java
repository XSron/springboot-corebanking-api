package edu.mum.cs.cs425.corebankapi.model.loan;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Table(name = "loanapplications")
@Entity
public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Column(name = "loan_application_number", nullable = false, unique = true)
	private String loanApplicationNumber;
	@NotNull
	@Column(name = "loan_amount", nullable = false)
	private double loanAmount;
	@NotNull
	@Column(name = "interest_rate", nullable = false)
	private double interestRate;
	@NotNull
	@Column(name = "length", nullable = false)
	private int length;
	@NotNull
	@Column(name = "loan_date", nullable = false)
	private LocalDate loanDate;
	@NotNull
	@Column(name = "active", nullable = false)
	private boolean active;
	@ManyToOne 
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToMany(mappedBy = "loanApplication")
	@NotNull
	private List<Schedule> schedules;
	public LoanApplication() {}
	public LoanApplication(@NotBlank String loanApplicationNumber, @NotNull double loanAmount,
			@NotNull double interestRate, @NotNull int length, @NotNull LocalDate loanDate, @NotNull boolean active,
			Customer customer, @NotNull List<Schedule> schedules) {
		super();
		this.loanApplicationNumber = loanApplicationNumber;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.length = length;
		this.loanDate = loanDate;
		this.active = active;
		this.customer = customer;
		this.schedules = schedules;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLoanApplicationNumber() {
		return loanApplicationNumber;
	}
	public void setLoanApplicationNumber(String loanApplicationNumber) {
		this.loanApplicationNumber = loanApplicationNumber;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public LocalDate getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
