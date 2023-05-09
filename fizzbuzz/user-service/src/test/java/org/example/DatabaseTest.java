package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @InjectMocks
    Database dbMock = new Database();

    @BeforeEach
    void setUp() throws SQLException {
        dbMock.addUser(new User(3, "a1", "Maria"));
        dbMock.addUser(new User(4, "a2", "Anne"));
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbMock.deleteAll();
    }

    @Test
    void addUser() throws SQLException {
        dbMock.addUser(new User(10, "t1", "TestUser1"));
        List<User> testUsers = new ArrayList<>(Arrays.asList(
                new User(3, "a1", "Maria"),
                new User(4, "a2", "Anne"),
                new User(10, "t1", "TestUser1")
        ));
        assertEquals(testUsers.toString(), dbMock.printAll().toString());
    }

    @Test
    void printAll() throws SQLException {
        List<User> testUsers = new ArrayList<>(Arrays.asList(
                new User(3, "a1", "Maria"),
                new User(4, "a2", "Anne")
        ));
        assertEquals(testUsers.toString(), dbMock.printAll().toString());
    }
}