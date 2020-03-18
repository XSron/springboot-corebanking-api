package edu.mum.cs.cs425.corebankapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.mum.cs.cs425.corebankapi.model.setting.UserType;
import edu.mum.cs.cs425.corebankapi.repository.UserTypeRepository;
import edu.mum.cs.cs425.corebankapi.service.IUserTypeService;

@Service
public class UserTypeServiceImpl implements IUserTypeService{
	
	@Autowired
	private UserTypeRepository userTypeRepository;

	@Override
	public void saveUserType(UserType userType) {
		
		if (userType != null) {
			userTypeRepository.save(userType);
		}
		
		
	}

	@Override
	public UserType getUserType(Long id) {
	
		Boolean isPresent = userTypeRepository.findById(id).isPresent();
		UserType userType = userTypeRepository.findById(id).get();
		
		if (isPresent) {
			return userType;
		}
		else
			
		return null;
	}

	@Override
	public Iterable<?> getUserTypes() {
		
		Iterable<?> allUserTypes = userTypeRepository.findAll();
		
		if(allUserTypes != null) {
			return allUserTypes;
			
		}else
		
		return null ;
	}
	


	@Override
	public UserType editUsertype(Long id) {
		
		UserType userType = userTypeRepository.findById(id).get();
		Boolean isPresent = userTypeRepository.findById(id).isPresent();
		
		if (isPresent) {
			return userType;
		}else
		return null;
	}
	
	
	

}
