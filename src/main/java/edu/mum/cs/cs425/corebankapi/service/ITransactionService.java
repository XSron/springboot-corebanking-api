package edu.mum.cs.cs425.corebankapi.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;
import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;

@Service
public interface ITransactionService {
	public void deposit(Account accountId, double amount, String description);
	public void withdraw(Account accountId, double amount, String description);
	public void transfer(Account fromAccountId, Account toAccountId, double amount, String description);
	public void paymentUtility(Account fromAccountId, Account toAccountId, double amount, String description);
	public void payLoan(String loanApplicationNumber);
	public Iterable<Transaction> getAllTransaction();
	public Iterable<Transaction> getTransactionByAccountId(long id);
}
