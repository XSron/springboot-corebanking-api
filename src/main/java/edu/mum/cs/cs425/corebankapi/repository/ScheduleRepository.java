package edu.mum.cs.cs425.corebankapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	@Query(value = "SELECT * from schedules where loan_application_id = :loanId AND actual_payment_date IS NULL ORDER BY schedule_id LIMIT 1", nativeQuery = true)
	public Schedule getLoanSchedule(@Param("loanId") long loanId);
	@Modifying
	@Transactional
	@Query(value = "UPDATE schedules set actual_payment_date = NOW() WHERE schedule_id = :scheduleId", nativeQuery = true)
	public void updateActualPaymentDate(@Param("scheduleId") long id);
	@Query(value = "SELECT * from schedules where loan_application_id = :loanId", nativeQuery = true)
	public List<Schedule> getSchedulesByLoanId(@Param("loanId") long id);
}
