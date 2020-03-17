package edu.mum.cs.cs425.corebankapi.service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;

public interface IAccountService {
	public void saveAccount(Account account);
	public Iterable<Account> getAccount();
}
