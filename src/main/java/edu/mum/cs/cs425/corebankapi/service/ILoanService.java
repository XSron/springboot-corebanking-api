package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;

@Service
public interface ILoanService {
	public void saveLoanApplication(LoanApplication loanApplication);
	public Iterable<LoanApplication> getLoanApplication();
	public LoanApplication getLoanApplicationByNumber(String loanNumber);
	public List<Schedule> getSchedulesByLoanId(long id);
}
