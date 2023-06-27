package com.cts.userManagement.Controller;

import java.util.List;

import com.cts.userManagement.Model.ForgotPassword;
import com.cts.userManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.userManagement.Service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController{
	@Autowired
	private UserService userService;;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers(){
		return (userService.getAllUsers()!=null)? new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK):
				new ResponseEntity<String>("userlist is empty", HttpStatus.NO_CONTENT);
	}


	

}
