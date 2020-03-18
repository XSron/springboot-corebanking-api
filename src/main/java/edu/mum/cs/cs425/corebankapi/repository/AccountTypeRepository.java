package edu.mum.cs.cs425.corebankapi.repository;

import edu.mum.cs.cs425.corebankapi.model.account.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
