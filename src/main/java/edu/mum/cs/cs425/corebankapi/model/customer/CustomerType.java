package edu.mum.cs.cs425.corebankapi.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "customertypes")
@Entity
public class CustomerType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerTypeId;
	@NotBlank
	@Column(name = "customer_type_name", nullable = false)
	private String customerTypeName;
	public CustomerType() {}
	public CustomerType(@NotBlank String customerTypeName) {
		super();
		this.customerTypeName = customerTypeName;
	}
	public int getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	public String getCustomerTypeName() {
		return customerTypeName;
	}
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}
}
