package edu.mum.cs.cs425.corebankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.repository.LoanRepository;
import edu.mum.cs.cs425.corebankapi.service.ILoanService;

@Service
public class LoanService implements ILoanService {
	@Autowired
	private LoanRepository loanRepository;
	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		if(loanApplication != null)
			loanRepository.save(loanApplication);
	}

	@Override
	public Iterable<LoanApplication> getLoanApplication() {
		return loanRepository.findAll();
	}

	@Override
	public String generateLoanApplicationNumber() {
		return loanRepository.generateLoanApplicationNumber();
	}

}
