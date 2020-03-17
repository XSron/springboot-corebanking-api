package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(value = "SELECT * FROM accounts WHERE account_number = :accountNumber", nativeQuery = true)
	public Account getAccountByNumber(@Param("accountNumber") String accountNumber);
	@Query(value = "SELECT CONCAT('ACC-', IFNULL(MAX(RIGHT(account_number, LENGTH(account_number) - 4)), 0) + 1) FROM accounts", nativeQuery = true)
	public String generateAccountNumber();
}
