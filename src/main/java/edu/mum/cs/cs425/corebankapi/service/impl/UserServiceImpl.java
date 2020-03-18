package edu.mum.cs.cs425.corebankapi.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.User;
import edu.mum.cs.cs425.corebankapi.repository.UserRepository;
import edu.mum.cs.cs425.corebankapi.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private  UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		if (user != null) {
			userRepository.save(user);
			
		}
		
	
	}

	@Override
	public Iterable<?> getUsers() {
		
		Iterable<?> getallUsers = userRepository.findAll();
		
		if (getallUsers == null) {
			return null;
		}
		
		return getallUsers;
		
	}

	@Override
	public User getUser(Long id) {
		
		
		User user = userRepository.findById(id).get();
		Boolean isPresent = userRepository.findById(id).isPresent();
		
		if (isPresent) {
			return user;
			
		}else
		
			return null;
		
		
	}

	@Override
	public User LockUser(Long id) {
		
		User user = userRepository.findById(id).get();
		Boolean isPresent = userRepository.findById(id).isPresent();
		
		if (isPresent) {
			return user;
			
		}else
		
			return null;
		
	}

	@Override
	public User editUser(Long id) {
		
		User user = userRepository.findById(id).get();
		Boolean isPresent = userRepository.findById(id).isPresent();
		
		if (isPresent) {
			return user;
			
		}else
		
			return null;
		
	}


}
