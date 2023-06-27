//package com.cts.userManagement.ServiceTest;
//
//import com.cts.userManagement.Model.ForgotPassword;
//import com.cts.userManagement.Model.User;
//import com.cts.userManagement.Repository.UserRepository;
//import com.cts.userManagement.Service.UserServiceImpl;
//import org.apache.kafka.common.protocol.types.Field;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.mockito.Mockito.when;
//
//public class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testAddUser_SuccessfulAddition() {
//        // Arrange
//        User user = new User();
//        when(userRepository.saveAndFlush(user)).thenReturn(user);
//        when(userRepository.findAll()).thenReturn(new ArrayList<>());
//
//        // Act
//        User result = userService.addUser(user);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(user, result);
//    }
//
//    @Test
//    void testLoginUser_ValidCredentials() {
//        // Arrange
//        User user = new User();
//        user.setUsername("testUser");
//        user.setPassword("testPassword");
//        when(userRepository.validateUser(user.getUsername(), user.getPassword())).thenReturn(user);
//
//        // Act
//        boolean result = userService.loginUser(user.getUsername(), user.getPassword(), "user");
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testGetAllUsers_UsersExist() {
//        // Arrange
//        List<User> userList = new ArrayList<>();
//        userList.add(new User());
//        userList.add(new User());
//        when(userRepository.findAll()).thenReturn(userList);
//
//        // Act
//        List<User> result = userService.getAllUsers();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(userList, result);
//    }
//
//    @Test
//    void testGetAllUsers_NoUsersExist() {
//        // Arrange
//        when(userRepository.findAll()).thenReturn(null);
//
//        // Act
//        List<User> result = userService.getAllUsers();
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    void testGetUserById_UserDoesNotExist() {
//        // Arrange
//        when(userRepository.getById(1)).thenReturn(null);
//
//        // Act
//        User result = userService.getUserById(1);
//
//        // Assert
//        assertNull(result);
//    }
//
//    @Test
//    void testUpdatePassword_UserNotFound() {
//        // Arrange
//        ForgotPassword forgotPassword = new ForgotPassword();
//        forgotPassword.setUsername("nonExistingUser");
//
//        // Act
//        boolean result = userService.updatePassword(forgotPassword);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testUpdatePassword_PasswordMismatch() {
//        // Arrange
//        ForgotPassword forgotPassword = new ForgotPassword();
//        forgotPassword.setUsername("testUser");
//        forgotPassword.setPassword("newPassword");
//        forgotPassword.setConfirmPassword("differentPassword");
//        User userFound = new User();
//        userFound.setUsername("testUser");
//
//        when(userRepository.findByUsername(forgotPassword.getUsername())).thenReturn(userFound);
//
//        // Act
//        boolean result = userService.updatePassword(forgotPassword);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void finduserByName_Test() {
//        // Arrange
//        String username="testUser";
//        User found = new User();
//        found.setUsername(username);
//        when(userRepository.findByUsername(username)).thenReturn(found);
//
//        // Act
//        User result=userService.findByUserName(username);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(username, result.getUsername());
//    }
//
//    @Test
//    void testFindByUsername_UserNotFound() {
//        // Arrange
//        String username = "nonExistingUser";
//        when(userRepository.findByUsername(username)).thenReturn(null);
//
//        // Act
//        User result = userService.findByUserName(username);
//
//        // Assert
//        assertNull(result);
//    }
//
//
//
//
//}
