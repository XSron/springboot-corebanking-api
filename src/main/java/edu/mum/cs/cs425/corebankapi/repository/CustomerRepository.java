package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query(value = "SELECT * FROM customers WHERE customer_number = :customerNumber", nativeQuery = true)
	public Customer getCustomerByNumber(@Param("customerNumber") String customerNumber);
	@Query(value = "SELECT CONCAT('CUS-', IFNULL(MAX(RIGHT(customer_number, LENGTH(customer_number) - 4)), 0) + 1) FROM customers", nativeQuery = true)
	public String generateCustomerNumber();
}
