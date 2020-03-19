package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query(value = "SELECT * FROM customers WHERE customer_number = :customernumber", nativeQuery = true)
	public Customer getCustomerByNumber(@Param("customernumber") String customerNumber);
	@Query(value = "SELECT CONCAT('CUS-', IFNULL(MAX(RIGHT(customer_number, LENGTH(customer_number) - 4)), 0) + 1) FROM customers", nativeQuery = true)
	public String generateCustomerNumber();
	@Query(value = "select c.* from customers c inner join accounts acc on c.customer_id = acc.customer_id where acc.account_id = :accountId", nativeQuery = true)
	public Customer getCustomerByAccountId(@Param("accountId") long id);
}
