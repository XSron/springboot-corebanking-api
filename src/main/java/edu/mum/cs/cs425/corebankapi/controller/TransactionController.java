package edu.mum.cs.cs425.corebankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.model.transaction.Transaction;
import edu.mum.cs.cs425.corebankapi.service.ITransactionService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	@PostMapping(value = "deposit", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response deposit(@RequestBody Transaction transaction) {
		try {
			transactionService.deposit(transaction);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@PostMapping(value = "withdraw", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response withdraw(@RequestBody Transaction transaction) {
		try {
			transactionService.withdraw(transaction);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@PostMapping(value = "transfer", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response transfer(@RequestBody Transaction transaction) {
		try {
			transactionService.transfer(transaction);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@PostMapping(value = "paymentutility", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response paymentUtility(@RequestBody Transaction transaction) {
		try {
			transactionService.paymentUtility(transaction);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	
	@PostMapping(value = "loanpayment/{loanApplicationNumber}")
	public Response payLoan(@PathVariable("loanApplicationNumber") String loanApplicationNumber) {
		try {
			transactionService.payLoan(loanApplicationNumber);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	
	@GetMapping(value = "getalltransactions")
	public Response getAllTransactions() {
		try {
			return new Response(200, "succeed", transactionService.getAllTransaction());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
}
