package edu.mum.cs.cs425.corebankapi.service;

import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;

public interface IPaycheckService {
	public void savePaycheck(Paycheck paycheck);
	public Iterable<Paycheck> getPaycheck();
}
