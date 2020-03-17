package edu.mum.cs.cs425.corebankapi.service;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;

@Service
public interface IPaycheckService {
	public void savePaycheck(Paycheck paycheck);
	public Iterable<Paycheck> getPaycheck();
}
