package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
