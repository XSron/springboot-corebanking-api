package edu.mum.cs.cs425.corebankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;
import edu.mum.cs.cs425.corebankapi.repository.AccountRepository;
import edu.mum.cs.cs425.corebankapi.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public void saveAccount(Account account) {
		if(account != null) {
			String accountNumber = accountRepository.generateAccountNumber();
			account.setActive(true);
			account.setAccountNumber(accountNumber);
			accountRepository.save(account);
		}
	}
	@Override
	public Iterable<Account> getAccount() {
		return accountRepository.findAll();
	}
	@Override
	public Account getAccountByNumber(String accountNumber) {
		return accountRepository.getAccountByNumber(accountNumber);
	}
}
