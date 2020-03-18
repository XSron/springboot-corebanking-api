package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import edu.mum.cs.cs425.corebankapi.service.impl.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.cs425.corebankapi.model.account.Account;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.IAccountService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	@Autowired
	private AccountTypeService accountTypeService;
	@PostMapping(value = "createaccount", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response createAccount(@RequestBody Account account) {
		try {
			accountService.saveAccount(account);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@GetMapping(value = "getallaccounts")
	public Response getAllAccounts() {
		try {
			return new Response(200, "succeed", accountService.getAccount());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getaccountbynumber")
	public Response getAccountByNumber(@PathVariable("accountNumber") String accountNumber) {
		try {
			Account account = accountService.getAccountByNumber(accountNumber);
			return new Response(200, "succeed", Arrays.asList(account));
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getaccounttype")
	public Response getCustomerType() {
		try {
			System.out.println(accountTypeService.getAccountType());
			return new Response(200, "succeed", accountTypeService.getAccountType());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getaccountbycustomernumber")
	public Response getAccountByCustomerNumber(@PathVariable("customerNumber") String customerNumber) {
		try {
			return new Response(200, "succeed", accountService.getAccountByCustomerNumber(customerNumber));
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
}
