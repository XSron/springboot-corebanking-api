package edu.mum.cs.cs425.corebankapi.service;

import java.util.List;

import edu.mum.cs.cs425.corebankapi.model.setting.User;

public interface IUserService {
	
	void saveUser(User user);
	List<User> getUsers();
	User getUser(Long id);
	void LockUser(Long id);
	void editUser(Long id);
	
	

}
