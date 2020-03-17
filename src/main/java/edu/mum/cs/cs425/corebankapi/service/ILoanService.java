package edu.mum.cs.cs425.corebankapi.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;

@Service
public interface ILoanService {
	public void saveLoanApplication(LoanApplication loanApplication);
	public Iterable<LoanApplication> getLoanApplication();
	public String generateLoanApplicationNumber();
}
