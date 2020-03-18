package edu.mum.cs.cs425.corebankapi.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;
import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;
import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;
import edu.mum.cs.cs425.corebankapi.model.transaction.TransactionType;
import edu.mum.cs.cs425.corebankapi.repository.AccountRepository;
import edu.mum.cs.cs425.corebankapi.repository.LoanRepository;
import edu.mum.cs.cs425.corebankapi.repository.ScheduleRepository;
import edu.mum.cs.cs425.corebankapi.repository.TransactionRepository;
import edu.mum.cs.cs425.corebankapi.service.ITransactionService;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ScheduleRepository scheduleRepository;
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
	public void payLoan(String loanApplicationNumber) throws Exception {
		LoanApplication loanApplication = loanRepository.getLoanByNumber(loanApplicationNumber);
		//check 
		if(loanApplication == null)
			throw new Exception("Loan Application Not Found!");
		long customerId = loanApplication.getCustomer().getCustomerId();
		Account checkingAccount = accountRepository.getCheckingAccount(customerId);
		if(checkingAccount == null)
			throw new Exception("No Checking Account Found!");
		
		//check if loan is active
		if(!loanApplication.isActive())
			throw new Exception("This loan application #"+ loanApplicationNumber +" is not active!");
		
		Schedule schedule = scheduleRepository.getLoanSchedule(loanApplication.getId());
		if(schedule == null)
			throw new Exception("No Schedule Found!");
		double paymentAmount = schedule.getPrincipal() + schedule.getInterest();
		
		//check if balance is sufficient
		if(checkingAccount.getBalance() < paymentAmount)
			throw new Exception("Balance is not sufficient ("+ checkingAccount.getBalance() +")");
		
		//insert transaction
		Transaction transaction = new Transaction(new TransactionType(5), 
				checkingAccount, null, null, paymentAmount, LocalDate.now(), "MAKE A LOAN PAYMENT");
		transactionRepository.save(transaction);
		
		//update actual date
		scheduleRepository.updateActualPaymentDate(schedule.getScheduleId());
		
		//update loan status if finish
		schedule = scheduleRepository.getLoanSchedule(loanApplication.getId());
		if(schedule == null)
			loanRepository.updateLoanStatus(loanApplication.getId());
			
		//update balance
		accountRepository.updateBalance(checkingAccount.getAccountId(), checkingAccount.getBalance() - paymentAmount);
	}
	@Override
	public Iterable<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}
	@Override
	public Iterable<Transaction> getTransactionByAccountId(long id) {
		return transactionRepository.getTransactionByAccountId(id);
	}
}
