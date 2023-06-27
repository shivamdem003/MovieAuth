package com.cts.userManagement.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;

import com.cts.userManagement.Model.ErrorResponse;
import com.cts.userManagement.Model.ForgotPassword;
import com.cts.userManagement.Model.JwtResponse;
import com.cts.userManagement.Model.User;
import com.cts.userManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/v1.0/moviebooking")
@CrossOrigin(origins = "*")
public class AuthenticationController 
{
	private Map<String, String> mapObj = new HashMap<String, String>();
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		if(userService.addUser(user)!=null) {
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("user registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}


	//method to generate token inside login API
	public String generateToken(String username, String password,String role) throws ServletException, Exception {
		String jwtToken;
		if(username ==null || password ==null) {
			throw new ServletException("Please enter valid credentials");
		}
		boolean flag = userService.loginUser(username, password,role);
		if(!flag) {
			throw new ServletException("Invalid credentials");
		}else{
			jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis()+3000000))
						.signWith(SignatureAlgorithm.HS256, "secret key").compact();
		}
		return jwtToken;
		
	}

	@PostMapping("/login")
	public ResponseEntity<?> logiUser(@RequestBody User user) {
		JwtResponse jwtResponse = new JwtResponse();
		try {
			if(user.getUserRole().toString().toLowerCase().equals("user")){
				String jwtToken = generateToken(user.getUsername(), user.getPassword(), user.getUserRole());
				if(user.getUserRole().equals(userService.findByUserName(user.getUsername()).getUserRole())){
					mapObj.put("Message", "User successfully logged in");
					mapObj.put("Token", jwtToken);
					jwtResponse.setUsername(user.getUsername());jwtResponse.setUserRole(user.getUserRole());jwtResponse.setMapObj(mapObj);
				}
			} else if(user.getUserRole().toString().toLowerCase().equals("admin")) {
				String jwtToken = generateToken(user.getUsername(), user.getPassword(), user.getUserRole());
				if(user.getUserRole().equals(userService.findByUserName(user.getUsername()).getUserRole())){
					mapObj.put("Message", "Admins successfully has logged in");
					mapObj.put("Token", jwtToken);
					jwtResponse.setUsername(user.getUsername());jwtResponse.setUserRole(user.getUserRole());jwtResponse.setMapObj(mapObj);
				}
			}else{
				mapObj.put("Message", "User not logged in");
				mapObj.put("Token", null);
				return new ResponseEntity<JwtResponse>(jwtResponse, HttpStatus.UNAUTHORIZED);
			}
		}catch (Exception e) {
			mapObj.put("Message", "User not logged in");
			mapObj.put("Token", null);
			return new ResponseEntity<JwtResponse>(jwtResponse, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<JwtResponse>(jwtResponse, HttpStatus.OK);
	}


	@PostMapping("/forget")
	public ResponseEntity<?> forgotPassword(@RequestBody ForgotPassword forgotPassword){
		return (userService.updatePassword(forgotPassword)==true)? new ResponseEntity<ErrorResponse>(new ErrorResponse("Password Updated Successfully",new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK):
				new ResponseEntity<ErrorResponse>(new ErrorResponse("Sorry password was not updated Please check the credentials and try again.",new ResponseEntity<>(HttpStatus.OK)),HttpStatus.OK);
	}
}















