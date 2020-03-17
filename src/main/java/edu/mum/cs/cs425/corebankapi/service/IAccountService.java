package edu.mum.cs.cs425.corebankapi.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

@Service
public interface IAccountService {
	public void saveAccount(Account account);
	public Iterable<Account> getAccount();
	public Account getAccountByNumber(String accountNumber);
}
