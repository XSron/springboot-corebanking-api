package edu.mum.cs.cs425.corebankapi.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "accounttypes")
@Entity
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountTypeId;
	@NotBlank
	@Column(name = "account_type_name", nullable = false)
	private String accountTypeName;
}
