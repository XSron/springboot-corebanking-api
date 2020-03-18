package edu.mum.cs.cs425.corebankapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query(value = "SELECT * FROM transactions where account_id = :accountId UNION ALL SELECT * FROM transactions where from_account_id = :accountId", nativeQuery = true)
	List<Transaction> getTransactionByAccountId(@Param("accountId") long id);
}
