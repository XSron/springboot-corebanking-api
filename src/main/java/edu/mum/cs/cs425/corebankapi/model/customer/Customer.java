package edu.mum.cs.cs425.corebankapi.model.customer;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Table(name = "customers")
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	@NotBlank
	@Column(name = "customer_name", nullable = false)
	private String customerName;
	@NotBlank
	@Column(name = "customer_number", nullable = false, unique = true)
	private String customerNumber;
	@NotBlank
	@Column(name = "contact_phone", nullable = false)
	private String contactPhone;
	@NotBlank
	@Column(name = "state", nullable = false)
	private String state;
	@NotBlank
	@Column(name = "city", nullable = false)
	private String city;
	@NotBlank
	@Column(name = "street", nullable = false)
	private String street;
	@NotBlank
	@Column(name = "zipcode", nullable = false)
	private String zipcode;
	private String apartmentNumber;
	@ManyToOne
	@JoinColumn(name = "customer_type_id")
	private CustomerType customerType;
	@OneToMany(mappedBy = "customer")
	@JsonManagedReference
	private List<Account> account;
	public Customer() {}
	public Customer(@NotBlank String customerName, @NotBlank String customerNumber, @NotBlank String contactPhone, @NotBlank String state,
			@NotBlank String city, @NotBlank String street, @NotBlank String zipcode, String apartmentNumber,
			CustomerType customerType) {
		super();
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.contactPhone = contactPhone;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.apartmentNumber = apartmentNumber;
		this.customerType = customerType;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
}
