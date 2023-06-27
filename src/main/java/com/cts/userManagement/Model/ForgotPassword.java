package com.cts.userManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ForgotPassword {

    private String username;
    String password;
    String confirmPassword;
    HashMap<String, String> securityQuestion = new HashMap<>();
}
