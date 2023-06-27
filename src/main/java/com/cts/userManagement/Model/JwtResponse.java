package com.cts.userManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String username;
    private String userRole;

    private Map<String, String> mapObj;


}
