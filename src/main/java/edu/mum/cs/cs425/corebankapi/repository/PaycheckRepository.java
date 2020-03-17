package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;

public interface PaycheckRepository extends JpaRepository<Paycheck, Long>{

}
