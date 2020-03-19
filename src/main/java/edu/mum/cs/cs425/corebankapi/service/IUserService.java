package edu.mum.cs.cs425.corebankapi.service;




import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.corebankapi.model.setting.User;

@Service
public interface IUserService {
	void saveUser(User user);
	Iterable <?> getUsers();
	User getUser(Long id);
	User LockUser(Long id);
	User editUser(Long id);
	public int login(String username, String password);
}
