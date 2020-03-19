package edu.mum.cs.cs425.corebankapi.service;




import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.UserType;

@Service
public interface IUserTypeService {
	
	void saveUserType(UserType userType);
	UserType getUserType (Long id);
	Iterable<?> getUserTypes();
	UserType editUsertype(Long id);
	
	
	
	
}
