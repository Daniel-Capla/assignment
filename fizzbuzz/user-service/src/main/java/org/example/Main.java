package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User(3, "a1", "Robert"),
                new User(4, "a2", "Martin"),
                new User(5, "a3", "David")));
        Database db = new Database();
        UserDao userDao = new UserDao(db);
        UserService userService = new UserServiceImpl(userDao);

        userService.addUsers(userList);
        userService.printAll();
    }
}