package edu.mum.cs.cs425.corebankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.Rate;
import edu.mum.cs.cs425.corebankapi.repository.RateRepository;
import edu.mum.cs.cs425.corebankapi.service.IRateService;

@Service
public class RateServiceImpl implements IRateService{
	
	@Autowired
	private RateRepository rateRepository;

	@Override
	public void saveRate(Rate rate) {
		
		if (rate != null) {
			rateRepository.save(rate);
		}
		
	}

	@Override
	public Rate getRate(Long id) {
		Rate rate = rateRepository.findById(id).get();
		Boolean isPresent = rateRepository.findById(id).isPresent();
		
		if(isPresent) {
			return rate;
		}else
		
		return null;
	}

	@Override
	public Iterable<?> getRates() {
		Iterable<?> getRates = rateRepository.findAll();
		if(getRates != null) {
			return getRates;
			
		}else
		
		return null;
	}

	@Override
	public Rate editRate(Long id) {
		Rate rate = rateRepository.findById(id).get();
		Boolean isPresent = rateRepository.findById(id).isPresent();
		
		if(isPresent) {
			return rate;
		}else
		
		return null;
		
		
	}

	@Override
	public void deleteRate(Long id) {
		
		Rate rate = rateRepository.findById(id).get();
		rateRepository.delete(rate);
		
	}

}
