package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.UtilitySetting;

public interface IUtilitySettingService {
	
	void saveUtilitySetting(UtilitySetting utilitySetting);
	UtilitySetting getUtilitySetting(Long id);
	List<UtilitySetting> getAllUtilitySettings(Long id);
	void editUtilitySetting (Long id);
	void deleteUtilitySetting(Long id);
	

}
