package edu.mum.cs.cs425.corebankapi.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;
import edu.mum.cs.cs425.corebankapi.repository.CustomerRepository;
import edu.mum.cs.cs425.corebankapi.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void saveCustomer(Customer customer) {
		if(customer != null) {
			String customerNumber = customerRepository.generateCustomerNumber();
			customer.setCustomerNumber(customerNumber);
			customerRepository.save(customer);	
		}
	}
	@Override
	public Iterable<Customer> getCustomer() {
		return customerRepository.findAll();
	}
	@Override
	public Customer getCustomerByNumber(String customerNumber) {
		return customerRepository.getCustomerByNumber(customerNumber);
	}
}
