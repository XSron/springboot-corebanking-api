package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.Rate;
import edu.mum.cs.cs425.corebankapi.model.status.Response;

public interface IRateService {
	
	void saveRate(Rate rate);
	Rate getRate(Long id);
	Iterable<?> getRates();
	void editRate(Long id);
	void deleteRate(Long id);
	
	

}
