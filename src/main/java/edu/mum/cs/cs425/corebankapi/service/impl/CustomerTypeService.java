package edu.mum.cs.cs425.corebankapi.service.impl;

import edu.mum.cs.cs425.corebankapi.model.customer.CustomerType;
import edu.mum.cs.cs425.corebankapi.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    public Iterable<CustomerType> getCustomerType() {
        return customerTypeRepository.findAll();
    }
}
