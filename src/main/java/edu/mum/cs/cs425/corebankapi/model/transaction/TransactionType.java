package edu.mum.cs.cs425.corebankapi.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "transactiontypes")
@Entity
public class TransactionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionTypeId;
	@NotBlank
	@Column(name = "transaction_type_name", nullable = false)
	private String transactionTypeName;
	public TransactionType() {}
	public TransactionType(@NotBlank String transactionTypeName) {
		super();
		this.transactionTypeName = transactionTypeName;
	}
	public int getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getTransactionTypeName() {
		return transactionTypeName;
	}
	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}
}
