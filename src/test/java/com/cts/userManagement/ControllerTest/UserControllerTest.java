//package com.cts.userManagement.ControllerTest;
//
//import com.cts.userManagement.Controller.UserController;
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
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.when;
//
//public class UserControllerTest {
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllUsers_UsersExist() {
//        // Arrange
//        List<User> userList = new ArrayList<>();
//        userList.add(new User());
//        userList.add(new User());
//        when(userService.getAllUsers()).thenReturn(userList);
//
//        // Act
//        ResponseEntity<?> response = userController.getAllUsers();
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userList, response.getBody());
//    }
//
//    @Test
//    void testGetAllUsers_NoUsersExist() {
//        // Arrange
//        when(userService.getAllUsers()).thenReturn(null);
//
//        // Act
//        ResponseEntity<?> response = (ResponseEntity<?>) userService.getAllUsers();
//
//        // Assert
//        assertNull(response);
//    }
//
//}
