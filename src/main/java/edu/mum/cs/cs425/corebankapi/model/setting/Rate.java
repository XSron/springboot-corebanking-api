package edu.mum.cs.cs425.corebankapi.model.setting;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rate {
	
	@Id
	private Long rateId;
	private Double loanRate;
	private Double savingRate;
	
	public Rate() {
		
	}
	
	
	
	
	public Rate(Double loanRate, Double savingRate) {
		super();
		this.loanRate = loanRate;
		this.savingRate = savingRate;
	}



	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	public Double getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	}
	public Double getSavingRate() {
		return savingRate;
	}
	public void setSavingRate(Double savingRate) {
		this.savingRate = savingRate;
	}




	@Override
	public String toString() {
		return "Rate [loanRate=" + loanRate + ", savingRate=" + savingRate + "]";
	}
	
	
	

}
