package edu.mum.cs.cs425.corebankapi.service;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;

public interface ILoanService {
	public void saveLoanApplication(LoanApplication loanApplication);
	public Iterable<LoanApplication> getLoanApplication();
	public String generateLoanApplicationNumber();
}
