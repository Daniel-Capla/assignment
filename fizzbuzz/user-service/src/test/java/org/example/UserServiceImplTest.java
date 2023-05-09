package org.example;

import org.junit.jupiter.api.AfterEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private UserService userService;
    @Mock
    private UserDao userDaoMock;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userDaoMock);
    }

    @org.junit.jupiter.api.Test
    void addNewListOfUsers() {
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User(3, "a1", "Robert"),
                new User(4, "a2", "Martin"),
                new User(5, "a3", "David")));
        userService.addUsers(userList);
        verify(userDaoMock, times(1));

    }

    @org.junit.jupiter.api.Test
    void printAll() {

    }

    @org.junit.jupiter.api.Test
    void deleteAll() {
    }
}