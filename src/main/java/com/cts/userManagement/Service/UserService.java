package com.cts.userManagement.Service;

import java.util.List;

import com.cts.userManagement.Model.ForgotPassword;
import com.cts.userManagement.Model.User;

public interface UserService {
	public User addUser(User user);// user registration
	
	public boolean loginUser(String username, String password ,String userRole);// login
	
	public List<User> getAllUsers();// will be visible only if you are logged in

	public User getUserById(int uid); //get only a single user

	public boolean updatePassword(ForgotPassword forgotPassword);


	public User findByUserName(String name);
}
