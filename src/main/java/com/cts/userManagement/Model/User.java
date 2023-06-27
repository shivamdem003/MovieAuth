package com.cts.userManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User 
{	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String userRole;
	private String firstName;
	private String lastName;
	private int contactNumber;
	@Email
	private String email;
	HashMap<String, String> securityQuestion = new HashMap<>();




}
