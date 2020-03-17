package edu.mum.cs.cs425.corebankapi.service;

import edu.mum.cs.cs425.corebankapi.model.customer.Customer;

public interface ICustomerService {
	public void saveCustomer(Customer customer);
	public Iterable<Customer> getCustomer();
}
