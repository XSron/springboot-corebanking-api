package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.loan.LoanApplication;
import edu.mum.cs.cs425.corebankapi.model.loan.Schedule;
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
	
	@GetMapping(value = "getaccountbynumber/{loanNumber}")
	public Response getAccountByNumber(@PathVariable("loanNumber") String loanNumber) {
		try {
			LoanApplication account = loanService.getLoanApplicationByNumber(loanNumber);
			return new Response(200, "succeed", Arrays.asList(account));
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	@GetMapping(value = "getschedulesbyloanid/{loanId}")
	public Response getSchedulesByLoanId(@PathVariable("loanId") long loanId) {
		try {
			List<Schedule> schedules = loanService.getSchedulesByLoanId(loanId);
			return new Response(200, "succeed", schedules);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
	
	@GetMapping(value = "getloanapplicationbycustomerid/{loanId}")
	public Response getLoanApplicationsByCustomerId(@PathVariable("customerId") long customerId) {
		try {
			List<LoanApplication> loanApplication = loanService.getLoanApplicationsByCustomerId(customerId);
			return new Response(200, "succeed", loanApplication);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
}
