package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Long> {
	@Query(value = "SELECT * FROM loanapplications WHERE loan_application_number = :loanNumber", nativeQuery = true)
	public LoanApplication getLoanByNumber(@Param("loanNumber") String loanNumber);
	@Query(value = "SELECT CONCAT('LAPP-', IFNULL(MAX(RIGHT(loan_application_number, LENGTH(loan_application_number) - 5)), 0) + 1) FROM loanapplications", nativeQuery = true)
	public String generateLoanNumber();
}
