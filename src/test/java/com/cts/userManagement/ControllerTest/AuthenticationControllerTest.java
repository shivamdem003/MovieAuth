//package com.cts.userManagement.ControllerTest;
//
//import com.cts.userManagement.Controller.AuthenticationController;
//import com.cts.userManagement.Model.ForgotPassword;
//import com.cts.userManagement.Model.JwtResponse;
//import com.cts.userManagement.Model.User;
//import com.cts.userManagement.Service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import javax.servlet.ServletException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.when;
//
//public class AuthenticationControllerTest {
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private AuthenticationController authenticationController;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testRegisterUser_SuccessfulRegistration() {
//        // Arrange
//        User user = new User();
//        user.setUsername("testUser");
//        user.setPassword("testPassword");
//        user.setUserRole("user");
//        when(userService.addUser(user)).thenReturn(user);
//
//        // Act
//        ResponseEntity<?> response = authenticationController.registerUser(user);
//
//        // Assert
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(user, response.getBody());
//    }
//
//    @Test
//    void testRegisterUser_RegistrationFailed() {
//        // Arrange
//        User user = new User();
//        user.setUsername("testUser");
//        user.setPassword("testPassword");
//        user.setUserRole("user");
//        when(userService.addUser(user)).thenReturn(null);
//
//        // Act
//        ResponseEntity<?> response = authenticationController.registerUser(user);
//
//        // Assert
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//        assertEquals("user registration failed", response.getBody());
//    }
//
//    @Test
//    void testLoginUser_UserLogin_Successful(){
//        // Arrange
//        User user = new User();
//        user.setUsername("testUser");
//        user.setPassword("testPassword");
//        user.setUserRole("user");
//        when(userService.loginUser(user.getUsername(), user.getPassword(), user.getUserRole())).thenReturn(true);
//        when(userService.findByUserName(user.getUsername())).thenReturn(user);
//
//        // Act
//        ResponseEntity<?> response = authenticationController.logiUser(user);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        JwtResponse jwtResponse = (JwtResponse) response.getBody();
//        assertEquals(user.getUsername(), jwtResponse.getUsername());
//        assertEquals(user.getUserRole(), jwtResponse.getUserRole());
//        assertEquals("User successfully logged in", jwtResponse.getMapObj().get("Message"));
//    }
//
//    @Test
//    void testForgotPassword_PasswordUpdatedSuccessfully() {
//        // Arrange
//        ForgotPassword forgotPassword = new ForgotPassword();
//        when(userService.updatePassword(forgotPassword)).thenReturn(true);
//
//        // Act
//        ResponseEntity<?> response = authenticationController.forgotPassword(forgotPassword);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Password Updated Successfully", response.getBody());
//    }
//
//    @Test
//    void testForgotPassword_PasswordNotUpdated() {
//        // Arrange
//        ForgotPassword forgotPassword = new ForgotPassword();
//        when(userService.updatePassword(forgotPassword)).thenReturn(false);
//
//        // Act
//        ResponseEntity<?> response = authenticationController.forgotPassword(forgotPassword);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Sorry password was not updated Please check the credentials and try again.", response.getBody());
//    }
//
//}
//
