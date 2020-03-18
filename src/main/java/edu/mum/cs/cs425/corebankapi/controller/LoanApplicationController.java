package edu.mum.cs.cs425.corebankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.ILoanService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*")
public class LoanApplicationController {
	@Autowired
	private ILoanService loanService;
	@PostMapping(value = "createloanapp", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response createLoanApplication(@RequestBody LoanApplication loanApplication) {
		try {
			loanService.saveLoanApplication(loanApplication);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@GetMapping(value = "getallloanapplications")
	public Response getAllLoanApplication() {
		try {
			return new Response(200, "succeed", loanService.getLoanApplication());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	/*@GetMapping(value = "getaccountbynumber")
	public Response getAccountByNumber(@RequestParam("loanNumber") String loanNumber) {
		try {
			LoanApplication account = loanService.get
			return new Response(200, "succeed", Arrays.asList(account));
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}*/
}
