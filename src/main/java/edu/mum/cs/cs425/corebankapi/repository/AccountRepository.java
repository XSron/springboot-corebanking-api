package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
