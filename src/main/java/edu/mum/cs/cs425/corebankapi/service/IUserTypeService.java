package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.UserType;

public interface IUserTypeService {
	
	void saveUserType(UserType userType);
	UserType getUserType (Long id);
	List<UserType> getUserTypes();
	void editUsertype(Long id);
	
	
	
	
}
