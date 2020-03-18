package edu.mum.cs.cs425.corebankapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(value = "SELECT * FROM accounts a WHERE a.account_number = ?1", nativeQuery = true)
	public Account getAccountByNumber(String accountNumber);
	@Query(value = "SELECT CONCAT('ACC-', IFNULL(MAX(RIGHT(account_number, LENGTH(account_number) - 4)), 0) + 1) FROM accounts", nativeQuery = true)
	public String generateAccountNumber();
	@Modifying
	@Transactional
	@Query(value = "UPDATE accounts set balance = :balance where account_id = :accountId", nativeQuery = true)
	public void updateBalance(@Param("accountId") long id, @Param("balance") double balance);
	@Query(value = "select acc.* from accounts acc inner join customers c ON acc.customer_id = c.customer_id where c.customer_number = :customerNumber", nativeQuery = true)
	public List<Account> getAccountByCustomerNumber(@Param("customerNumber") String customerNumber); 
	@Query(value = "SELECT * from accounts where account_type_id = 1 AND customer_id = :customerId", nativeQuery = true)
	public Account getCheckingAccount(@Param("customerId") long id);
}
