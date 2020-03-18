package edu.mum.cs.cs425.corebankapi.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.paycheck.Paycheck;
import edu.mum.cs.cs425.corebankapi.model.paycheck.PaycheckDetail;
import edu.mum.cs.cs425.corebankapi.repository.PaycheckRepository;
import edu.mum.cs.cs425.corebankapi.service.IPaycheckService;

@Service
public class PaycheckService implements IPaycheckService {
	@Autowired
	private PaycheckRepository paycheckRepository;
	@Override
	public void savePaycheck(Paycheck paycheck) {
		if(paycheck != null) {
			paycheck.setPaymentDate(LocalDate.now());
			List<PaycheckDetail> listofPaycheckDetail = paycheck.getPaycheckdetail();
			for(PaycheckDetail paycheckDetail: listofPaycheckDetail)
				paycheckDetail.setPaycheck(paycheck);
			paycheckRepository.save(paycheck);	
		}
	}
	@Override
	public Iterable<Paycheck> getPaycheck() {
		return paycheckRepository.findAll();
	}
}
