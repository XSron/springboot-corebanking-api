package edu.mum.cs.cs425.corebankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@PostMapping(value = "createcustomer", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public Response createCustomer(@RequestBody Customer customer) {
		try {
			customerService.saveCustomer(customer);
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
		return new Response(200, "succeed", null);
	}
	@GetMapping(value = "getallcustomers")
	public Response getAllCustomers() {
		try {
			return new Response(200, "succeed", customerService.getCustomer());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getcustomerbynumber")
	public Response getCustomerByNumber(@RequestParam("customerNumber") String customerNumber) {
		try {
			return new Response(200, "succeed", customerService.getCustomer());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
}
