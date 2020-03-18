package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;

@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Long> {
	@Query(value = "SELECT * FROM loanapplications WHERE loan_application_number = :loanNumber", nativeQuery = true)
	public LoanApplication getLoanByNumber(@Param("loanNumber") String loanNumber);
	@Query(value = "SELECT CONCAT('LAPP-', IFNULL(MAX(RIGHT(loan_application_number, LENGTH(loan_application_number) - 5)), 0) + 1) FROM loanapplications", nativeQuery = true)
	public String generateLoanNumber();
	@Query(value = "SELECT * from schedules where loan_application_id = :loanId AND actual_payment_date IS NULL ORDER BY schedule_id LIMIT 1", nativeQuery = true)
	public Schedule getLoanSchedule(@Param("loanId") long loanId);
	@Modifying
	@Query(value = "UPDATE schedules set actual_payment_date = NOW() WHERE schedule_id = :scheduleId", nativeQuery = true)
	public void updateActualPaymentDate(@Param("scheduleId") long id);
	@Modifying
	@Query(value = "UPDATE loan_application set is_active = 0 WHERE loan_application_id = :loan_application_id", nativeQuery = true)
	public void updateLoanStatus(@Param("loan_application_id") long id);
}
