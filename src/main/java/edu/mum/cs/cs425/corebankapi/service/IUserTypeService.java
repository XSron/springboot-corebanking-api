package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.UserType;
import edu.mum.cs.cs425.corebankapi.model.status.Response;

public interface IUserTypeService {
	
	Response saveUserType(UserType userType);
	Response getUserType (Long id);
	Response getUserTypes();
	Response editUsertype(Long id);
	
	
	
	
}
