package edu.mum.cs.cs425.corebankapi.service;



import edu.mum.cs.cs425.corebankapi.model.setting.Rate;


public interface IRateService {
	
	void saveRate(Rate rate);
	Rate getRate(Long id);
	Iterable<?> getRates();
	Rate editRate(Long id);
	void deleteRate(Long id);
	
	

}
