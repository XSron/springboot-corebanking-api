package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query(value = "SELECT * FROM Customer WHERE CustomerNumber = :customerNumber", nativeQuery = true)
	public Customer getCustomerByNumber(@Param("customerNumber") String customerNumber);
	@Query(value = "SELECT * FROM customer")
	public String generateCustomerNumber();
}
