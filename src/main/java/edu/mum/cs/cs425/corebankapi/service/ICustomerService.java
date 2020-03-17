package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

@Service
public interface ICustomerService {
	public void saveCustomer(Customer customer);
	public Iterable<Customer> getCustomer();
	public List<Customer> getCustomerByNumber(String customerNumber);
}
