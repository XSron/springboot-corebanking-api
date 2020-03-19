package edu.mum.cs.cs425.corebankapi.service;




import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.UtilitySetting;

@Service
public interface IUtilitySettingService {
	
	void saveUtilitySetting(UtilitySetting utilitySetting);
	UtilitySetting getUtilitySetting(Long id);
	Iterable<?> getAllUtilitySettings();
	UtilitySetting editUtilitySetting (Long id);
	void deleteUtilitySetting(Long id);
	

}
