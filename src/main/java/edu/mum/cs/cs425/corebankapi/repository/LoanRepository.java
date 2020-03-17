package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;

public interface LoanRepository extends JpaRepository<LoanApplication, Long> {
	@Query(value = "SELECT COUNT(*) FROM loanApplication", nativeQuery = true)
	public String generateLoanApplicationNumber();
}
