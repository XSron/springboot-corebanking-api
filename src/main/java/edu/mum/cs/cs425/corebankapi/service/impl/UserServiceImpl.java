package edu.mum.cs.cs425.corebankapi.service.impl;

import java.util.List;

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
		userRepository.save(user);	
		System.out.println("save successful");
	}

	@Override
	public List<User> getUsers() {
		List<User> allUsers = userRepository.findAll();
		if(allUsers == null) {
			return null;
		}
		
		return allUsers ;
	}

	@Override
	public User getUser(Long id) {
		
		boolean userPresent = userRepository.findById(id).isPresent();
		
		if (userPresent) {
			
			return userRepository.findById(id).get();
			
		}else
		
		return null;
	}

	@Override
	public void LockUser(Long id) {
		
		
		
	}

	@Override
	public void editUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
