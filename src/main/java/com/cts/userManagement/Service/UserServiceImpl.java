package com.cts.userManagement.Service;

import java.util.List;
import java.util.Locale;

import com.cts.userManagement.Model.ForgotPassword;
import com.cts.userManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.userManagement.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user){
		List<User> listUsers = getAllUsers();
		Boolean flag =listUsers.stream().anyMatch(e->e.getUsername().equals(user.getUsername()));

		if(flag!=true){
			return (user!=null)?userRepo.saveAndFlush(user):null;
		}else{return null;}
	}

	@Override
	public boolean loginUser(String username, String password,String role){
		User user1=new User();
		if(role!=null||role.toLowerCase()=="user"||role.toLowerCase()=="admin"){
			user1 = userRepo.validateUser(username, password);
			System.out.println("User logged: "+ user1.getUsername());
		}
		return(user1!=null)?true:false;
	}

	@Override
	public List<User> getAllUsers(){return userRepo.findAll()!=null?userRepo.findAll():null;}

	@Override
	public User getUserById(int uid) {
		return ((userRepo.getById(uid))!=null)?userRepo.getById(uid):null;
	}

	@Override
	public boolean updatePassword(ForgotPassword forgotPassword) {
		User userFound = userRepo.findByUsername(forgotPassword.getUsername());
		System.out.println(userFound);
		if(userFound!=null &&
				userFound.getSecurityQuestion().equals(forgotPassword.getSecurityQuestion())
		&& forgotPassword.getConfirmPassword().equals(forgotPassword.getPassword())){

			userFound.setPassword(forgotPassword.getPassword());
			userRepo.saveAndFlush(userFound);
			System.out.println(userFound.getPassword());
			return true;
		}else {
			return false;
		}
	}

	public User findByUserName(String username){
		User userFound = userRepo.findByUsername(username);
		return(userFound!=null)?userFound:null;
	}


}














