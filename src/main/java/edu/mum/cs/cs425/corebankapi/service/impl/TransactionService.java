package edu.mum.cs.cs425.corebankapi.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;
import edu.mum.cs.cs425.corebankapi.model.transaction.TransactionType;
import edu.mum.cs.cs425.corebankapi.repository.AccountRepository;
import edu.mum.cs.cs425.corebankapi.repository.TransactionRepository;
import edu.mum.cs.cs425.corebankapi.service.ITransactionService;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public void deposit(Transaction transaction) {
		if(transaction != null) {
			long accountId = transaction.getAccount().getAccountId();
			double currentBalance = accountRepository.findById(accountId).get().getBalance();
			accountRepository.updateBalance(accountId, currentBalance + transaction.getAmount());
			transaction.setTransactionType(new TransactionType(1));
			transaction.setTransactionDate(LocalDate.now());
			transactionRepository.save(transaction);
		}
	}
	@Override
	public void withdraw(Transaction transaction) throws Exception {
		if(transaction != null) {
			long accountId = transaction.getAccount().getAccountId();
			double currentBalance = accountRepository.findById(accountId).get().getBalance();
			if(transaction.getAmount() > currentBalance)  
				throw new Exception("You have only " + currentBalance);
			accountRepository.updateBalance(accountId, currentBalance - transaction.getAmount());
			transaction.setTransactionType(new TransactionType(2));
			transaction.setTransactionDate(LocalDate.now());
			transactionRepository.save(transaction);
		}
	}
	@Override
	public void transfer(Transaction transaction) throws Exception {
		if(transaction != null) {
			long fromAccountId = transaction.getFromAccount().getAccountId();
			double fromAccountBalance = accountRepository.findById(fromAccountId).get().getBalance();
			long toAccountId = transaction.getToAccount().getAccountId();
			double toAccountBalance = accountRepository.findById(toAccountId).get().getBalance();
			//check sender amount
			if(transaction.getAmount() > fromAccountBalance)  
				throw new Exception("You have only " + fromAccountBalance);
			accountRepository.updateBalance(fromAccountId, fromAccountBalance - transaction.getAmount());
			accountRepository.updateBalance(toAccountId, toAccountBalance + transaction.getAmount());
			transaction.setTransactionType(new TransactionType(3));
			transaction.setTransactionDate(LocalDate.now());
			transactionRepository.save(transaction);
		}
	}
	@Override
	public void paymentUtility(Transaction transaction) throws Exception {
		if(transaction != null) {
			long fromAccountId = transaction.getFromAccount().getAccountId();
			double fromAccountBalance = accountRepository.findById(fromAccountId).get().getBalance();
			long toAccountId = transaction.getToAccount().getAccountId();
			double toAccountBalance = accountRepository.findById(toAccountId).get().getBalance();
			//check sender amount
			if(transaction.getAmount() > fromAccountBalance)  
				throw new Exception("You have only " + fromAccountBalance);
			accountRepository.updateBalance(fromAccountId, fromAccountBalance - transaction.getAmount());
			accountRepository.updateBalance(toAccountId, toAccountBalance + transaction.getAmount());
			transaction.setTransactionType(new TransactionType(4));
			transaction.setTransactionDate(LocalDate.now());
			//must pass utility name to description field from the UI
			transaction.setDescription("UTILITY PAYMENT TO " + transaction.getDescription());
			transactionRepository.save(transaction);
		}
	}
	@Override
	public void payLoan(String loanApplicationNumber) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Iterable<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}
	@Override
	public Iterable<Transaction> getTransactionByAccountId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
