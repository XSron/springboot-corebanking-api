package edu.mum.cs.cs425.corebankapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.account.Account;
import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;
import edu.mum.cs.cs425.corebankapi.model.paycheck.PaycheckDetail;
import edu.mum.cs.cs425.corebankapi.repository.AccountRepository;
import edu.mum.cs.cs425.corebankapi.repository.PaycheckRepository;
import edu.mum.cs.cs425.corebankapi.service.IPaycheckService;

@Service
public class PaycheckService implements IPaycheckService {
	@Autowired
	private PaycheckRepository paycheckRepository;
	@Autowired 
	private AccountRepository accountRepository;
	@Override
	public void savePaycheck(Paycheck paycheck) {
		if(paycheck != null) {
			double totalAmount = 0;
			paycheck.setPaymentDate(LocalDate.now());
			List<PaycheckDetail> listofPaycheckDetail = paycheck.getPaycheckdetail();
			
			for(PaycheckDetail paycheckDetail: listofPaycheckDetail) {
				paycheckDetail.setPaycheck(paycheck);
				paycheckDetail.setSeen(false);
				
				//Add to receiver account
				Account receiverAccount = paycheckDetail.getAccount();
				double receiverBalance =  accountRepository.findById(receiverAccount.getAccountId()).get().getBalance() + paycheckDetail.getAmount();
				accountRepository.updateBalance(receiverAccount.getAccountId(), receiverBalance);
				totalAmount += paycheckDetail.getAmount();	
			}
			//Deduct from sender account
			Account account = paycheck.getAccount();
			double senderBalance = accountRepository.findById(account.getAccountId()).get().getBalance();
			accountRepository.updateBalance(account.getAccountId(), senderBalance - totalAmount);
			paycheckRepository.save(paycheck);	
		}
	}
	@Override
	public Iterable<Paycheck> getPaycheck() {
		return paycheckRepository.findAll();
	}
}
