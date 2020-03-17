package edu.mum.cs.cs425.corebankapi.service;




import edu.mum.cs.cs425.corebankapi.model.setting.User;


public interface IUserService {
	
	void saveUser(User user);
	Iterable <?> getUsers();
	User getUser(Long id);
	User LockUser(Long id);
	User editUser(Long id);
	
	

}
