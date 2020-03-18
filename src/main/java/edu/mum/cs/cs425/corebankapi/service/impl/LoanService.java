package edu.mum.cs.cs425.corebankapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;
import edu.mum.cs.cs425.corebankapi.repository.LoanRepository;
import edu.mum.cs.cs425.corebankapi.repository.ScheduleRepository;
import edu.mum.cs.cs425.corebankapi.service.ILoanService;

@Service
public class LoanService implements ILoanService {
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		if(loanApplication != null) {
			String loanAppNumber = loanRepository.generateLoanNumber();
			loanApplication.setLoanApplicationNumber(loanAppNumber);
			loanApplication.setLoanDate(LocalDate.now());
			loanApplication.setActive(true);
			List<Schedule> listofSchedules = loanApplication.getSchedules();
			for(Schedule schedule: listofSchedules)
				schedule.setLoanApplication(loanApplication);
			loanRepository.save(loanApplication);
		}
	}

	@Override
	public Iterable<LoanApplication> getLoanApplication() {
		return loanRepository.findAll();
	}

	@Override
	public LoanApplication getLoanApplicationByNumber(String loanNumber) {
		return loanRepository.getLoanByNumber(loanNumber);
	}

	@Override
	public List<Schedule> getSchedulesByLoanId(long id) {
		return scheduleRepository.getSchedulesByLoanId(id);
	}
}
