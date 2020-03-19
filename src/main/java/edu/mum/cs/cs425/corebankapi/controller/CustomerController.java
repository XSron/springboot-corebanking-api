package edu.mum.cs.cs425.corebankapi.controller;

import java.util.Arrays;

import edu.mum.cs.cs425.corebankapi.service.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;
import edu.mum.cs.cs425.corebankapi.model.status.Response;
import edu.mum.cs.cs425.corebankapi.service.ICustomerService;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private CustomerTypeService customerTypeService;
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
	@GetMapping(value = "getcustomerbynumber/{customerNumber}")
	public Response getCustomerByNumber(@PathVariable("customerNumber") String customerNumber) {
		try {
			Customer customer = customerService.getCustomerByNumber(customerNumber);
			return new Response(200, "succeed", Arrays.asList(customer));
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getcustomertype")
	public Response getCustomerType() {
		try {
			return new Response(200, "succeed", customerTypeService.getCustomerType());
		}catch(Exception ex) {
			return new Response(400, ex.getMessage(), null);
		}
	}
	@GetMapping(value = "getcustomerbyaccountid/{accountId}")
	public Response getCustomerByAccountId(@PathVariable("accountId") long id) {
		try {
			Customer customer = customerService.getCustomerByAccountId(id);
			return new Response(200, "succeed", Arrays.asList(customer));
		}catch(Exception ex) {
			ex.printStackTrace();
			return new Response(400, ex.getMessage(), null);
		}
	}
}
