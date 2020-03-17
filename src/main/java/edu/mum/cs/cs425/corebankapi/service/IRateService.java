package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.Rate;

public interface IRateService {
	
	void saveRate(Rate rate);
	Rate getRate(Long id);
	List<Rate> getRates();
	 void editRate(Long id);
	 void deleteRate(Long id);
	
	

}
