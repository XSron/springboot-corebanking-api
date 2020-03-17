package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.UtilitySetting;
import edu.mum.cs.cs425.corebankapi.model.status.Response;

public interface IUtilitySettingService {
	
	Response saveUtilitySetting(UtilitySetting utilitySetting);
	Response getUtilitySetting(Long id);
	Response getAllUtilitySettings(Long id);
	Response editUtilitySetting (Long id);
	Response deleteUtilitySetting(Long id);
	

}
