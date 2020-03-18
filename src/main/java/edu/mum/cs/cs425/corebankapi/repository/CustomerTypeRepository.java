package edu.mum.cs.cs425.corebankapi.repository;

import edu.mum.cs.cs425.corebankapi.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
