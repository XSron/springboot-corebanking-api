package edu.mum.cs.cs425.corebankapi.service;




import edu.mum.cs.cs425.corebankapi.model.setting.UserType;


public interface IUserTypeService {
	
	void saveUserType(UserType userType);
	UserType getUserType (Long id);
	Iterable<?> getUserTypes();
	UserType editUsertype(Long id);
	
	
	
	
}
