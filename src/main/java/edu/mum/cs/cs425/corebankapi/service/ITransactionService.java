package edu.mum.cs.cs425.corebankapi.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;

@Service
public interface ITransactionService {
	public void deposit(Transaction transaction);
	public void withdraw(Transaction transaction) throws Exception;
	public void transfer(Transaction transaction) throws Exception;
	public void paymentUtility(Transaction transaction) throws Exception;
	public void payLoan(String loanApplicationNumber);
	public Iterable<Transaction> getAllTransaction();
	public Iterable<Transaction> getTransactionByAccountId(long id);
}
