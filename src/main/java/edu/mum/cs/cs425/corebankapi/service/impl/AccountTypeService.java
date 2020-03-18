package edu.mum.cs.cs425.corebankapi.service.impl;

import edu.mum.cs.cs425.corebankapi.model.account.AccountType;
import edu.mum.cs.cs425.corebankapi.model.customer.CustomerType;
import edu.mum.cs.cs425.corebankapi.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public Iterable<AccountType> getAccountType() {
        return accountTypeRepository.findAll();
    }
}
