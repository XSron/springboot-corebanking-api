package edu.mum.cs.cs425.corebankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.UtilitySetting;
import edu.mum.cs.cs425.corebankapi.repository.UtilitySettingRepository;
import edu.mum.cs.cs425.corebankapi.service.IUtilitySettingService;

@Service
public class UtilityServiceImpl implements IUtilitySettingService{
	
	@Autowired
	private UtilitySettingRepository utilitySettingRepository;

	@Override
	public void saveUtilitySetting(UtilitySetting utilitySetting) {
		if(utilitySetting != null) {
			
			utilitySettingRepository.save(utilitySetting);
		}
		
		
	}

	@Override
	public UtilitySetting getUtilitySetting(Long id) {
		
		UtilitySetting utilitySetting = utilitySettingRepository.findById(id).get();
		Boolean isPresent = utilitySettingRepository.findById(id).isPresent();
		
		if(isPresent) {
			return utilitySetting;
			
		}else
			return null;
		
		
	}

	@Override
	public Iterable<?> getAllUtilitySettings() {
		
		Iterable<?> getallUtility = utilitySettingRepository.findAll();
		
		if(getallUtility != null) {
			
			return getallUtility;
			
		}else
		
		return null;
	}

	@Override
	public UtilitySetting editUtilitySetting(Long id) {
		
	
		UtilitySetting utilitySetting = utilitySettingRepository.findById(id).get();
		Boolean isPresent = utilitySettingRepository.findById(id).isPresent();
		
		if(isPresent) {
			return utilitySetting;
			
		}else
			return null;
	}

	@Override
	public void deleteUtilitySetting(Long id) {
		
		UtilitySetting utilitySetting = utilitySettingRepository.findById(id).get();
		
		utilitySettingRepository.delete(utilitySetting);
		
	}

}
